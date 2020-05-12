package com.hr.service;

import com.hr.entity.EASYBUY_DD;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 09:49
 **/
public interface EASYBUY_DDService {
    ArrayList<EASYBUY_DD> selectById(int id);
}
