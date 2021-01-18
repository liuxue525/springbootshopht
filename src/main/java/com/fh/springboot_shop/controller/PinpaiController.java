package com.fh.springboot_shop.controller;

import com.fh.springboot_shop.entity.po.Pinpai;
import com.fh.springboot_shop.entity.vo.PinpaiParam;
import com.fh.springboot_shop.entity.vo.ResultData;
import com.fh.springboot_shop.service.PinpaiService;
import com.fh.springboot_shop.utils.OssFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("selectPinpaiName")
    public ResultData selectPinpaiName(){
        List<Pinpai> pinpaiList = pinpaiService.selectPinpaiName();
        return ResultData.success(pinpaiList);
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
    public ResultData upload(MultipartFile file) throws IOException {
        //处理新名称
        String originalFilename = file.getOriginalFilename();
        //防止中文引起的错误
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgs/"+newName;
        return ResultData.success(OssFileUtils.uploadFile(file.getInputStream(),newName));
    }
}
