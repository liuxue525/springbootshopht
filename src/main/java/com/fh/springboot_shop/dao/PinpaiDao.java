package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.Pinpai;
import com.fh.springboot_shop.entity.vo.PinpaiParam;

import java.util.List;

public interface PinpaiDao {
    Long selectCount(PinpaiParam param);

    List<Pinpai> selectPinpaiByPage(PinpaiParam param);

    void add(Pinpai pinpai);

    Pinpai selectPinpaiById(Integer id);

    void update(Pinpai pinpai);
}
