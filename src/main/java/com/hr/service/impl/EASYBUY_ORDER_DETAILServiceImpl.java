package com.hr.service.impl;

import com.hr.dao.EASYBUY_ORDER_DETAILDao;
import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.service.EASYBUY_ORDER_DETAILService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 10:01
 **/
@Service
public class EASYBUY_ORDER_DETAILServiceImpl implements EASYBUY_ORDER_DETAILService {
    @Autowired
    private EASYBUY_ORDER_DETAILDao easybuy_order_detailDao;
    @Override
    public ArrayList<EASYBUY_ORDER_DETAIL> selectAll() {
        return easybuy_order_detailDao.selectAll();
    }

    @Override
    public EASYBUY_ORDER_DETAIL selectById(int id) {
        return easybuy_order_detailDao.selectById(id);
    }

    @Override
    public int insert(EASYBUY_ORDER_DETAIL od) {
        return easybuy_order_detailDao.insert(od);
    }

    @Override
    public int update(EASYBUY_ORDER_DETAIL od) {
        return easybuy_order_detailDao.update(od);
    }

    @Override
    public int del(int id) {
        return easybuy_order_detailDao.del(id);
    }
}
