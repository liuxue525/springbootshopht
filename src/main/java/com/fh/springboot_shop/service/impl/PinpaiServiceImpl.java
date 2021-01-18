package com.fh.springboot_shop.service.impl;

import com.fh.springboot_shop.dao.PinpaiDao;
import com.fh.springboot_shop.entity.po.Pinpai;
import com.fh.springboot_shop.entity.vo.PinpaiParam;
import com.fh.springboot_shop.service.PinpaiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PinpaiServiceImpl implements PinpaiService {
    @Resource
    private PinpaiDao pinpaiDao;

    @Override
    public Map selectPinpai(PinpaiParam param) {
        Map map = new HashMap();
        Long count = pinpaiDao.selectCount(param);
        map.put("count",count);
        List<Pinpai> pinpaiList = pinpaiDao.selectPinpaiByPage(param);
        map.put("list",pinpaiList);
        return map;
    }

    @Override
    public void add(Pinpai pinpai) {
        Pinpai p = new Pinpai();
        p.setCreateDate(new Date());
        p.setAuthor("admin");
        p.setIsDel(0);
        p.setName(pinpai.getName());
        p.setBandDesc(pinpai.getBandDesc());
        p.setBandE(pinpai.getBandE());
        p.setImgPath(pinpai.getImgPath());
        p.setOrd(pinpai.getOrd());
        p.setUpdateDate(pinpai.getUpdateDate());
        pinpaiDao.add(p);
    }

    @Override
    public Pinpai selectPinpaiById(Integer id) {
        return pinpaiDao.selectPinpaiById(id);
    }

    @Override
    public void update(Pinpai pinpai) {
        pinpaiDao.update(pinpai);
    }

    @Override
    public List<Pinpai> selectPinpaiName() {
        return pinpaiDao.selectPinpaiName();
    }
}
