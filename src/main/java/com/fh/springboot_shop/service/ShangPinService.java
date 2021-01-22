package com.fh.springboot_shop.service;

import com.fh.springboot_shop.entity.po.ShangPin;
import com.fh.springboot_shop.entity.po.ShangPinZhi;
import com.fh.springboot_shop.entity.vo.ShangPinParam;

import java.util.List;
import java.util.Map;

public interface ShangPinService {
    void addShangPin(ShangPin shangPin,String SKUDatas,String SPUDatas);

    void update(ShangPin shangPin);

    ShangPin selectShangPinById(Integer id);

    Map selectShangPin(ShangPinParam param);

    List<ShangPinZhi> queryDataByProId(Integer proId);
}
