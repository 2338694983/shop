package com.hr.service;

import com.hr.entity.EASYBUY_PRODUCT;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 16:59
 **/

public interface EASYBUY_PRODUCTService {
    ArrayList<EASYBUY_PRODUCT> selectAll();

    ArrayList<EASYBUY_PRODUCT> selectAllByName(String name);

    EASYBUY_PRODUCT selectById(int id);

    ArrayList<EASYBUY_PRODUCT> selectAllByFid(int fid);

    ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cid);

    int insert(EASYBUY_PRODUCT p);

    int update(EASYBUY_PRODUCT p);

    int del(int id);

    int totalPage(int count);

    int totalPageByFid(int count, int fid);

    int totalPageByCid(int count, int cid);

    int totalPageByName(int count, String name);

    ArrayList<EASYBUY_PRODUCT> selectAll(int cpage, int count);

    ArrayList<EASYBUY_PRODUCT> selectAllByFid(int cpage, int count, int fid);

    ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cpage,int count,int cid);

    ArrayList<EASYBUY_PRODUCT> selectById(ArrayList<Integer> ids);

    ArrayList<EASYBUY_PRODUCT> selectAllByT();

    ArrayList<EASYBUY_PRODUCT> selectAllByHot();

    void insertEP(EASYBUY_PRODUCT easybuy_product);
}
