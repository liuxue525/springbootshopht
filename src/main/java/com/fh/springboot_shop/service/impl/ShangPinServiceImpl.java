package com.fh.springboot_shop.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.springboot_shop.dao.ShangPinDao;
import com.fh.springboot_shop.dao.ShangPinZhiDao;
import com.fh.springboot_shop.entity.po.ShangPin;
import com.fh.springboot_shop.entity.po.ShangPinZhi;
import com.fh.springboot_shop.entity.vo.ShangPinParam;
import com.fh.springboot_shop.service.ShangPinService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShangPinServiceImpl implements ShangPinService {

    @Resource
    private ShangPinDao shangPinDao;

    @Resource
    private ShangPinZhiDao shangPinZhiDao;

    @Override
    @Transactional
    public void addShangPin(ShangPin shangPin,String SKUDatas,String SPUDatas) {
        shangPin.setAuthor("admin");
        shangPin.setIsDel(0);
        shangPinDao.addShangPin(shangPin);

        List<ShangPinZhi> shangPinZhis = new ArrayList<>();
        //将SPU数组字符串转为JSON数组对象  [{},{},{},{}]
        JSONArray objects = JSONObject.parseArray(SPUDatas);
        for (int i = 0; i <objects.size() ; i++) {
            ShangPinZhi s = new ShangPinZhi();
            s.setProId(shangPin.getId());
            s.setAttrData(objects.get(i).toString());
            shangPinZhis.add(s);
        }

        //处理SKU的数据
        JSONArray objectsSKU = JSONObject.parseArray(SKUDatas);
        for (int i = 0; i <objectsSKU.size() ; i++) {
            JSONObject skuObj = (JSONObject) objectsSKU.get(i);
            ShangPinZhi s = new ShangPinZhi();
            s.setProId(shangPin.getId());
            s.setPrice(skuObj.getDouble("price"));
            s.setStorcks(skuObj.getInteger("kuCun"));

            skuObj.remove("price");
            skuObj.remove("kuCun");
            s.setAttrData(objectsSKU.get(i).toString());


            shangPinZhis.add(s);
        }

        shangPinZhiDao.adds(shangPinZhis);
    }

    @Override
    public void update(ShangPin shangPin) {
        shangPin.setAuthor("author");
        shangPin.setIsDel(0);
        shangPinDao.update(shangPin);
    }

    @Override
    public ShangPin selectShangPinById(Integer id) {
        return shangPinDao.selectShangPinById(id);
    }

    @Override
    public Map selectShangPin(ShangPinParam param) {
        Map map = new HashMap();
        Integer count  = shangPinDao.selectShangPinCount(param);
        map.put("count",count);
        List<ShangPin> shangPins = shangPinDao.selectShangPinByPage(param);
        map.put("list",shangPins);
        return map;
    }

    @Override
    public List<ShangPinZhi> queryDataByProId(Integer proId) {
        return shangPinDao.queryDataByProId(proId);
    }


}
