package com.hr.dao;

import com.hr.entity.EASYBUY_ORDER;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 11:15
 **/
@Repository
public interface EASYBUY_ORDERDao {
    @Select("select * from EASYBUY_ORDER")
    ArrayList<EASYBUY_ORDER> selectAll1();

    @Select("select * from EASYBUY_ORDER where EO_ID=#{id}")
    EASYBUY_ORDER selectById(int id);

    @Select("<script> "
            +"select count(*) from EASYBUY_ORDER  WHERE 1=1 "
            +"<if test='id!=null and id!=\"\"'>"
            +" and EO_ID=#{id} "
            +"</if>"
            +"<if test='name!=null and name!=\"\"'>"
            +"  and EO_USER_NAME like #{name} "
            +"</if>"
            +"</script>"
    )
    int totalPage(@Param("id")String id,@Param("name")String name);

    @Select("<script> "
            +"select * from EASYBUY_ORDER WHERE 1=1 "
            +"<if test='id!=null and id!=\"\"'>"
            +" and EO_ID=#{id} "
            +"</if>"
            +"<if test='name!=null and name!=\"\"'>"
            +" and EO_USER_NAME like #{name}"
            +"</if>"
            +" order by EO_ID desc limit #{cpage},#{count}"
            +"</script>")
    ArrayList<EASYBUY_ORDER> selectAll(@Param("cpage")int cpage,@Param("count")int count,@Param("id") String id,@Param("name") String name);

    @Insert("insert into EASYBUY_ORDER values(null,#{EO_USER_ID},#{EO_USER_NAME},#{EO_USER_ADDRESS},#{EO_CREATE_TIME},#{EO_COST},#{EO_STATUS},#{EO_TYPE})")
    int insert(EASYBUY_ORDER o);

    @Update("update EASYBUY_ORDER set EO_USER_NAME=#{EO_USER_NAME},EO_USER_ADDRESS=#{EO_USER_ADDRESS},EO_COST=#{EO_COST},EO_STATUS=#{EO_STATUS} where EO_ID=#{EO_ID}")
    int update(EASYBUY_ORDER o);

    @Delete("delete from EASYBUY_ORDER where EO_ID=#{id}")
    int del(int id);
}
