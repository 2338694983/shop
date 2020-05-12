package com.hr.service.impl;

import com.hr.dao.EASYBUY_DdanDao;
import com.hr.entity.EASYBUY_Ddan;
import com.hr.service.EASYBUY_DdanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:购买记录
 * @author: Mr.L
 * @create: 2020-03-13 09:15
 **/
@Service
public class EASYBUY_DdanServiceImpl implements EASYBUY_DdanService {
    @Autowired
    private EASYBUY_DdanDao easybuy_ddanDao;
    @Override
    public ArrayList<EASYBUY_Ddan> selectById(String id) {
            return easybuy_ddanDao.selectById(id);
    }

}
