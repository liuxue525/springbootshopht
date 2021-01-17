package com.fh.springboot_shop.service.impl;

import com.fh.springboot_shop.dao.ShuxingValueDao;
import com.fh.springboot_shop.entity.po.ShuxingValue;
import com.fh.springboot_shop.service.ShuxingValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShuxingValueServiceImpl implements ShuxingValueService {
    @Resource
    private ShuxingValueDao shuxingValueDao;

    @Override
    public List<ShuxingValue> getData() {
        return shuxingValueDao.getData();
    }
}
