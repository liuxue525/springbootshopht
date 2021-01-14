package com.fh.springboot_shop.service;

import com.fh.springboot_shop.entity.po.ShopType;

import java.util.List;
import java.util.Map;

public interface ShopTypeService {
    List<ShopType> getData();

    List<ShopType> getDataByPid(Integer pid);


    Map add(ShopType s);

    void update(ShopType shopType);
}
