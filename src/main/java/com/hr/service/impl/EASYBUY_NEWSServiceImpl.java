package com.hr.service.impl;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.service.EASYBUY_NEWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 10:11
 **/
@Service
public class EASYBUY_NEWSServiceImpl implements EASYBUY_NEWSService {
    @Autowired
    private EASYBUY_NEWSDao easybuy_newsDao;
    @Override
    public ArrayList<EASYBUY_NEWS> selectAll1() {
        return easybuy_newsDao.selectAll1();
    }

    @Override
    public EASYBUY_NEWS selectById(int id) {
        return easybuy_newsDao.selectById(id);
    }

    @Override
    public ArrayList<EASYBUY_NEWS> selectAll(int cpage, int count) {
        return easybuy_newsDao.selectAll(count*(cpage-1),count);
    }

    @Override
    public int totalPage(int count) {
        int tpage=1;
        int i = easybuy_newsDao.totalPage(count);
        if(i%count==0){
            tpage=i/count;
        }else{
            tpage=i/count+1;
        }
        return tpage;
    }

    @Override
    public int insert(EASYBUY_NEWS n) {

        return easybuy_newsDao.insert(n);
    }

    @Override
    public int update(EASYBUY_NEWS n) {
        return easybuy_newsDao.update(n);
    }

    @Override
    public int del(int id) {
        return easybuy_newsDao.del(id);
    }
}
