package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.ShuxingValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShuxingValueDao {
    @Select("SELECT * FROM shop_shuxingzhi WHERE attId=#{attId}")
    List<ShuxingValue> getData(Integer attId);

    @Insert("insert into shop_shuxingzhi (name,nameCH,attId) values (#{name},#{nameCH},#{attId})")
    void add(ShuxingValue shuxingValue);

    @Select("select * from shop_shuxingzhi where id = #{id}")
    ShuxingValue selectValueById(Integer id);

    @Update("update shop_shuxingzhi set name=#{name},nameCH=#{nameCH},attId=#{attId} where id=#{id}")
    void update(ShuxingValue shuxingValue);
}
