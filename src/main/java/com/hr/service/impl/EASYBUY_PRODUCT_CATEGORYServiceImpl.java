package com.hr.service.impl;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_COMMENT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.service.EASYBUY_PRODUCT_CATEGORYService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 16:39
 **/
@Service
public class EASYBUY_PRODUCT_CATEGORYServiceImpl implements EASYBUY_PRODUCT_CATEGORYService {
    @Autowired
    private EASYBUY_PRODUCT_CATEGORYDao easybuy_product_categoryDao;
    @Override
    public ArrayList<EASYBUY_PRODUCT_CATEGORY> selectAll() {
        return easybuy_product_categoryDao.selectAll();
    }

    @Override
    public EASYBUY_PRODUCT_CATEGORY selectById(int id) {
        return easybuy_product_categoryDao.selectById(id);
    }

    @Override
    public int insert(EASYBUY_PRODUCT_CATEGORY pc) {
        return easybuy_product_categoryDao.insert(pc);
    }

    @Override
    public int insertOnFather(EASYBUY_PRODUCT_CATEGORY pc) {
        return easybuy_product_categoryDao.insertOnFather(pc);
    }

    @Override
    public int update(EASYBUY_PRODUCT_CATEGORY pc) {
        return easybuy_product_categoryDao.update(pc);
    }

    @Override
    public int del(int id) {
        return easybuy_product_categoryDao.del(id);
    }

    @Override
    public ArrayList<EASYBUY_PRODUCT_CATEGORY> selectFather() {
        return easybuy_product_categoryDao.selectFather();
    }

    @Override
    public ArrayList<EASYBUY_PRODUCT_CATEGORY> selectChild() {
        return easybuy_product_categoryDao.selectChild();
    }
}
