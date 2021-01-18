package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.ShangPin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShangPinDao {
    @Insert("insert into shop_shangpin (name,title,bandId,price,stocks,sortNum,createDate,updateDate,author,isDel)" +
            "values (#{name},#{title},#{bandId},#{price},#{stocks},#{sortNum},SYSDATE(),SYSDATE(),#{author},#{isDel})")
    void addShangPin(ShangPin shangPin);
}
