package com.fh.springboot_shop.dao;

import com.fh.springboot_shop.entity.po.Shuxing;
import com.fh.springboot_shop.entity.vo.ShuxingParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShuxingDao {


    Integer selectCount(ShuxingParam param);


    List<Shuxing> queryShuxingData(ShuxingParam param);






}
