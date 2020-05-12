package com.hr.service;

import com.hr.entity.EASYBUY_ORDER_DETAIL;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 10:01
 **/
public interface EASYBUY_ORDER_DETAILService {
    ArrayList<EASYBUY_ORDER_DETAIL> selectAll();

    EASYBUY_ORDER_DETAIL selectById(int id);

    int insert(EASYBUY_ORDER_DETAIL od);

    int update(EASYBUY_ORDER_DETAIL od);

    int del(int id);
}
