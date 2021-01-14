package com.fh.springboot_shop.controller;

import com.fh.springboot_shop.entity.po.Shuxing;
import com.fh.springboot_shop.entity.vo.ResultData;
import com.fh.springboot_shop.entity.vo.ShuxingParam;
import com.fh.springboot_shop.service.ShuxingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/shuxing")
public class ShuxingController {

    @Autowired
    private ShuxingService shuxingService;

    @GetMapping("getData")
    public ResultData getData(ShuxingParam param){
        Map map = shuxingService.getData(param);
        return ResultData.success(map);
    }

    @PostMapping("add")
    public ResultData add(Shuxing shuxing){
        shuxingService.add(shuxing);
        return ResultData.success("");
    }
}
