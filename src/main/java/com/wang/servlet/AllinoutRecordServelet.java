package com.wang.servlet;

import com.google.gson.Gson;
import com.wang.pojo.Record;
import com.wang.service.inoutService.InoutServiceImpl;
import com.wang.service.inoutService.InoutService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class AllinoutRecordServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InoutService inoutService = new InoutServiceImpl();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Record> list = new ArrayList<Record>();
        try {
            list = inoutService.getAllRecord();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String json = new Gson().toJson(list);
        System.out.println(json);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
