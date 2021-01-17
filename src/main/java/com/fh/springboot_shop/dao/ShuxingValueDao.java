package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.ShuxingValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShuxingValueDao {
    @Select("SELECT z.id,z.`name`,z.nameCH,z.attId FROM shop_shuxing s LEFT JOIN shop_shuxingzhi z ON s.id = z.attId\n" +
            "WHERE 1=1 and z.attId=#{attId}")
    List<ShuxingValue> getData(Integer attId);

    @Insert("insert into shop_shuxingzhi (name,nameCH,attId) values (#{name},#{nameCH},#{attId})")
    void add(ShuxingValue shuxingValue);
}
