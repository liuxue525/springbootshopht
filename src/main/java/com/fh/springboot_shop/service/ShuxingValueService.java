package com.fh.springboot_shop.service;

import com.fh.springboot_shop.entity.po.ShuxingValue;

import java.util.List;

public interface ShuxingValueService {
    List<ShuxingValue> getData(Integer attId);

    void add(ShuxingValue shuxingValue);

    ShuxingValue selectValueById(Integer id);

    void update(ShuxingValue shuxingValue);
}
