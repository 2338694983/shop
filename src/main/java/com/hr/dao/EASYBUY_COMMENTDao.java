package com.hr.dao;

import com.hr.entity.EASYBUY_COMMENT;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @program: shop
 * @description:
 * @author: Mr.L
 * @create: 2020-03-11 10:35
 **/
@Repository
public interface EASYBUY_COMMENTDao {

    @Select("select * from EASYBUY_COMMENT")
    ArrayList<EASYBUY_COMMENT> selectAll();

    @Select("select * from EASYBUY_COMMENT where EC_ID=#{id}")
    EASYBUY_COMMENT selectById(int id);

    @Insert("insert into EASYBUY_COMMENT values(null,#{EC_CONTENT},NOW(),#{EC_REPLY},#{EC_REPLY_TIME},#{EC_NICK_NAME})")
    int insert(EASYBUY_COMMENT c);

    @Update("update EASYBUY_COMMENT set EC_REPLY=#{EC_REPLY},EC_REPLY_TIME=DATE_FORMAT(#{EC_REPLY_TIME},'%Y-%m-%d') where EC_ID=#{EC_ID}")
    int update(EASYBUY_COMMENT c);//

    @Delete("delete from EASYBUY_COMMENT where EC_ID=#{id}")
    int del(int id);

    @Select("select * from easybuy_comment order by Ec_create_time desc limit #{min},#{max}")
    ArrayList<EASYBUY_COMMENT> selPage(@Param("min") int min, @Param("max") int max);

    @Select("select * from EASYBUY_COMMENT where Ec_id=#{id}")
    EASYBUY_COMMENT selOne(int id);

    @Update("update EASYBUY_COMMENT set EC_NICK_NAME=#{EC_NICK_NAME},EC_REPLY=#{EC_REPLY} where EC_ID=#{EC_ID}")
    int u(EASYBUY_COMMENT comment);

    @Select("select count(*) from EASYBUY_COMMENT")
    int getMax();

    @Select("select * from easybuy_comment where ec_nick_name=#{name} order by ec_create_time desc limit #{min},#{max}")
    ArrayList<EASYBUY_COMMENT> selPages(@Param("name") String name, @Param("min") int min, @Param("max") int max);//int min = (page-1)*pages;int max = pages;


}
