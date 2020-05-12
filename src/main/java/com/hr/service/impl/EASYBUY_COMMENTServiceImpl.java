package com.hr.service.impl;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;
import com.hr.service.EASYBUY_COMMENTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop
 * @description:
 * @author: Mr.L
 * @create: 2020-03-11 11:14
 **/
@Service

public class EASYBUY_COMMENTServiceImpl implements EASYBUY_COMMENTService {

    @Autowired
    private EASYBUY_COMMENTDao easybuy_commentDao;
    @Override
    public ArrayList<EASYBUY_COMMENT> selectAll() {
        return easybuy_commentDao.selectAll();
    }

    @Override
    public EASYBUY_COMMENT selectById(int id) {
        return easybuy_commentDao.selectById(id);
    }

    @Override
    public int insert(EASYBUY_COMMENT c) {
        return easybuy_commentDao.insert(c);
    }

    @Override
    public int update(EASYBUY_COMMENT c) {
        return easybuy_commentDao.update(c);
    }

    @Override
    public int del(int id) {
        return easybuy_commentDao.del(id);
    }

    @Override
    public ArrayList<EASYBUY_COMMENT> selPage(int page,int pagesize) {
        return easybuy_commentDao.selPage((page-1)*pagesize,pagesize);
    }

    @Override
    public EASYBUY_COMMENT selOne(int id) {
        return easybuy_commentDao.selOne(id);
    }

    @Override
    public int u(EASYBUY_COMMENT comment) {
        return easybuy_commentDao.u(comment);
    }

    @Override
    public int getMax(int pagesize) {
        int count = easybuy_commentDao.getMax();
        int max=1;
        if(count%pagesize==0){
            max=(count/pagesize); //总行数是每页行数的整倍数
        }else{
            max=(count/pagesize)+1;//不是整倍数要加一
        }
        return max;
    }

    @Override
    public ArrayList<EASYBUY_COMMENT> selPages(String name, int page, int pages) {
        int min = (page-1)*pages;
        int max = pages;
        ArrayList<EASYBUY_COMMENT> easybuy_comments = easybuy_commentDao.selPages(name,min,max);
        return easybuy_comments;
    }
}
