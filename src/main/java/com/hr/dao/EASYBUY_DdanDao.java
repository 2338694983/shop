package com.hr.dao;

import com.hr.entity.EASYBUY_Ddan;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @program: shop
 * @description:
 * @author: Mr.L
 * @create: 2020-03-12 09:10
 **/
@Repository
public interface EASYBUY_DdanDao {
    @Select("select * from EASYBUY_ORDER eo,EASYBUY_ORDER_DETAIL eod,EASYBUY_PRODUCT ep where eo.eo_user_id=#{id} and eod.eo_id=eo.eo_id and eod.ep_id= ep.ep_id order by eo.eo_id desc")
    ArrayList<EASYBUY_Ddan> selectById(String id);
}
