package com.hr.service.impl;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.service.EASYBUY_USERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-14 10:28
 **/
@Service
public class EASYBUY_USERServiceImpl implements EASYBUY_USERService {
    @Autowired
    private EASYBUY_USERDao easybuy_userDao;
    @Override
    public ArrayList<EASYBUY_USER> selectAll(int cpage, int count) {
        return easybuy_userDao.selectAll2(count*(cpage-1),count);
    }

    @Override
    public ArrayList<EASYBUY_USER> selectAll() {
        return easybuy_userDao.selectAll();
    }

    @Override
    public EASYBUY_USER selectById(String id) {
        return easybuy_userDao.selectById(id);
    }

    @Override
    public int selectByName(String id) {
        return easybuy_userDao.selectByName(id);
    }

    @Override
    public int selectByNM(String name, String pwd) {
        return easybuy_userDao.selectByNM(name,pwd);
    }

    @Override
    public EASYBUY_USER selectAdmin(String name, String pwd) {
        return easybuy_userDao.selectAdmin(name,pwd);
    }

    @Override
    public int totalPage(int count) {
        int sum = easybuy_userDao.totalPage();
        int tpage=1;
        if(sum%count==0){
            tpage=sum/count;
        }else{
            tpage=sum/count+1;
        }
        return tpage;
    }

    @Override
    public int insert(EASYBUY_USER u) {
        return easybuy_userDao.insert(u);
    }

    @Override
    public int update(EASYBUY_USER u) {
        return easybuy_userDao.update(u);
    }

    @Override
    public int del(String id) {
        return easybuy_userDao.del(id);
    }
}
