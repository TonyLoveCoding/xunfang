package team.etop.xunfang.estate.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.common.bean.PageInfo;
import team.etop.xunfang.common.change.ChangeType;
import team.etop.xunfang.common.obtain.ObtainDic;
import team.etop.xunfang.common.photos.GetName;
import team.etop.xunfang.estate.dto.*;
import team.etop.xunfang.modules.po.*;
import team.etop.xunfang.modules.service.*;
import team.etop.xunfang.search.dto.SearchPageMsg;
import team.etop.xunfang.search.mapper.DicMapper;
import team.etop.xunfang.search.service.DicService;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 楼盘管理Controller
 * 楼盘状态：0代表true,1代表false.
 * 未完成：为用户筛选出自己所管理的楼盘的信息
 * Created by asus on 2017/8/9.
 */
@Controller
@RequestMapping("/estate")
public class EstateController {

    //当前页数
    @Value("${searchPage.PageSize}")
    private int PageSize;
    //每页显示条数
    @Value("${searchPage.countindex}")
    private int countindex;
    //显示的总页数
    @Value("${searchPage.visiblePages}")
    private int visiblePages;
    //楼盘图片保存地址
    @Value("${businessImage.savePath}")
    private String savePath;
    @Value("${businessImage.url}")
    private String imageUrl;

    @Autowired
    EstateServiceGenerate estateServiceGenerate;
    @Autowired
    EffectPictureServiceGenerate effectPictureServiceGenerate;
    @Autowired
    PrototypeRoomPictureServiceGenerate prototypeRoomPictureServiceGenerate;
    @Autowired
    RealEstatePictureServiceGenerate realEstatePictureServiceGenerate;
    @Autowired
    SamplePlanningPictureServiceGenerate samplePlanningPictureServiceGenerate;
    @Autowired
    DicServiceGenerate dicServiceGenerate;

    /**
     * 查找所有楼盘信息（只返回楼盘名，楼盘地址，位置，户型，类型，户型，最低价位，最高价位）
     * @return
     */
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ModelAndView queryEstate(@RequestParam(value = "pn",defaultValue ="1") int current,@RequestParam(value = "keyword",defaultValue = "")String keyword){
        ModelAndView modelAndView=new ModelAndView("/estate/query");
        modelAndView.addObject("keyword",keyword);
        keyword="%"+keyword+"%";
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("estate_name","%"+keyword+"%").or().like("estate_address","%"+keyword+"%").or().like("location","%"+keyword+"%")
                .or().like("type","%"+keyword+"%").or().like("house_type","%"+keyword+"%").orderBy("status");
        Page<Estate> estatePage=new Page<>();
        estatePage.setCurrent(current);
        estatePage.setSize(countindex);
        estatePage.setAsc(false);
        estatePage.setOrderByField("update_Time");
        Page<Estate> page =estateServiceGenerate.selectPage(estatePage,wrapper);
        //获取分页后的楼盘信息
        List<Estate> estateList=page.getRecords();
        //得到总页数
        int pageNum=page.getPages();
        modelAndView.addObject("estateList",estateList);
        modelAndView.addObject("current",current);
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("shownum",countindex);
        return modelAndView;
    }

