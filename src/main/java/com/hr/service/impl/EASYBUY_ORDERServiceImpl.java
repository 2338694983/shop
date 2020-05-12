package com.hr.service.impl;

import com.hr.dao.EASYBUY_ORDERDao;
import com.hr.entity.EASYBUY_ORDER;
import com.hr.service.EASYBUY_ORDERService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 11:11
 **/
@Service
public class EASYBUY_ORDERServiceImpl implements EASYBUY_ORDERService {
    @Autowired
    private EASYBUY_ORDERDao easybuy_orderDao;
    @Override
    public ArrayList<EASYBUY_ORDER> selectAll1() {
        return easybuy_orderDao.selectAll1();
    }

    @Override
    public EASYBUY_ORDER selectById(int id) {
        return easybuy_orderDao.selectById(id);
    }

    @Override
    public int totalPage(int count, String id, String name) {
        if(name!=null && !"".equals(name)){
            name="%"+name+"%";
        }
        int sum = easybuy_orderDao.totalPage(id, name);
        int tpage=1;
        if(sum%count==0){
            tpage=sum/count;
        }else{
            tpage=sum/count+1;
        }
        return tpage;
    }

    @Override
    public ArrayList<EASYBUY_ORDER> selectAll(int cpage, int count, String id, String name) {
        if(name!=null && !"".equals(name)) {
            name = "%" + name + "%";
        }
        return easybuy_orderDao.selectAll(count*(cpage-1),count,id,name);
    }

    @Override
    public int insert(EASYBUY_ORDER o) {
        return easybuy_orderDao.insert(o);
    }

    @Override
    public int update(EASYBUY_ORDER o) {
        return easybuy_orderDao.update(o);
    }

    @Override
    public int del(int id) {
        return easybuy_orderDao.del(id);
    }
}
