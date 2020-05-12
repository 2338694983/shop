package com.hr.dao;

import com.hr.entity.EASYBUY_NEWS;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 10:10
 **/
@Repository
public interface EASYBUY_NEWSDao {
    @Select("select * from EASYBUY_NEWS")
    public ArrayList<EASYBUY_NEWS> selectAll1();


    @Select("select * from EASYBUY_NEWS where EN_ID=#{id}")
    public EASYBUY_NEWS selectById(int id);

   @Select("select * from EASYBUY_NEWS order by EN_ID desc limit #{cpage},#{count}")
    public ArrayList<EASYBUY_NEWS> selectAll(@Param("cpage") int cpage, @Param("count") int count);

   @Select("select count(*) from EASYBUY_NEWS")
    public int totalPage(int count) ;

   @Insert("insert into EASYBUY_NEWS values(null,#{EN_TITLE},#{EN_CONTENT},NOW())")
    public int insert(EASYBUY_NEWS n) ;

   @Update("update EASYBUY_NEWS set EN_TITLE=#{EN_TITLE},EN_CONTENT=#{EN_CONTENT} where EN_ID=#{EN_ID}")
    public int update(EASYBUY_NEWS n) ;

   @Delete("delete from EASYBUY_NEWS where EN_ID=#{id}")
    public int del(int id);
}
