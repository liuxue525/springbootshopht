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
    public List<ShuxingValue> getData(Integer attId) {
        return shuxingValueDao.getData(attId);
    }

    @Override
    public void add(ShuxingValue shuxingValue) {
        shuxingValueDao.add(shuxingValue);
    }

    @Override
    public ShuxingValue selectValueById(Integer id) {
        return shuxingValueDao.selectValueById(id);
    }

    @Override
    public void update(ShuxingValue shuxingValue) {
        shuxingValueDao.update(shuxingValue);
    }
}
