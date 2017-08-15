package team.etop.xunfang.testdemo.web;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import team.etop.xunfang.common.bean.PageInfo;
import team.etop.xunfang.estate.dto.EstateDto;
import team.etop.xunfang.testdemo.dto.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by asus on 2017/8/10.
 */
@Controller
@RequestMapping("/demo")
public class demoController {

    //当前页数
    @Value("${searchPage.PageSize}")
    private Long PageSize;
    //每页显示条数
    @Value("${searchPage.countindex}")
    private Long countindex;
    //显示的总页数
    @Value("${searchPage.visiblePages}")
    private Long visiblePages;
    @Value("${businessImage.savePath}")
    private String savePath;

    @RequestMapping("/demo01")
    public ModelAndView demo01(EstateDto estateDto,@RequestParam(value = "pn",defaultValue ="1")Integer pageNum,HttpServletRequest request)throws Exception{
        PageInfo pageInfo = new PageInfo(PageSize, countindex, visiblePages, PageSize * visiblePages, 1L);
        System.out.println(estateDto);
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        System.out.println(myFileName);
                        //重命名上传后的文件名
//                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                        String path = "E:/IOText/" + myFileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
            }

        }
        ModelAndView modelAndView=new ModelAndView("/DemoTest/demo01");
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    @RequestMapping("/resolveJsonObject")
    @ResponseBody
    public void resolveJsonObject(@RequestParam("files") MultipartFile multipartFile,@RequestParam("cropData")String data)throws Exception{
        System.out.println(data);
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
        System.out.println(multipartFile.getOriginalFilename());
        String filepath=savePath+multipartFile.getOriginalFilename();
        //multipartFile.transferTo(new File(filepath));
        Thumbnails.of(filepath).sourceRegion((int)x,(int)y,(int)w,(int)h).size(300,300).keepAspectRatio(false).toFile(savePath+multipartFile.getOriginalFilename());
        System.out.println("上传完成");
    }
}
