package com.hr.dao;

import com.hr.entity.EASYBUY_ORDER_DETAIL;
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
 * @create: 2020-03-13 10:03
 **/
@Repository
public interface EASYBUY_ORDER_DETAILDao {
    @Select("select * from EASYBUY_ORDER_DETAIL")
    ArrayList<EASYBUY_ORDER_DETAIL> selectAll();

    @Select("select * from EASYBUY_ORDER_DETAIL where EOD_ID=#{id}")
    EASYBUY_ORDER_DETAIL selectById(int id);

    @Insert("int insert EASYBUY_ORDER_DETAIL values(null,#{EO_ID},#{EP_ID},#{EOD_QUANTITY},#{EOD_COST})")
    int insert(EASYBUY_ORDER_DETAIL od);

    @Update("update EASYBUY_ORDER_DETAIL set EO_ID=#{EO_ID},EP_ID=#{EP_ID},EOD_QUANTITY=#{EOD_QUANTITY},EOD_COST=#{EOD_COST} where EOD_ID=#{EOD_ID}")
    int update(EASYBUY_ORDER_DETAIL od);

    @Delete("delete from EASYBUY_ORDER_DETAIL where EOD_ID=#{id}")
    int del(int id);
}