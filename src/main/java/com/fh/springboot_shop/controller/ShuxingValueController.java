package com.fh.springboot_shop.controller;

import com.fh.springboot_shop.entity.po.ShuxingValue;
import com.fh.springboot_shop.entity.vo.ResultData;
import com.fh.springboot_shop.service.ShuxingValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/sxvalue")
public class ShuxingValueController {
    @Autowired
    private ShuxingValueService shuxingValueService;

    @GetMapping("getData")
    public ResultData getData(Integer attId){
        List<ShuxingValue> list =shuxingValueService.getData(attId);
        return ResultData.success(list);
    }

    @PostMapping("add")
    public ResultData add(ShuxingValue shuxingValue){
        shuxingValueService.add(shuxingValue);
        return ResultData.success(null);
    }

}
