package team.etop.xunfang.estate.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.PageInfo;
import team.etop.xunfang.estate.dto.*;
import team.etop.xunfang.modules.po.Estate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Long PageSize;
    //每页显示条数
    @Value("${searchPage.countindex}")
    private Long countindex;
    //显示的总页数
    @Value("${searchPage.visiblePages}")
    private Long visiblePages;
    //楼盘图片保存地址
    @Value("${businessImage.savePath}")
    private String savePath;

    /**
     * 查找所有楼盘信息（只返回楼盘名，楼盘地址，位置，户型，类型，户型，最低价位，最高价位）
     * @param pageNum
     * @return
     */
    @RequestMapping("/query")
    public ModelAndView queryEstate(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){
        List<Estate> estateList=new ArrayList<>();
        PageInfo pageInfo = new PageInfo(PageSize, countindex, visiblePages, PageSize * visiblePages, 1L);
        //从数据库取出
        for(int i=0;i<13;i++){
            Estate estate=new Estate();
            estate.setId((long)i);
            estate.setEstateName("楼盘名："+i);
            estate.setStatus(0);
            estate.setEstateAddress("楼盘地址："+i);
            estate.setLocation("位置："+i);
            estate.setType("类型："+i);
            estate.setHouseType("户型："+i);
            estate.setMinPrice(i);
            estate.setMaxPrice(i);
            estateList.add(estate);
            System.out.println(estate);
        }
        ModelAndView modelAndView=new ModelAndView("/estate/query");
        modelAndView.addObject("estateList",estateList);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    /**
     * 查找指定楼盘的具体信息
     * @param id
     * @return
     */
    @RequestMapping("/selectbyid")
    public ModelAndView selectEstateById(@RequestParam("id")long id){
        //根据id从数据库取出对应楼盘信息,必须存放在EstateDto中
        System.out.println(id);
        EstateDto estateDto=new EstateDto();
        List<EffectPictureDto> effectPictureList=new ArrayList<>();
        List<PrototypeRoomPictureDto> prototypeRoomPictureDtoList=new ArrayList<>();
        List<RealEststePictureDto> realEststePictureDtoList=new ArrayList<>();
        List<SamplePlanningPictureDto> samplePlanningPictureDtoList=new ArrayList<>();
        estateDto.setId(id);
        estateDto.setStatus(0);
        estateDto.setEstateName("楼盘名称");
        estateDto.setGreenRate((float)70);
        estateDto.setStatus(0);
        estateDto.setPropertyRights("70年");
        estateDto.setVisitTimes(id);
        estateDto.setMinPrice(123);
        estateDto.setMaxPrice(123);
        Date date=new Date();
        DateFormat dateFormat=DateFormat.getDateTimeInstance();
        String datetime=dateFormat.format(date);
        try{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            date=simpleDateFormat.parse(datetime);
            estateDto.setCreateTime(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        //图片需要先拆分原本的字符串，通过long l = Long.parseLong([String]);语句得到的id进行查询图片
        for(int i=0;i<7;i++){
            EffectPictureDto effectPictureDto=new EffectPictureDto();
            effectPictureDto.setName("1.png");
            String effectpicture=savePath+effectPictureDto.getName();
            effectPictureDto.setName(effectpicture);
            effectPictureList.add(effectPictureDto);
            estateDto.setEffectPictureDtoList(effectPictureList);
        }
        for(int i=0;i<3;i++){
            PrototypeRoomPictureDto prototypeRoomPictureDto=new PrototypeRoomPictureDto();
            prototypeRoomPictureDto.setName("1.png");
            String prototypeRoomPicture=savePath+prototypeRoomPictureDto.getName();
            prototypeRoomPictureDto.setName(prototypeRoomPicture);
            prototypeRoomPictureDtoList.add(prototypeRoomPictureDto);
            estateDto.setPrototypeRoomPictureDtoList(prototypeRoomPictureDtoList);
        }
        for(int i=0;i<2;i++){
            RealEststePictureDto realEststePictureDto=new RealEststePictureDto();
            realEststePictureDto.setName("1.png");
            String realEststepicture=savePath+realEststePictureDto.getName();
            realEststePictureDto.setName(realEststepicture);
            realEststePictureDtoList.add(realEststePictureDto);
            estateDto.setRealEststePictureDtoList(realEststePictureDtoList);
        }
        for(int i=0;i<1;i++){
            SamplePlanningPictureDto samplePlanningPictureDto=new SamplePlanningPictureDto();
            samplePlanningPictureDto.setName("1.png");
            String samplePlanningpicture=savePath+samplePlanningPictureDto.getName();
            samplePlanningPictureDto.setName(samplePlanningpicture);
            samplePlanningPictureDtoList.add(samplePlanningPictureDto);
            estateDto.setSamplePlanningPictureDtoList(samplePlanningPictureDtoList);
        }
        int esize=effectPictureList.size();
        int psize=prototypeRoomPictureDtoList.size();
        int rsize=realEststePictureDtoList.size();
        int ssize=samplePlanningPictureDtoList.size();
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
    @RequestMapping("/update")
    public ModelAndView updateEstate(@RequestParam("id")long id){
        Date date=new Date();
        EstateDto estateDto=new EstateDto();
        DateFormat dateFormat=DateFormat.getDateTimeInstance();
        String datetime=dateFormat.format(date);
        try{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            date=simpleDateFormat.parse(datetime);
            estateDto.setCreateTime(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        List<EffectPictureDto> effectPictureDtoList=estateDto.getEffectPictureDtoList();
        for(EffectPictureDto e:effectPictureDtoList){
            e.setName("7867759.jpg");
            String effectpicture="http://othgjp7hs.bkt.clouddn.com/17-8-9/"+e.getName();
            e.setName(effectpicture);
            //将e存入对应的数据库
        }
        //将其余的图片模块按照上面的方法存入对应模块
        //调用queryEstate()方法用以刷新页面
        this.queryEstate(1);
        return  null;
    }

    /**
     * 搜索楼盘信息
     * 需要用到mp的模糊查找
     * @param tip
     * @param pageNum
     * @return
     */
    @RequestMapping("/search")
    public ModelAndView searchEstates(@RequestParam("tip")String tip,@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){
        List<Estate> estateList=new ArrayList<>();
        PageInfo pageInfo = new PageInfo(PageSize, countindex, visiblePages, PageSize * visiblePages, 1L);
        //从数据库取出符合条件的所有信息
        for(int i=0;i<13;i++){
            Estate estate=new Estate();
            estate.setEstateName("楼盘名："+i);
            estate.setStatus(0);
            estate.setEstateAddress("楼盘地址："+i);
            estate.setLocation("位置："+i);
            estate.setType("类型："+i);
            estate.setHouseType("户型："+i);
            estateList.add(estate);
        }
        ModelAndView modelAndView=new ModelAndView("/estate/search");
        modelAndView.addObject("estateList",estateList);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    /**
     * 删除楼盘信息
     * @param id
     * @param pageNum
     * @return
     */
    @RequestMapping("/delete")
    public ModelAndView deleteEstate(@RequestParam("id")long id,@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){
        //通过id句数据库中的对应信息的状态置为1，并存入数据库
        //调用queryEstate()方法用以刷新页面
        this.queryEstate(1);
        return null;
    }

    @RequestMapping("/update1")
    public ModelAndView updateEstatedemo(@RequestParam("id")long id){
        List<EffectPictureDto> effectPictureList=new ArrayList<>();
        List<PrototypeRoomPictureDto> prototypeRoomPictureDtoList=new ArrayList<>();
        List<RealEststePictureDto> realEststePictureDtoList=new ArrayList<>();
        List<SamplePlanningPictureDto> samplePlanningPictureDtoList=new ArrayList<>();
//        System.out.println("楼盘id"+id);
        EstateDto estateDto=new EstateDto();
        estateDto.setId(id);
        estateDto.setStatus(0);
        estateDto.setEstateName("楼盘名称");
        estateDto.setGreenRate((float)70);
        estateDto.setStatus(0);
        estateDto.setPropertyRights("70年");
        estateDto.setVisitTimes(id);
        estateDto.setMinPrice(123);
        estateDto.setMaxPrice(123);
//        System.out.println(estateDto);
        for(int i=0;i<7;i++){
            EffectPictureDto effectPictureDto=new EffectPictureDto();
            effectPictureDto.setName("1.png");
            String effectpicture=savePath+effectPictureDto.getName();
            effectPictureDto.setName(effectpicture);
            effectPictureList.add(effectPictureDto);
            estateDto.setEffectPictureDtoList(effectPictureList);
        }
        int esize=effectPictureList.size();
        ModelAndView modelAndView=new ModelAndView("/estate/update");
        int psize=prototypeRoomPictureDtoList.size();
        int rsize=realEststePictureDtoList.size();
        int ssize=samplePlanningPictureDtoList.size();
        estateDto.setPrototypeRoomPictureDtoList(prototypeRoomPictureDtoList);
        estateDto.setRealEststePictureDtoList(realEststePictureDtoList);
        estateDto.setSamplePlanningPictureDtoList(samplePlanningPictureDtoList);
        modelAndView.addObject("psize",psize);
        modelAndView.addObject("rsize",rsize);
        modelAndView.addObject("ssize",ssize);
        modelAndView.addObject("EstateDto",estateDto);
        modelAndView.addObject("esize",esize);
        return  modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView addEstate(EstateDto estateDto){
        Date date=new Date();
        estateDto.setUpdateTime(date);
        //存入数据库
        ModelAndView modelAndView=new ModelAndView("/estate/add");
        return modelAndView;
    }
}
