package com.hr.dao;

import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 16:44
 **/
@Repository
public interface EASYBUY_PRODUCT_CATEGORYDao {

    @Select("select * from EASYBUY_PRODUCT_CATEGORY")
    ArrayList<EASYBUY_PRODUCT_CATEGORY> selectAll();

    @Select("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID=#{id}")
    EASYBUY_PRODUCT_CATEGORY selectById(int id);

    @Insert("insert into EASYBUY_PRODUCT_CATEGORY values(null,#{EPC_NAME},#{EPC_PARENT_ID})")
    int insert(EASYBUY_PRODUCT_CATEGORY pc);

    @Insert("insert into EASYBUY_PRODUCT_CATEGORY values(null,#{EPC_NAME},0)")
    int insertOnFather(EASYBUY_PRODUCT_CATEGORY pc);

    @Update("update EASYBUY_PRODUCT_CATEGORY set EPC_NAME=#{EPC_NAME},EPC_PARENT_ID=#{EPC_PARENT_ID} where EPC_ID=#{EPC_ID}")
    int update(EASYBUY_PRODUCT_CATEGORY pc);

    @Delete("delete from EASYBUY_PRODUCT_CATEGORY where EPC_ID=#{id}")
    int del(int id);

    @Select("select * from EASYBUY_PRODUCT_CATEGORY where EPC_PARENT_ID = 0")
    ArrayList<EASYBUY_PRODUCT_CATEGORY> selectFather();

    @Select("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID!=EPC_PARENT_ID")
    ArrayList<EASYBUY_PRODUCT_CATEGORY> selectChild();
}
