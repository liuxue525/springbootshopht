package com.fh.springboot_shop.service.impl;

import com.fh.springboot_shop.dao.ShuxingDao;
import com.fh.springboot_shop.entity.po.ShopType;
import com.fh.springboot_shop.entity.po.Shuxing;
import com.fh.springboot_shop.entity.vo.ShuxingParam;
import com.fh.springboot_shop.service.ShuxingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShuxingServiceImpl implements ShuxingService {
    @Resource
    private ShuxingDao shuxingDao;

    @Override
    public Map getData(ShuxingParam param) {
        Map map = new HashMap();
        Integer count  = shuxingDao.selectCount(param);
        map.put("count",count);
        List<Shuxing> shuxingList = shuxingDao.queryShuxingData(param);
        map.put("list",shuxingList);
        return map;
    }

    @Override
    public void add(Shuxing shuxing) {
        shuxing.setAuthor("admin");
        shuxingDao.addShuxing(shuxing);
    }

    @Override
    public void update(Shuxing shuxing) {

        shuxing.setAuthor("admin");
        shuxingDao.update(shuxing);
    }

    @Override
    public void del(Shuxing shuxing) {
        shuxing.setId(shuxing.getId());
        shuxing.setIsDel(1);
        shuxingDao.del(shuxing);
    }

    @Override
    public String selectTypeNameById(Integer typeId) {
        return shuxingDao.selectTypeNameById(typeId);
    }

    @Override
    public List<ShopType> selectTypeName() {
        return shuxingDao.selectTypeName();
    }

    @Override
    public List<Shuxing> selectShuxingById(Integer typeId) {
        return shuxingDao.selectShuxingById(typeId);
    }

    @Override
    public Shuxing selectSxById(Integer id) {
        return shuxingDao.selectSxById(id);
    }


}
