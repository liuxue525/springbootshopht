package com.fh.springboot_shop.controller;

import com.fh.springboot_shop.entity.po.ShangPin;
import com.fh.springboot_shop.entity.vo.ResultData;
import com.fh.springboot_shop.service.ShangPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/shangpin")
public class ShangPinController {

    @Autowired
    private ShangPinService shangPinService;

    @PostMapping("addShangPin")
    public ResultData addShangPin(ShangPin shangPin){
        shangPinService.addShangPin(shangPin);
        return ResultData.success(null);
    }
}
