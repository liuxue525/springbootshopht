package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.ShangPin;
import com.fh.springboot_shop.entity.po.ShangPinZhi;
import com.fh.springboot_shop.entity.vo.ShangPinParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShangPinDao {
    @Insert("insert into shop_shangpin (name,title,typeId,bandId,productdecs,imgPath,price,stocks,sortNum,createDate,updateDate,author,isDel)" +
            "value (#{name},#{title},#{typeId},#{bandId},#{productdecs},#{imgPath},#{price},#{stocks},#{sortNum},SYSDATE(),SYSDATE(),#{author},#{isDel})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addShangPin(ShangPin shangPin);

    @Update("update shop_shangpin set name=#{name},title=#{title},bandId=#{bandId},typeId=#{typeId},productdecs=#{productdecs},imgPath=#{imgPath},price=#{price}," +
            "stocks=#{stocks},sortNum=#{sortNum},updateDate=SYSDATE() where id=#{id}")
    void update(ShangPin shangPin);

    @Select("select * from shop_shangpin where id=#{id}")
    ShangPin selectShangPinById(Integer id);

    Integer selectShangPinCount(ShangPinParam param);

    List<ShangPin> selectShangPinByPage(ShangPinParam param);

    @Select("select * from shop_shangpinzhi where proId=#{proId}")
    List<ShangPinZhi> queryDataByProId(Integer proId);
}
