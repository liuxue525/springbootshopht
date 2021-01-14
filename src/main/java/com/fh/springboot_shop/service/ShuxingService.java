package com.fh.springboot_shop.service;

import com.fh.springboot_shop.entity.po.Shuxing;
import com.fh.springboot_shop.entity.vo.ShuxingParam;

import java.util.List;
import java.util.Map;

public interface ShuxingService {
    Map getData(ShuxingParam param);

    void add(Shuxing shuxing);
}
