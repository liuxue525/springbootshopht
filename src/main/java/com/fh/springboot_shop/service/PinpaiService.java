package com.fh.springboot_shop.service;

import com.fh.springboot_shop.entity.po.Pinpai;
import com.fh.springboot_shop.entity.vo.PinpaiParam;

import java.util.List;
import java.util.Map;

public interface PinpaiService {
    Map selectPinpai(PinpaiParam param);

    void add(Pinpai pinpai);

    Pinpai selectPinpaiById(Integer id);

    void update(Pinpai pinpai);

    List<Pinpai> selectPinpaiName();
}
