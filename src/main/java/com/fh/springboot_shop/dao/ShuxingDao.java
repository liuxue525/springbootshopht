package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.Shuxing;
import com.fh.springboot_shop.entity.vo.ShuxingParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShuxingDao {


    Integer selectCount(ShuxingParam param);


    List<Shuxing> queryShuxingData(ShuxingParam param);




    @Insert("insert into shop_shuxing (name,nameChina,typeId,type,isSKU,createDate,updateDate,author)" +
            "values (#{name},#{nameChina},#{typeId},#{type},#{isSKU},SYSDATE(),SYSDATE(),#{author})")
    void addShuxing(Shuxing shuxing);

    @Update("update shop_shuxing set name=#{name},nameChina=#{nameChina},typeId=#{typeId},type=#{type},isSKU=#{isSKU}," +
            "createDate=SYSDATE(),updateDate=SYSDATE(),author=#{author} where id=#{id}")
    void update(Shuxing shuxing);

    @Update("update shop_shuxing set isDel=#{isDel} where id=#{id}")
    void del(Shuxing shuxing);

    @Select("SELECT distinct t.name FROM shop_type t LEFT JOIN shop_shuxing s ON t.id = s.typeId\n" +
            "where s.typeId=#{typeId}")
    String selectTypeNameById(Integer typeId);
}
