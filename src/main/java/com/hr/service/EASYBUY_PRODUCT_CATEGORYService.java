package com.hr.service;

import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 16:38
 **/

public interface EASYBUY_PRODUCT_CATEGORYService {
    ArrayList<EASYBUY_PRODUCT_CATEGORY> selectAll();
    EASYBUY_PRODUCT_CATEGORY selectById(int id);
    int insert(EASYBUY_PRODUCT_CATEGORY pc);
    int insertOnFather(EASYBUY_PRODUCT_CATEGORY pc);
    int update(EASYBUY_PRODUCT_CATEGORY pc);
    int del(int id);
    ArrayList<EASYBUY_PRODUCT_CATEGORY> selectFather();
    ArrayList<EASYBUY_PRODUCT_CATEGORY> selectChild();
}
