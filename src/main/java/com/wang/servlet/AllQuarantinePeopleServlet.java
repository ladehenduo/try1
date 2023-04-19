package com.wang.servlet;

import com.google.gson.Gson;
import com.wang.pojo.QuarantinePeople;
import com.wang.service.quarantineService.QuarantineService;
import com.wang.service.quarantineService.QuarantineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllQuarantinePeopleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<QuarantinePeople> list = new ArrayList<QuarantinePeople>();
        QuarantineService quarantineService = new QuarantineServiceImpl();
        // 获取
        list = quarantineService.getAllQuarantine();
        // 转JSON
        String json = new Gson().toJson(list);
        // 返回
        System.out.println("here" + json);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
