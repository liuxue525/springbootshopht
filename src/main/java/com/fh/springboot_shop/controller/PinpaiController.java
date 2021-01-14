package com.fh.springboot_shop.controller;

import com.fh.springboot_shop.entity.po.Pinpai;
import com.fh.springboot_shop.entity.vo.PinpaiParam;
import com.fh.springboot_shop.entity.vo.ResultData;
import com.fh.springboot_shop.service.PinpaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@CrossOrigin
@RequestMapping("api/pinpai")
public class PinpaiController {

    @Autowired
    private PinpaiService pinpaiService;

    @GetMapping("selectPinpai")
    public ResultData selectPinpai(PinpaiParam param){

        Map rs = pinpaiService.selectPinpai(param);

        return ResultData.success(rs);
    }

    @PostMapping("add")
    public ResultData add(Pinpai pinpai){
        pinpaiService.add(pinpai);
        return ResultData.success(null);
    }

    @GetMapping("selectPinpaiById")
    public ResultData selectPinpaiById(Integer id){
        Pinpai pinpai=pinpaiService.selectPinpaiById(id);
        return ResultData.success(pinpai);
    }

    @PostMapping("update")
    public ResultData update(Pinpai pinpai){
        pinpaiService.update(pinpai);
        return ResultData.success(null);
    }









    @PostMapping("upload")
    public static String saveFile(MultipartFile file, HttpServletRequest request) {

        //获取项目的绝对路径
        String realPath = request.getServletContext().getRealPath("/");
        //指定的目录
        String savePath=realPath;
        //创建目录对象
        File fileStroy=new File(savePath);
        //判断目录是否存在
        boolean exists = fileStroy.exists();
        if(exists==false) {
            //创建目录
            fileStroy.mkdirs();
        }
        //文件的保存目录已经存在


        //对上传的文件 进行重命名

        //获取上传文件的名 aaa.jpg  bbb.xlsx  cccc.zip
        String fileName = file.getOriginalFilename();
        //起新名
        String newName= UUID.randomUUID().toString();
        //处理文件格式
        String fileType=fileName.substring(fileName.lastIndexOf("."));
        String newFileName=newName+fileType;
        //拷贝文件

        // 输入流  输出流

        try {// classcast
            InputStream is=file.getInputStream();
            //输出流
            FileOutputStream os=new FileOutputStream(fileStroy+"/"+newFileName);
            //一次拷贝2kb
            byte[] bts=new byte[1024*2];
            //拷贝的过程
            while(is.read(bts)!=-1) {
                os.write(bts);
            }
            //拷贝完成
            os.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newFileName;
    }
}
