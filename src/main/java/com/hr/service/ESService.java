package com.hr.service;

import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.entity.eb_shop;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-14 15:14
 **/
public interface ESService {
    ArrayList<eb_shop> getShop(String id);
    int updateJia(int id);
    int updateJian(int id);
    int updateClose(eb_shop es);
    int getDelete(int id);
    int insertDD(String id,String name,String address,int price);
    int getSequenceId();
    int eodInsert(EASYBUY_ORDER_DETAIL eod);
    int esdelete(int id);
    int updateStock(int stock,int id);
    int findByStock(int id);
    int insert(eb_shop sp);
    int getDeleteDD(int id);
    eb_shop selectShop(String es_eu_user_id, int pid);

    int updateShop(int es_id,int count);
}

