package com.hr.service;

import com.hr.entity.EASYBUY_Ddan;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 09:15
 **/
public interface EASYBUY_DdanService {
    ArrayList<EASYBUY_Ddan> selectById(String id);
}