    /**
     * 查找指定楼盘的具体信息
     * @param id
     * @return
     */
    @RequestMapping("/selectbyid")
    public ModelAndView selectEstateById(@RequestParam("id")long id) throws Exception{
        //根据id从数据库取出对应楼盘信息,必须存放在EstateDto中
        Estate estate=estateServiceGenerate.selectById(id);
        ChangeType changeType=new ChangeType();
        EstateDto estateDto=changeType.change(estate);
        List<EffectPictureDto> effectPictureList=new ArrayList<>();
        List<PrototypeRoomPictureDto> prototypeRoomPictureDtoList=new ArrayList<>();
        List<RealEststePictureDto> realEststePictureDtoList=new ArrayList<>();
        List<SamplePlanningPictureDto> samplePlanningPictureDtoList=new ArrayList<>();
        //图片需要先拆分原本的字符串，通过long l = Long.parseLong([String]);语句得到的id进行查询图片

        //通过拆分字符串，并将其转化为long类型来查询数据库，获得效果图的url，id
        String[] string=estateDto.getEffectivePhotos().split(",");
        for(String str:string){
            long l=Long.parseLong(str);
            EffectPictureDto effectPictureDto=new EffectPictureDto();
            EffectPicture effectPicture=effectPictureServiceGenerate.selectById(l);
            effectPictureDto.setId(l);
            effectPictureDto.setName(imageUrl+effectPicture.getName());
            effectPictureDto.setType("EffectPicture");
            effectPictureList.add(effectPictureDto);
        }
        estateDto.setEffectPictureDtoList(effectPictureList);

        //通过拆分字符串，并将其转化为long类型来查询数据库，获得样板间图的url，id
        String[] PrototypeRoomPictures=estateDto.getPrototypeRoom().split(",");
        for(String str:PrototypeRoomPictures){
            long l=Long.parseLong(str);
            PrototypeRoomPictureDto prototypeRoomPictureDto=new PrototypeRoomPictureDto();
            PrototypeRoomPicture prototypeRoomPicture=prototypeRoomPictureServiceGenerate.selectById(l);
            prototypeRoomPictureDto.setId(l);
            prototypeRoomPictureDto.setName(imageUrl+prototypeRoomPicture.getName());
            prototypeRoomPictureDto.setType("PrototypeRoomPicture");
            prototypeRoomPictureDtoList.add(prototypeRoomPictureDto);
        }
        estateDto.setPrototypeRoomPictureDtoList(prototypeRoomPictureDtoList);

        //通过拆分字符串，并将其转化为long类型来查询数据库，获得实景图的url，id
        String[] RealEststePictures=estateDto.getLiveAction().split(",");
        for(String str:RealEststePictures){
            long l=Long.parseLong(str);
            RealEststePictureDto realEststePictureDto=new RealEststePictureDto();
            RealEstatePicture realEstatePicture=realEstatePictureServiceGenerate.selectById(l);
            realEststePictureDto.setId(l);
            realEststePictureDto.setName(imageUrl+realEstatePicture.getName());
            realEststePictureDto.setType("RealEstatePicture");
            realEststePictureDtoList.add(realEststePictureDto);
        }
        estateDto.setRealEststePictureDtoList(realEststePictureDtoList);

        //通过拆分字符串，并将其转化为long类型来查询数据库，获得样板规划图的url，id
        String[] SamplePlanningPictures=estateDto.getSamplePlate().split(",");
        for(String str:SamplePlanningPictures){
            long l=Long.parseLong(str);
            SamplePlanningPictureDto samplePlanningPictureDto=new SamplePlanningPictureDto();
            SamplePlanningPicture samplePlanningPicture=samplePlanningPictureServiceGenerate.selectById(l);
            samplePlanningPictureDto.setId(l);
            samplePlanningPictureDto.setName(imageUrl+samplePlanningPicture.getName());
            samplePlanningPictureDto.setType("SamplePlanningPicture");
            samplePlanningPictureDtoList.add(samplePlanningPictureDto);
        }
        estateDto.setSamplePlanningPictureDtoList(samplePlanningPictureDtoList);

        int esize=0;
        int psize=0;
        int rsize=0;
        int ssize=0;
        if(!effectPictureList.get(0).getName().equals(imageUrl+"0.jpg") || effectPictureList.size()!=1){
            esize=effectPictureList.size();
        }
        if(!prototypeRoomPictureDtoList.get(0).getName().equals(imageUrl+"0.jpg") || prototypeRoomPictureDtoList.size()!=1){
            psize=prototypeRoomPictureDtoList.size();
        }
        if(!realEststePictureDtoList.get(0).getName().equals(imageUrl+"0.jpg") || realEststePictureDtoList.size()!=1){
            rsize=realEststePictureDtoList.size();
        }
        if(!samplePlanningPictureDtoList.get(0).getName().equals(imageUrl+"0.jpg") || samplePlanningPictureDtoList.size()!=1){
            ssize=samplePlanningPictureDtoList.size();
        }
        ModelAndView modelAndView=new ModelAndView("/estate/selectbyid");
        modelAndView.addObject("EstateDto",estateDto);
        modelAndView.addObject("esize",esize);
        modelAndView.addObject("psize",psize);
        modelAndView.addObject("rsize",rsize);
        modelAndView.addObject("ssize",ssize);
        return modelAndView;
    }

