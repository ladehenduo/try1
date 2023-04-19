package com.wang.servlet;

import com.wang.pojo.Profile;
import com.wang.pojo.User;
import com.wang.service.user.UserService;
import com.wang.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String tel = req.getParameter("tel");
        String IDcrad = req.getParameter("IDcard");

        User user = new User(username, password, "dafault");
        Profile profile = new Profile();
        profile.setUsername(username);
        profile.setIDcard(IDcrad);
        profile.setTel(tel);

        /*
        * 从前端获取User，profile信息
        * */
        UserService userService = new UserServiceImpl();
        boolean flag = userService.register(user, profile);
        if(flag) {
            resp.getWriter().write("<script charset='UTF-8' language=javascript>alert('注册成功');window.location='index.jsp'</script>");
        }
        else {
            //注册失败
            resp.getWriter().write("<script charset='UTF-8' language=javascript>alert('用户已存在或身份证已注册');window.location='JSP/register.jsp'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
