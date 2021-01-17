package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.ShuxingValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShuxingValueDao {
    @Select("select * from shop_shuxingzhi")
    List<ShuxingValue> getData();
}
