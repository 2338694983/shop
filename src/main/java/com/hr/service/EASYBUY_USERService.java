package com.hr.service;

import com.hr.entity.EASYBUY_USER;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-14 10:27
 **/
public interface EASYBUY_USERService {
    ArrayList<EASYBUY_USER> selectAll(int cpage, int count);
    ArrayList<EASYBUY_USER> selectAll();
    EASYBUY_USER selectById(String id);
    int selectByName(String id);
    int selectByNM(String name,String pwd);
    EASYBUY_USER selectAdmin(String name,String pwd);
    int totalPage(int count);
    int insert(EASYBUY_USER u);
    int update(EASYBUY_USER u);
    int del(String id);

}
