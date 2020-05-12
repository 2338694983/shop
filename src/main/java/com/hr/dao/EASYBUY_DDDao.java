package com.hr.dao;

import com.hr.entity.EASYBUY_DD;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 09:48
 **/
@Repository
public interface EASYBUY_DDDao {
    @Select("select * from EASYBUY_ORDER eo,EASYBUY_ORDER_DETAIL eod,EASYBUY_PRODUCT ep where eo.eo_id=#{id} and eod.eo_id=eo.eo_id and eod.ep_id= ep.ep_id")
    ArrayList<EASYBUY_DD> selectById(int id);
}
