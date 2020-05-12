package com.hr.service.impl;

import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.entity.eb_shop;
import com.hr.service.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-14 15:14
 **/
@Service
public class ESServiceImpl implements ESService {
    @Autowired
    private ESDao esDao;
    @Override
    public ArrayList<eb_shop> getShop(String id) {
        return esDao.getShop(id);
    }

    @Override
    public int updateJia(int id) {
        return esDao.updateJia(id);
    }

    @Override
    public int updateJian(int id) {
        return esDao.updateJian(id);
    }

    @Override
    public int updateClose(eb_shop es) {
        return esDao.updateClose(es);
    }

    @Override
    public int getDelete(int id) {
        return esDao.getDelete(id);
    }

    @Override
    public int insertDD(String id, String name, String address, int price) {
        return esDao.insertDD(id,name,address,price);
    }

    @Override
    public int getSequenceId() {
        return esDao.getSequenceId();
    }

    @Override
    public int eodInsert(EASYBUY_ORDER_DETAIL eod) {
        return esDao.eodInsert(eod);
    }

    @Override
    public int esdelete(int id) {
        return esDao.esdelete(id);
    }

    @Override
    public int updateStock(int stock, int id) {
        if (esDao.findByStock(id)<=0){
            return 0;
        }
        return esDao.updateStock(stock,id);
    }

    @Override
    public int findByStock(int id) {
        return esDao.findByStock(id);
    }

    @Override
    public int insert(eb_shop sp) {
        return esDao.insert(sp);
    }

    @Override
    public int getDeleteDD(int id) {
        return esDao.getDeleteDD(id);
    }

    @Override
    public eb_shop selectShop(String es_eu_user_id, int pid) {
        return esDao.selectShop( es_eu_user_id, pid);
    }

    @Override
    public int updateShop(int es_id,int count) {
        return esDao.updateShop(es_id,count);
    }
}
