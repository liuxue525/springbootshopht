package com.fh.springboot_shop.service.impl;

import com.fh.springboot_shop.dao.ShangPinDao;
import com.fh.springboot_shop.entity.po.ShangPin;
import com.fh.springboot_shop.service.ShangPinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShangPinServiceImpl implements ShangPinService {

    @Resource
    private ShangPinDao shangPinDao;

    @Override
    public void addShangPin(ShangPin shangPin) {
        shangPin.setAuthor("admin");
        shangPin.setIsDel(0);
        shangPinDao.addShangPin(shangPin);
    }
}
