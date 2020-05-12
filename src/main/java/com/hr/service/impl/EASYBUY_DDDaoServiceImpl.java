package com.hr.service.impl;

import com.hr.dao.EASYBUY_DDDao;
import com.hr.entity.EASYBUY_DD;
import com.hr.service.EASYBUY_DDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 09:50
 **/
@Service
public class EASYBUY_DDDaoServiceImpl implements EASYBUY_DDService {
    @Autowired
    private EASYBUY_DDDao easybuy_ddDao;
    @Override
    public ArrayList<EASYBUY_DD> selectById(int id) {
        return easybuy_ddDao.selectById(id);

    }
}
