package com.hr.service;

import com.hr.entity.EASYBUY_COMMENT;

import java.util.ArrayList;

/**
 * @program: shop
 * @description:
 * @author: Mr.L
 * @create: 2020-03-11 11:13
 **/
public interface EASYBUY_COMMENTService {
    //查询所有
    ArrayList<EASYBUY_COMMENT> selectAll();

    EASYBUY_COMMENT selectById(int id);

    int insert(EASYBUY_COMMENT c);

    int update(EASYBUY_COMMENT c);

    int del(int id);

    ArrayList<EASYBUY_COMMENT> selPage(int page, int pagesize);

    EASYBUY_COMMENT selOne(int id);

    int u(EASYBUY_COMMENT comment);

    int getMax(int pagesize);

    ArrayList<EASYBUY_COMMENT> selPages(String name, int page, int pages);
}
