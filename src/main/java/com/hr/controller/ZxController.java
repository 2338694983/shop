package com.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 11:29
 **/
@Controller
@RequestMapping("/")
public class ZxController {
    @RequestMapping("/zx")
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("name");
        resp.sendRedirect("indexSelect");
    }
}
