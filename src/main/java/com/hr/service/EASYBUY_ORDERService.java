package com.hr.service;

import com.hr.entity.EASYBUY_ORDER;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 11:11
 **/
public interface EASYBUY_ORDERService {
    ArrayList<EASYBUY_ORDER> selectAll1();
    EASYBUY_ORDER selectById(int id);
    int totalPage(int count,String id,String name);
    ArrayList<EASYBUY_ORDER> selectAll(int cpage,int count,String id,String name);
    int insert(EASYBUY_ORDER o);
    int update(EASYBUY_ORDER o);
    int del(int id);
}
