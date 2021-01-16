package com.fh.springboot_shop.controller;

import com.fh.springboot_shop.entity.po.ShopType;
import com.fh.springboot_shop.entity.po.Shuxing;
import com.fh.springboot_shop.entity.vo.ResultData;
import com.fh.springboot_shop.entity.vo.ShuxingParam;
import com.fh.springboot_shop.service.ShuxingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
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

    @PostMapping("update")
    public ResultData update(Shuxing shuxing){
        shuxingService.update(shuxing);
        return ResultData.success("");
    }

    @PostMapping("del")
    public ResultData del(Shuxing shuxing){
        shuxingService.del(shuxing);
        return ResultData.success("");
    }

    @GetMapping("selectTypeNameById")
    public ResultData selectTypeNameById(Integer typeId){
        String name=shuxingService.selectTypeNameById(typeId);
        return  ResultData.success(name);
    }

    @GetMapping("selectTypeName")
    public ResultData selectTypeName(){
        List<ShopType> name = shuxingService.selectTypeName();
        return ResultData.success(name);
    }

    @PostMapping("selectShuxingById")
    public ResultData selectShuxingById(Integer id){
        Shuxing shuxing = shuxingService.selectShuxingById(id);
        return ResultData.success(shuxing);
    }
}
