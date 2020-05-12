package com.hr.service;

import com.hr.entity.EASYBUY_NEWS;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 10:11
 **/
public interface EASYBUY_NEWSService {
    ArrayList<EASYBUY_NEWS> selectAll1();
    EASYBUY_NEWS selectById(int id);
    ArrayList<EASYBUY_NEWS> selectAll(int cpage,int count);
    int totalPage(int count);
    int insert(EASYBUY_NEWS n);
    int update(EASYBUY_NEWS n);
    int del(int id);
}
