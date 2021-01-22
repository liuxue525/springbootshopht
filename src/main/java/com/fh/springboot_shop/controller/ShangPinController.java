package com.fh.springboot_shop.controller;

import com.fh.springboot_shop.entity.po.ShangPin;
import com.fh.springboot_shop.entity.po.ShangPinZhi;
import com.fh.springboot_shop.entity.vo.ResultData;
import com.fh.springboot_shop.entity.vo.ShangPinParam;
import com.fh.springboot_shop.service.ShangPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/shangpin")
public class ShangPinController {

    @Autowired
    private ShangPinService shangPinService;

    @PostMapping("addShangPin")
    public ResultData addShangPin(ShangPin shangPin,String SKUDatas,String SPUDatas){
        shangPinService.addShangPin(shangPin,SKUDatas,SPUDatas);
        return ResultData.success(null);
    }

    @PostMapping("update")
    public ResultData update(ShangPin shangPin){
        shangPinService.update(shangPin);
        return ResultData.success(null);
    }

    @GetMapping("selectShangPinById")
    public ResultData selectShangPinById(Integer id){
        ShangPin shangPin = shangPinService.selectShangPinById(id);
        return ResultData.success(shangPin);
    }

    @PostMapping("selectShangPin")
    public ResultData selectShangPin(ShangPinParam param){
        Map map = shangPinService.selectShangPin(param);
        return ResultData.success(map);
    }

    @GetMapping("queryDataByProId")
    public ResultData queryDataByProId(Integer proId){
        List<ShangPinZhi> shangPinZhis=shangPinService.queryDataByProId(proId);
        return ResultData.success(shangPinZhis);
    }
}
