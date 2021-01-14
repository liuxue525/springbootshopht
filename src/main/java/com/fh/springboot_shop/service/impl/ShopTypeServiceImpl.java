package com.fh.springboot_shop.service.impl;

import com.fh.springboot_shop.dao.ShopTypeDao;
import com.fh.springboot_shop.entity.po.ShopType;
import com.fh.springboot_shop.service.ShopTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopTypeServiceImpl implements ShopTypeService {
    @Resource
    private ShopTypeDao shopTypeDao;

    @Override
    public List<ShopType> getData() {
        return shopTypeDao.getData();
    }

    @Override
    public List<ShopType> getDataByPid(Integer pid) {
        return shopTypeDao.getDataByPid(pid);
    }

    @Override
    public Map add(ShopType s) {
        shopTypeDao.add(s);
        System.out.println(s.getId());
        Map map =new HashMap();
        map.put("id",s.getId());
        return map;
    }

    @Override
    public void update(ShopType shopType) {
        ShopType s = new ShopType();

        s.setName(shopType.getName());

        s.setIdDel(shopType.getIdDel());
        s.setUpdateDate(new Date());
        s.setId(shopType.getId());
        shopTypeDao.update(s);
    }
}
