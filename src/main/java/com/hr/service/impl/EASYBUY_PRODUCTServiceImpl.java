package com.hr.service.impl;


import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.service.EASYBUY_PRODUCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 16:59
 **/
@Service
public class EASYBUY_PRODUCTServiceImpl implements EASYBUY_PRODUCTService {
    @Autowired
    private EASYBUY_PRODUCTDao easybuy_productDao;
//    @Override
    public ArrayList<EASYBUY_PRODUCT> selectAll() {
        return easybuy_productDao.selectAll();
    }


    public ArrayList<EASYBUY_PRODUCT> selectAllByName(String name) {
        return easybuy_productDao.selectAllByName("%"+name+"%");
    }
    @Override
    public EASYBUY_PRODUCT selectById(int id) {
        return easybuy_productDao.selectById(id);
    }

    @Override
    public ArrayList<EASYBUY_PRODUCT> selectAllByFid(int fid) {
        return easybuy_productDao.selectAllByFid(fid);
    }

    @Override
    public ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cid) {
        return easybuy_productDao.selectAllByCid(cid);
    }

    @Override
    public int insert(EASYBUY_PRODUCT p) {
        return easybuy_productDao.insert(p);
    }

    @Override
    public int update(EASYBUY_PRODUCT p) {
        if (!p.getEP_FILE_NAME().equals("")){
        return easybuy_productDao.update(p);
        }else {
            return easybuy_productDao.update2(p);
        }
    }

    @Override
    public int del(int id) {
        return easybuy_productDao.del(id);
    }

    @Override
    public int totalPage(int count) {
        int sum = easybuy_productDao.totalPage();
        int tpage=1;
        if(sum%count==0){
            tpage = sum/count;
        }else {
            tpage = sum/count+1;
        }
        return tpage;
    }

    @Override
    public int totalPageByFid(int count, int fid) {
        int sum = easybuy_productDao.totalPageByFid(fid);
        int tpage=1;
        if(sum%count==0){
            tpage = sum/count;
        }else {
            tpage = sum/count+1;
        }
        return tpage;
    }

    @Override
    public int totalPageByCid(int count, int cid) {
        int sum = easybuy_productDao.totalPageByCid(cid);
        int tpage=1;
        if(sum%count==0){
            tpage = sum/count;
        }else {
            tpage = sum/count+1;
        }
        return tpage;
    }

    @Override
    public int totalPageByName(int count, String name) {
        int sum = easybuy_productDao.totalPageByName("%" + name + "%");
        int tpage=1;
        if(sum%count==0){
            tpage = sum/count;
        }else {
            tpage = sum/count+1;
        }
        return tpage;
    }
    @Override
    public ArrayList<EASYBUY_PRODUCT> selectAll(int cpage, int count) {
        return easybuy_productDao.selectAll2(count*(cpage-1),count);
    }

    @Override
    public ArrayList<EASYBUY_PRODUCT> selectAllByFid(int cpage, int count, int fid) {
        return easybuy_productDao.selectAllByFid2(count*(cpage-1),count,fid);
    }

    @Override
   public ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cpage, int count, int cid) {
        return easybuy_productDao.selectAllByCid2(count*(cpage-1),count,cid);
    }

    @Override
     public ArrayList<EASYBUY_PRODUCT> selectById(ArrayList<Integer> ids) {
        return easybuy_productDao.selectById2(ids);
    }

  @Override
    public ArrayList<EASYBUY_PRODUCT> selectAllByT() {
        return easybuy_productDao.selectAllByT();
    }

    @Override
    public ArrayList<EASYBUY_PRODUCT> selectAllByHot() {
        return easybuy_productDao.selectAllByHot();
    }

    @Override
    public void insertEP(EASYBUY_PRODUCT easybuy_product){
        easybuy_productDao.insert(easybuy_product);
    };
}
