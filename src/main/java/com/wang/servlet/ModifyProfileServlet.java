package com.wang.servlet;

import com.wang.pojo.Profile;
import com.wang.pojo.User;
import com.wang.service.ProfileService.ProfileService;
import com.wang.service.ProfileService.ProfileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ModifyProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("CurrentUser");
        ProfileService profileService = new ProfileServiceImpl();
        System.out.println("修改找到了user=" + user.getUsrename());

        String username = user.getUsrename();
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        int age = Integer.valueOf(req.getParameter("age")).intValue();
        String IDcard = req.getParameter("IDcard");
        String health = req.getParameter("health");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");
        System.out.println(name + sex + age + IDcard + health + tel + address);

        Profile profile = new Profile(username, name, sex, age, IDcard, health, tel, address);
        boolean flag = profileService.updateProfile(profile); // 修改接受返回值

        resp.sendRedirect("JSP/profilepage.jsp");
        if(!flag) {
            // 修改失败
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
