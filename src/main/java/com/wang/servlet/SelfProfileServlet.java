package com.wang.servlet;

import com.google.gson.Gson;
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

public class SelfProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        ProfileService profileService = new ProfileServiceImpl();
        User user = (User) session.getAttribute("CurrentUser");

        // 获取当前登录的个人信息
        Profile profile = profileService.getProfileByUser(user.getUsrename());
        // 存储在resp中返回即可
        String json = new Gson().toJson(profile);
        System.out.println(json);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
