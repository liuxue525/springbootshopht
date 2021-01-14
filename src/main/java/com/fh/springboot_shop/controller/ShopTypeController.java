package com.fh.springboot_shop.controller;

import com.fh.springboot_shop.entity.po.ShopType;
import com.fh.springboot_shop.entity.vo.ResultData;
import com.fh.springboot_shop.service.ShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/type")
public class ShopTypeController {
    @Autowired
    private ShopTypeService shopTypeService;

    @GetMapping("getData")
    public ResultData getData(){
        List<ShopType> shopTypes = shopTypeService.getData();
        return ResultData.success(shopTypes);
    }

    @GetMapping("getDataByPid")
    public ResultData getDataByPid(Integer pid){
        if(pid==null){
            return ResultData.error(500,"请输入PID");
        }
        List<ShopType> shopTypes=shopTypeService.getDataByPid(pid);
        return ResultData.success(shopTypes);
    }

    @PostMapping("add")
    public ResultData add(ShopType shopType){
        ShopType s = new ShopType();
        s.setCreateDate(new Date());
        s.setPid(shopType.getPid());
        s.setName(shopType.getName());
        s.setIdDel(0);
        Map map =shopTypeService.add(s);
        return ResultData.success(map);
    }

    @PostMapping("update")
    public ResultData update(ShopType shopType){
        if(shopType.getId()==null){
            return ResultData.error(500,"请输入ID");
        }
        shopTypeService.update(shopType);
        return ResultData.success(null);
    }

    @GetMapping("selectTypeById")
    public ResultData selectTypeById(Integer id){
        return ResultData.success(null);
    }



}
