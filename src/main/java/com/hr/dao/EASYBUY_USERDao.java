package com.hr.dao;

import com.hr.entity.EASYBUY_USER;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-14 10:30
 **/
@Repository
public interface EASYBUY_USERDao {
    @Select("select * from EASYBUY_USER order by EU_BIRTHDAY desc limit #{cpage},#{count}")
    ArrayList<EASYBUY_USER> selectAll2(@Param("cpage") int cpage, @Param("count") int count);

    @Select("select * from EASYBUY_USER")
    ArrayList<EASYBUY_USER> selectAll();

    @Select("select m.*,DATE_FORMAT(m.eu_birthday,'%Y-%m-%d')birthday from EASYBUY_USER m where EU_USER_ID=#{id}")
    EASYBUY_USER selectById(String id);

    @Select("select count(*) from EASYBUY_USER where EU_USER_ID=#{id}")
    int selectByName(String id);

    @Select("select count(*) from EASYBUY_USER where EU_USER_ID=#{name} and EU_PASSWORD=#{pwd}")
    int selectByNM(@Param("name") String name,@Param("pwd") String pwd);

    @Select("select * from EASYBUY_USER where EU_USER_ID=#{name} and EU_PASSWORD=#{pwd}")
    EASYBUY_USER selectAdmin(@Param("name") String name, @Param("pwd")String pwd);

    @Select("select count(*) from EASYBUY_USER")
    int totalPage();

    @Insert("insert into EASYBUY_USER values(#{EU_USER_ID},#{EU_USER_NAME},#{EU_PASSWORD},#{EU_SEX},DATE_FORMAT(#{EU_BIRTHDAY},'%Y-%m-%d'),#{EU_IDENTITY_CODE},#{EU_EMAIL},#{EU_MOBILE},#{EU_ADDRESS},#{EU_STATUS})")
    int insert(EASYBUY_USER u);

    @Update("update EASYBUY_USER set EU_USER_NAME=#{EU_USER_NAME}，EU_PASSWORD=#{EU_PASSWORD},EU_SEX=#{EU_SEX},EU_BIRTHDAY=DATE_FORMAT(#{EU_BIRTHDAY},'%Y-%m-%d %H:%i:%s'),EU_EMAIL=#{EU_EMAIL}, EU_MOBILE=#{EU_MOBILE},EU_ADDRESS=#{EU_ADDRESS},EU_STATUS=#{EU_STATUS}  where EU_USER_ID=#{EU_USER_ID}")
    int update(EASYBUY_USER u);

    @Delete("delete from EASYBUY_USER where EU_USER_ID=#{id} and EU_USER_ID!='admin'")
    int del(String id);
}