    /**
     * 修改楼盘信息（应该有一个get方法，一个post方法）
     * @param id
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateEstate(@RequestParam("id")long id) throws Exception{
        Estate estate=estateServiceGenerate.selectById(id);
        ChangeType changeType=new ChangeType();
        EstateDto estateDto=changeType.change(estate);

        EntityWrapper<Dic> locationWrapper=new EntityWrapper<>();
        locationWrapper.where("type = {0}","location").orderBy("weight",false);
        List<Dic> dic_location=dicServiceGenerate.selectList(locationWrapper);

        EntityWrapper<Dic> featureWrapper=new EntityWrapper<>();
        featureWrapper.where("type = {0}","feature").orderBy("weight",false);
        List<Dic> dic_feature=dicServiceGenerate.selectList(featureWrapper);

        EntityWrapper<Dic> houseTypeWrapper=new EntityWrapper<>();
        houseTypeWrapper.where("type = {0}","houseType").orderBy("weight",false);
        List<Dic> dic_houseType=dicServiceGenerate.selectList(houseTypeWrapper);

        EntityWrapper<Dic> typeWrapper=new EntityWrapper<>();
        typeWrapper.where("type = {0}","type").orderBy("weight",false);
        List<Dic> dic_type=dicServiceGenerate.selectList(typeWrapper);

        ModelAndView modelAndView=new ModelAndView("/estate/update");
        modelAndView.addObject("EstateDto",estateDto);
        modelAndView.addObject("dic_location",dic_location);
        modelAndView.addObject("dic_feature",dic_feature);
        modelAndView.addObject("dic_houseType",dic_houseType);
        modelAndView.addObject("dic_type",dic_type);
        return modelAndView;
    }

    /**
     * 删除楼盘信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteEstate(@RequestParam("id")long id){
        Estate estate=estateServiceGenerate.selectById(id);
        if(estate.getStatus()==1){
            return Msg.fail("该楼盘以处于无用状态");
        }
        //通过id句数据库中的对应信息的状态置为1，并存入数据库
        estate.setStatus(1);
        estateServiceGenerate.insertOrUpdate(estate);
        //调用queryEstate()方法用以刷新页面
        return Msg.success();
    }


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addEstateView()throws Exception{
        EstateDto estateDto=new EstateDto();

        EntityWrapper<Dic> locationWrapper=new EntityWrapper<>();
        locationWrapper.where("type = {0}","location").orderBy("weight",false);
        List<Dic> dic_location=dicServiceGenerate.selectList(locationWrapper);

        EntityWrapper<Dic> featureWrapper=new EntityWrapper<>();
        featureWrapper.where("type = {0}","feature").orderBy("weight",false);
        List<Dic> dic_feature=dicServiceGenerate.selectList(featureWrapper);

        EntityWrapper<Dic> houseTypeWrapper=new EntityWrapper<>();
        houseTypeWrapper.where("type = {0}","houseType").orderBy("weight",false);
        List<Dic> dic_houseType=dicServiceGenerate.selectList(houseTypeWrapper);

        EntityWrapper<Dic> typeWrapper=new EntityWrapper<>();
        typeWrapper.where("type = {0}","type").orderBy("weight",false);
        List<Dic> dic_type=dicServiceGenerate.selectList(typeWrapper);

        ModelAndView modelAndView=new ModelAndView("/estate/add");
        modelAndView.addObject("EstateDto",estateDto);
        modelAndView.addObject("dic_location",dic_location);
        modelAndView.addObject("dic_feature",dic_feature);
        modelAndView.addObject("dic_houseType",dic_houseType);
        modelAndView.addObject("dic_type",dic_type);
        return modelAndView;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView updateEstate(EstateDto estateDto) throws Exception{
        ChangeType changeType=new ChangeType();
        Estate estate=changeType.change(estateDto);
        estateServiceGenerate.insertOrUpdate(estate);
        return queryEstate(1,"");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addEstate(EstateDto estateDto) throws Exception{
        ChangeType changeType=new ChangeType();
        Estate estate=changeType.Add_Change(estateDto);
        estate.setStatus(0);
        estate.setVisitTimes((long)0);
        estate.setTurnover(0);
        estate.setThumbnail("0.jpg");
        estate.setEffectivePhotos("0");
        estate.setPrototypeRoom("0");
        estate.setSamplePlate("0");
        estate.setLiveAction("0");
        estateServiceGenerate.insertOrUpdate(estate);
        System.out.println("添加成功");
        return queryEstate(1,"");
    }

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public ModelAndView upload(@RequestParam("id")long id) throws Exception{
        Estate estate=estateServiceGenerate.selectById(id);
        ChangeType c=new ChangeType();
        EstateDto estateDto=c.change(estate);
        List<EffectPictureDto> effectPictureList=new ArrayList<>();
        List<PrototypeRoomPictureDto> prototypeRoomPictureDtoList=new ArrayList<>();
        List<RealEststePictureDto> realEststePictureDtoList=new ArrayList<>();
        List<SamplePlanningPictureDto> samplePlanningPictureDtoList=new ArrayList<>();
        //图片需要先拆分原本的字符串，通过long l = Long.parseLong([String]);语句得到的id进行查询图片

        //通过拆分字符串，并将其转化为long类型来查询数据库，获得效果图的url，id
        String[] string=estateDto.getEffectivePhotos().split(",");
        for(String str:string){
            long l=Long.parseLong(str);
            EffectPictureDto effectPictureDto=new EffectPictureDto();
            EffectPicture effectPicture=effectPictureServiceGenerate.selectById(l);
            effectPictureDto.setId(l);
            effectPictureDto.setName(imageUrl+effectPicture.getName());
            effectPictureDto.setType("EffectPicture");
            effectPictureList.add(effectPictureDto);
        }
        estateDto.setEffectPictureDtoList(effectPictureList);

        //通过拆分字符串，并将其转化为long类型来查询数据库，获得样板间图的url，id
        String[] PrototypeRoomPictures=estateDto.getPrototypeRoom().split(",");
        for(String str:PrototypeRoomPictures){
            long l=Long.parseLong(str);
            PrototypeRoomPictureDto prototypeRoomPictureDto=new PrototypeRoomPictureDto();
            PrototypeRoomPicture prototypeRoomPicture=prototypeRoomPictureServiceGenerate.selectById(l);
            prototypeRoomPictureDto.setId(l);
            prototypeRoomPictureDto.setName(imageUrl+prototypeRoomPicture.getName());
            prototypeRoomPictureDto.setType("PrototypeRoomPicture");
            prototypeRoomPictureDtoList.add(prototypeRoomPictureDto);
        }
        estateDto.setPrototypeRoomPictureDtoList(prototypeRoomPictureDtoList);

        //通过拆分字符串，并将其转化为long类型来查询数据库，获得实景图的url，id
        String[] RealEststePictures=estateDto.getLiveAction().split(",");
        for(String str:RealEststePictures){
            long l=Long.parseLong(str);
            RealEststePictureDto realEststePictureDto=new RealEststePictureDto();
            RealEstatePicture realEstatePicture=realEstatePictureServiceGenerate.selectById(l);
            realEststePictureDto.setId(l);
            realEststePictureDto.setName(imageUrl+realEstatePicture.getName());
            realEststePictureDto.setType("RealEstatePicture");
            realEststePictureDtoList.add(realEststePictureDto);
        }
        estateDto.setRealEststePictureDtoList(realEststePictureDtoList);

        //通过拆分字符串，并将其转化为long类型来查询数据库，获得样板规划图的url，id
        String[] SamplePlanningPictures=estateDto.getSamplePlate().split(",");
        for(String str:SamplePlanningPictures){
            long l=Long.parseLong(str);
            SamplePlanningPictureDto samplePlanningPictureDto=new SamplePlanningPictureDto();
            SamplePlanningPicture samplePlanningPicture=samplePlanningPictureServiceGenerate.selectById(l);
            samplePlanningPictureDto.setId(l);
            samplePlanningPictureDto.setName(imageUrl+samplePlanningPicture.getName());
            samplePlanningPictureDto.setType("SamplePlanningPicture");
            samplePlanningPictureDtoList.add(samplePlanningPictureDto);
        }
        estateDto.setSamplePlanningPictureDtoList(samplePlanningPictureDtoList);

        int esize=0;
        int psize=0;
        int rsize=0;
        int ssize=0;
        if(!effectPictureList.get(0).getName().equals(imageUrl+"0.jpg") || effectPictureList.size()!=1){
            esize=effectPictureList.size();
        }
        if(!prototypeRoomPictureDtoList.get(0).getName().equals(imageUrl+"0.jpg") || prototypeRoomPictureDtoList.size()!=1){
            psize=prototypeRoomPictureDtoList.size();
        }
        if(!realEststePictureDtoList.get(0).getName().equals(imageUrl+"0.jpg") || realEststePictureDtoList.size()!=1){
            rsize=realEststePictureDtoList.size();
        }
        if(!samplePlanningPictureDtoList.get(0).getName().equals(imageUrl+"0.jpg") || samplePlanningPictureDtoList.size()!=1){
            ssize=samplePlanningPictureDtoList.size();
        }
        ModelAndView modelAndView=new ModelAndView("/estate/photos");
        modelAndView.addObject("EstateDto",estateDto);
        modelAndView.addObject("esize",esize);
        modelAndView.addObject("psize",psize);
        modelAndView.addObject("rsize",rsize);
        modelAndView.addObject("ssize",ssize);
        return modelAndView;
    }

    @RequestMapping(value = "/saveEffectPicture",method = RequestMethod.POST)
    public ModelAndView saveEffectPicture(@RequestParam("files") MultipartFile[] multipartFile,@RequestParam("id")long id) throws Exception{
        System.out.println(id);
        String ids="";
        String k="";
        EntityWrapper<EffectPicture> wrapper=new EntityWrapper<>();
        for(MultipartFile f:multipartFile){
            EffectPicture picture=new EffectPicture();
            GetName getName=new GetName();
            String name=getName.getName(f.getOriginalFilename());
            String filepath=savePath+name;
            File file=new File(filepath);
            f.transferTo(file);
            picture.setName(name);
            picture.setWeight(ThreadLocalRandom.current().nextLong());
            effectPictureServiceGenerate.insert(picture);
            wrapper.where("name = {0}",name);
            picture.setId((Long)effectPictureServiceGenerate.selectObj(wrapper));
            ids+=k;
            ids+=picture.getId();
            k=",";
        }
        Estate estate=estateServiceGenerate.selectById(id);
        String s=estate.getEffectivePhotos();
        if(s.length()!=0 && (!s.equals("0"))){
            ids=s+","+ids;
        }
        estate.setEffectivePhotos(ids);
        estateServiceGenerate.insertOrUpdate(estate);
        System.out.println("完成");

        return upload(id);
    }

    @RequestMapping(value = "/savePrototypeRoomPicture",method = RequestMethod.POST)
    public ModelAndView savePrototypeRoomPicture(@RequestParam("files") MultipartFile[] multipartFile,@RequestParam("id")long id)throws Exception{
        String ids="";
        String k="";
        EntityWrapper<PrototypeRoomPicture> wrapper=new EntityWrapper<>();
        for(MultipartFile f:multipartFile){
            PrototypeRoomPicture picture=new PrototypeRoomPicture();
            GetName getName=new GetName();
            String name=getName.getName(f.getOriginalFilename());
            String filepath=savePath+name;
            File file=new File(filepath);
            f.transferTo(file);
            picture.setName(name);
            picture.setWeight(ThreadLocalRandom.current().nextLong());
            prototypeRoomPictureServiceGenerate.insert(picture);
            wrapper.where("name = {0}",name);
            picture.setId((Long)prototypeRoomPictureServiceGenerate.selectObj(wrapper));
            ids+=k;
            ids+=picture.getId();
            k=",";
        }
        Estate estate=estateServiceGenerate.selectById(id);
        String s=estate.getPrototypeRoom();
        if(s.length()!=0 && !s.equals("0")){
            ids=s+","+ids;
        }
        estate.setPrototypeRoom(ids);
        estateServiceGenerate.insertOrUpdate(estate);
        System.out.println("完成");
//        return Msg.success();
        return upload(id);
    }

    @RequestMapping(value = "/saveRealEststePicture",method = RequestMethod.POST)
    public ModelAndView saveRealEststePicture(@RequestParam("files") MultipartFile[] multipartFile,@RequestParam("id")long id)throws Exception{
        String ids="";
        String k="";
        EntityWrapper<RealEstatePicture> wrapper=new EntityWrapper<>();
        for(MultipartFile f:multipartFile){
            RealEstatePicture picture=new RealEstatePicture();
            GetName getName=new GetName();
            String name=getName.getName(f.getOriginalFilename());
            String filepath=savePath+name;
            File file=new File(filepath);
            f.transferTo(file);
            picture.setName(name);
            picture.setWeight(ThreadLocalRandom.current().nextLong());
            realEstatePictureServiceGenerate.insert(picture);
            wrapper.where("name = {0}",name);
            picture.setId((Long)realEstatePictureServiceGenerate.selectObj(wrapper));
            ids+=k;
            ids+=picture.getId();
            k=",";
        }
        Estate estate=estateServiceGenerate.selectById(id);
        String s=estate.getLiveAction();
        if(s.length()!=0 && !s.equals("0")){
            ids=s+","+ids;
        }
        estate.setLiveAction(ids);
        estateServiceGenerate.insertOrUpdate(estate);
        System.out.println("完成");
//        return Msg.success();
        return upload(id);
    }

    @RequestMapping(value = "/saveSamplePlanningPicture",method = RequestMethod.POST)
    public ModelAndView saveSamplePlanningPicture(@RequestParam("files") MultipartFile[] multipartFile,@RequestParam("id")long id)throws Exception{
        String ids="";
        String k="";
        EntityWrapper<SamplePlanningPicture> wrapper=new EntityWrapper<>();
        for(MultipartFile f:multipartFile){
            SamplePlanningPicture picture=new SamplePlanningPicture();
            GetName getName=new GetName();
            String name=getName.getName(f.getOriginalFilename());
            String filepath=savePath+name;
            File file=new File(filepath);
            f.transferTo(file);
            picture.setName(name);
            picture.setWeight(ThreadLocalRandom.current().nextLong());
            samplePlanningPictureServiceGenerate.insert(picture);
            wrapper.where("name = {0}",name);
            picture.setId((Long)samplePlanningPictureServiceGenerate.selectObj(wrapper));
            ids+=k;
            ids+=picture.getId();
            k=",";
        }
        Estate estate=estateServiceGenerate.selectById(id);
        String s=estate.getSamplePlate();
        if(s.length()!=0 && !s.equals("0")){
            ids=s+","+ids;
        }
        estate.setSamplePlate(ids);
        estateServiceGenerate.insertOrUpdate(estate);
        System.out.println("完成");
//        return Msg.success();
        return upload(id);
    }

    @RequestMapping(value = "/deleteEffectPicture",method = RequestMethod.POST)
    @ResponseBody
    public Msg deleteEffectPicture(@RequestParam("id")Long id){
        EffectPicture picture=effectPictureServiceGenerate.selectById(id);
        String path=savePath+picture.getName();
        effectPictureServiceGenerate.deleteById(id);
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("effective_photos","%"+id+"%");
        Estate estate=estateServiceGenerate.selectOne(wrapper);
        String s=estate.getEffectivePhotos();
        String sub=""+id;
        int i=s.indexOf(sub);
        if(s.length()==sub.length()){
            s="0";
        }else if(i==0){
            sub=sub+",";
            s=s.replace(sub,"");
        }else {
            sub=","+sub;
            s=s.replace(sub,"");
        }
        estate.setEffectivePhotos(s);
        estateServiceGenerate.insertOrUpdate(estate);
        File file=new File(path);
        file.delete();
        return Msg.success("删除成功");
    }

    @RequestMapping(value = "/deletePrototypeRoomPicture",method = RequestMethod.POST)
    @ResponseBody
    public Msg deletePrototypeRoomPicture(@RequestParam("id")Long id){
        PrototypeRoomPicture picture=prototypeRoomPictureServiceGenerate.selectById(id);
        String path=savePath+picture.getName();
        prototypeRoomPictureServiceGenerate.deleteById(id);
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("prototype_room","%"+id+"%");
        Estate estate=estateServiceGenerate.selectOne(wrapper);
        String s=estate.getPrototypeRoom();
        String sub=""+id;
        int i=s.indexOf(sub);
        if(s.length()==sub.length()){
            s="0";
        }else if(i==0){
            sub=sub+",";
            s=s.replace(sub,"");
        }else {
            sub=","+sub;
            s=s.replace(sub,"");
        }
        estate.setPrototypeRoom(s);
        estateServiceGenerate.insertOrUpdate(estate);
        File file=new File(path);
        file.delete();
        return Msg.success("删除成功");
    }

    @RequestMapping(value = "/deleteRealEststePicture",method = RequestMethod.POST)
    @ResponseBody
    public Msg deleteRealEststePicture(@RequestParam("id")Long id){
        RealEstatePicture picture=realEstatePictureServiceGenerate.selectById(id);
        String path=savePath+picture.getName();
        realEstatePictureServiceGenerate.deleteById(id);
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("live_action","%"+id+"%");
        Estate estate=estateServiceGenerate.selectOne(wrapper);
        String s=estate.getLiveAction();
        String sub=""+id;
        int i=s.indexOf(sub);
        if(s.length()==sub.length()){
            s="0";
        }else if(i==0){
            sub=sub+",";
            s=s.replace(sub,"");
        }else {
            sub=","+sub;
            s=s.replace(sub,"");
        }
        estate.setLiveAction(s);
        estateServiceGenerate.insertOrUpdate(estate);
        File file=new File(path);
        file.delete();
        return Msg.success("删除成功");
    }

    @RequestMapping(value = "/deleteSamplePlanningPicture",method = RequestMethod.POST)
    @ResponseBody
    public Msg deleteSamplePlanningPicture(@RequestParam("id")Long id){
        SamplePlanningPicture picture=samplePlanningPictureServiceGenerate.selectById(id);
        String path=savePath+picture.getName();
        samplePlanningPictureServiceGenerate.deleteById(id);
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("sample_plate","%"+id+"%");
        Estate estate=estateServiceGenerate.selectOne(wrapper);
        String s=estate.getSamplePlate();
        String sub=""+id;
        int i=s.indexOf(sub);
        if(s.length()==sub.length()){
            s="0";
        }else if(i==0){
            sub=sub+",";
            s=s.replace(sub,"");
        }else {
            sub=","+sub;
            s=s.replace(sub,"");
        }
        estate.setSamplePlate(s);
        estateServiceGenerate.insertOrUpdate(estate);
        File file=new File(path);
        file.delete();
        return Msg.success("删除成功");
    }

    @RequestMapping("/moveEffectPicture")
    @ResponseBody
    public Msg moveEffectPicture(@RequestParam("id")Long id,@RequestParam("direction")int direction){
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("effective_photos","%"+id+"%");
        Estate estate=estateServiceGenerate.selectOne(wrapper);
        String[] string=estate.getEffectivePhotos().split(",");
        List<String> list=new ArrayList(Arrays.asList(string));
        int i=list.indexOf(""+id);
        switch (direction){
            case -1:
                if(i==0){
                    return Msg.success("无法往前移动");
                }else {
                    String s=list.get((i-1));
                    list.set((i-1),list.get(i));
                    list.set(i,s);
                }
                break;
            case 1:
                if(i==list.size()){
                    return Msg.success("无法往后移动");
                }else {
                    String s=list.get((i+1));
                    list.set((i+1),list.get(i));
                    list.set(i,s);
                }
                break;
        }
        String effectivePhotos="";
        String k="";
        for(String o:list){
            effectivePhotos+=k;
            effectivePhotos+=o;
            k=",";
        }
        estate.setEffectivePhotos(effectivePhotos);
        estateServiceGenerate.insertOrUpdate(estate);
        return Msg.success();
    }

    @RequestMapping("/movePrototypeRoomPicture")
    @ResponseBody
    public Msg movePrototypeRoomPicture(@RequestParam("id")Long id,@RequestParam("direction")int direction){
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("prototype_room","%"+id+"%");
        Estate estate=estateServiceGenerate.selectOne(wrapper);
        String[] string=estate.getPrototypeRoom().split(",");
        List<String> list=new ArrayList(Arrays.asList(string));
        int i=list.indexOf(""+id);
        switch (direction){
            case -1:
                if(i==0){
                    return Msg.success("无法往前移动");
                }else {
                    String s=list.get((i-1));
                    list.set((i-1),list.get(i));
                    list.set(i,s);
                }
                break;
            case 1:
                if(i==list.size()){
                    return Msg.success("无法往后移动");
                }else {
                    String s=list.get((i+1));
                    list.set((i+1),list.get(i));
                    list.set(i,s);
                }
                break;
        }
        String prototypeRoom ="";
        String k="";
        for(String o:list){
            prototypeRoom+=k;
            prototypeRoom+=o;
            k=",";
        }
        estate.setPrototypeRoom(prototypeRoom);
        estateServiceGenerate.insertOrUpdate(estate);
        return Msg.success();
    }

    @RequestMapping("/moveRealEststePicture")
    @ResponseBody
    public Msg moveRealEststePicture(@RequestParam("id")Long id,@RequestParam("direction")int direction){
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("live_action","%"+id+"%");
        Estate estate=estateServiceGenerate.selectOne(wrapper);
        String[] string=estate.getLiveAction().split(",");
        List<String> list=new ArrayList(Arrays.asList(string));
        int i=list.indexOf(""+id);
        switch (direction){
            case -1:
                if(i==0){
                    return Msg.success("无法往前移动");
                }else {
                    String s=list.get((i-1));
                    list.set((i-1),list.get(i));
                    list.set(i,s);
                }
                break;
            case 1:
                if((i+1)==list.size()){
                    return Msg.success("无法往后移动");
                }else {
                    String s=list.get((i+1));
                    list.set((i+1),list.get(i));
                    list.set(i,s);
                }
                break;
        }
        String realEststePicture="";
        String k="";
        for(String o:list){
            realEststePicture+=k;
            realEststePicture+=o;
            k=",";
        }
        estate.setLiveAction(realEststePicture);
        estateServiceGenerate.insertOrUpdate(estate);
        return Msg.success();
    }

    @RequestMapping("/moveSamplePlanningPicture")
    @ResponseBody
    public Msg moveSamplePlanningPicture(@RequestParam("id")Long id,@RequestParam("direction")int direction){
        EntityWrapper<Estate> wrapper=new EntityWrapper<>();
        wrapper.like("sample_plate","%"+id+"%");
        Estate estate=estateServiceGenerate.selectOne(wrapper);
        String[] string=estate.getSamplePlate().split(",");
        List<String> list=new ArrayList(Arrays.asList(string));
        int i=list.indexOf(""+id);
        switch (direction){
            case -1:
                if(i==0){
                    return Msg.success("无法往前移动");
                }else {
                    String s=list.get((i-1));
                    list.set((i-1),list.get(i));
                    list.set(i,s);
                }
                break;
            case 1:
                if(i==list.size()){
                    return Msg.success("无法往后移动");
                }else {
                    String s=list.get((i+1));
                    list.set((i+1),list.get(i));
                    list.set(i,s);
                }
                break;
        }
        String samplePlanningPicture="";
        String k="";
        for(String o:list){
            samplePlanningPicture+=k;
            samplePlanningPicture+=o;
            k=",";
        }
        estate.setSamplePlate(samplePlanningPicture);
        estateServiceGenerate.insertOrUpdate(estate);
        return Msg.success();
    }
}
