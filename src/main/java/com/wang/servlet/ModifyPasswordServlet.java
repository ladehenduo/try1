package com.wang.servlet;

import com.wang.pojo.User;
import com.wang.service.user.UserService;
import com.wang.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ModifyPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        User user = new User();
        String username = req.getParameter("username");
        String oldpassword = req.getParameter("oldpassword");
        String newpassword = req.getParameter("newpassowrd");

        // 获取当前用户
        if(username == null) {
            HttpSession session = req.getSession();
            user = (User) session.getAttribute("CurrentUser");
        }
        else {
            user = userService.getUser(username, oldpassword);
        }
        boolean flag = userService.updatePassword(oldpassword, user);  // 修改
        if(!flag) {
            // 修改失败
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
