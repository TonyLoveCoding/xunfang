package team.etop.xunfang.carouselPhotos.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.carouselPhotos.dto.CarouselPhotosDto;
import team.etop.xunfang.carouselPhotos.mapper.CarouselPhotosMapper;
import team.etop.xunfang.carouselPhotos.service.CarouselPhotosService;
import team.etop.xunfang.common.bean.Msg;
import team.etop.xunfang.common.photos.GetName;
import team.etop.xunfang.modules.mapper.CarouselPhotosMapperGenerate;
import team.etop.xunfang.modules.po.CarouselPhotos;
import team.etop.xunfang.modules.service.CarouselPhotosServiceGenerate;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 轮播图Controller
 * Created by asus on 2017/8/9.
 */
@Controller
@RequestMapping("/carouselPhotos")
public class CarouselPhotosController {

    @Autowired
    CarouselPhotosServiceGenerate carouselPhotosServiceGenerate;

    @Value("${adImage.url}")
    private String url;
    @Value("${adImage.savePath}")
    private String savePath;
    @Value("${adImage.minNumber}")
    private int minNumber;
    @Value("${adImage.maxNumber}")
    private int maxNumber;

    @RequestMapping("/query")
    public ModelAndView query(){
        List<CarouselPhotos> clist=carouselPhotosServiceGenerate.selectList(null);
        int count=clist.size();//定义一个count记录当前轮播图片数量
        //到数据库查询轮播图
        List<CarouselPhotosDto> list=new ArrayList<>();
        for(CarouselPhotos p:clist){
            CarouselPhotosDto c=new CarouselPhotosDto();
            c.setUrl(p.getUrl());
            c.setName(savePath+p.getName());
            c.setId(p.getId());
            list.add(c);
        }
        ModelAndView modelAndView=new ModelAndView("/carouselphotos/query");
        modelAndView.addObject("list",list);
        modelAndView.addObject("count",count);
        return modelAndView;
    }

    @RequestMapping("/uplodephotos")
    @ResponseBody
    public Msg uplodePhotos(@RequestParam("files") MultipartFile multipartFile,@RequestParam("cropData")String data,@RequestParam("url")String url) throws Exception{
        System.out.println("进入uplodePhotos方法");
        int c=carouselPhotosServiceGenerate.selectCount(null);
        if(c>=maxNumber){
            return Msg.fail("轮播图片不能多于"+maxNumber+"张");//提示轮播图片不能多于最高上限
        }else {
            String[] datas=data.split("\"|[a-zA-Z]|\\{|\\}|\\:");
            String str="";
            for(String d:datas){
                str+=d;
            }
            String[] strings=str.split(",");
            float x=Float.parseFloat(strings[0]);
            float y=Float.parseFloat(strings[1]);
            float w=Float.parseFloat(strings[2]);
            float h=Float.parseFloat(strings[3]);
            String filename=multipartFile.getOriginalFilename();
            GetName getName=new GetName();
            String name=getName.getName(filename);
            String filepath=savePath+name;
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date=calendar.getTime();
            long times=date.getTime();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            String d=format.format(times);
            date=format.parse(d);
            multipartFile.transferTo(new File(filepath));
            Thumbnails.of(filepath).sourceRegion((int)x,(int)y,(int)w,(int)h).size(540,200).keepAspectRatio(false).toFile(filepath);
            CarouselPhotos carouselPhotos=new CarouselPhotos();
            carouselPhotos.setName(name);
            carouselPhotos.setCreatetime(date);
            carouselPhotos.setStatus(0);
            carouselPhotos.setUrl(url);
            carouselPhotosServiceGenerate.insert(carouselPhotos);
            System.out.println("更新成功");
        }
        return Msg.success();
    }

    @RequestMapping("/deletephoto")
    @ResponseBody
    public Msg deletePhoto(@RequestParam("id")long id){
        int c=carouselPhotosServiceGenerate.selectCount(null);
        if(c<=minNumber){
            return Msg.fail("轮播图片张数不能少于"+minNumber+"张");//提示轮播图片张数不能少于最低下限
        }else{
            CarouselPhotos carouselPhotos=carouselPhotosServiceGenerate.selectById(id);
            File file=new File(savePath+carouselPhotos.getName());
            file.delete();
            System.out.println("本地文件删除成功");
            carouselPhotosServiceGenerate.deleteById(id);
            System.out.println("数据库记录删除成功");
            //从数据库删除与该id对应的图片及记录
            return Msg.success();
        }
    }
}
