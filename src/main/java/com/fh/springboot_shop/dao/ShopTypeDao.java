package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.ShopType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface ShopTypeDao {
    @Select("select * from shop_type")
    List<ShopType> getData();

    @Select("select * from shop_type where pid=#{pid}")
    List<ShopType> getDataByPid(Integer pid);

    void add(ShopType s);



    @Update("update shop_type set name=#{name},updateDate=#{updateDate},idDel=#{idDel} where id=#{id}")
    void update(ShopType s);
}
