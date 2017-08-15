package team.etop.xunfang.carouselPhotos.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.carouselPhotos.dto.CarouselPhotosDto;
import team.etop.xunfang.modules.po.CarouselPhotos;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 轮播图Controller
 * Created by asus on 2017/8/9.
 */
@Controller
@RequestMapping("/carouselPhotos")
public class CarouselPhotosController {

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
        List<CarouselPhotos> list=new ArrayList<>();
        int count=0;//定义一个count记录当前轮播图片数量
        //到数据库查询轮播图
        CarouselPhotos carouselPhotos1=new CarouselPhotos();
        carouselPhotos1.setName("70965672.jpg");
        //拼接图片存储地址
        String name1="http://othgjp7hs.bkt.clouddn.com/17-8-9/"+carouselPhotos1.getName();
        carouselPhotos1.setName(name1);
        carouselPhotos1.setUrl(name1);
        carouselPhotos1.setId((long)1);
        list.add(carouselPhotos1);
        count++;
        CarouselPhotos carouselPhotos2=new CarouselPhotos();
        carouselPhotos2.setName("7867759.jpg");
        String name2="http://othgjp7hs.bkt.clouddn.com/17-8-9/"+carouselPhotos2.getName();
        carouselPhotos2.setName(name2);
        carouselPhotos2.setUrl("楼盘");
        carouselPhotos2.setId((long)2);
        list.add(carouselPhotos2);
        count++;
        ModelAndView modelAndView=new ModelAndView("/carouselphotos/query");
        modelAndView.addObject("list",list);
        modelAndView.addObject("count",count);
        return modelAndView;
    }

    @RequestMapping("/uplodephotos")
    public ModelAndView uplodephotos(HttpServletRequest request,@RequestParam("count")int count){
        if(count>=maxNumber){
            //提示轮播图片不能多于最高上限
        }else {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if(multipartResolver.isMultipart(request)){
                List<CarouselPhotosDto> carouselPhotosDtoList=new ArrayList<>();
                MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
                Iterator<String> iterator=multipartHttpServletRequest.getFileNames();
                while (iterator.hasNext()){
                    MultipartFile photo=multipartHttpServletRequest.getFile(iterator.next());
                    CarouselPhotosDto carouselPhotosDto=new CarouselPhotosDto();
                    carouselPhotosDto.setName(photo.getOriginalFilename());
                    //设置图片的url
                    carouselPhotosDtoList.add(carouselPhotosDto);
                }
                //将carouselPhotosDtoList中的每个元素分别存储到数据库中
            }
        }
        return null;//应该返回显示页面
    }

    @RequestMapping("/deletephoto")
    public void deletephoto(@RequestParam("id")long id,@RequestParam("count")int count){

        count--;
        if(count<=minNumber){
            //提示轮播图片张数不能少于最低下限
        }else{
            //从数据库删除与该id对应的图片及记录
            this.query();//调用显示方法
        }
    }
}
