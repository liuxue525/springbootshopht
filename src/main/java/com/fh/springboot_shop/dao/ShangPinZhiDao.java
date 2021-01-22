package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.ShangPinZhi;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ShangPinZhiDao {
    @Insert("<script>insert into shop_shangpinzhi (proId,attrData,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.proId},#{a.attrData},#{a.storcks},#{a.price} )  </foreach> </script>")
    void adds(List<ShangPinZhi> shangPinZhis);
}
