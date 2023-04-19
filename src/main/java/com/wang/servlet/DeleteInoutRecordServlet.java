package com.wang.servlet;

import com.wang.service.inoutService.InoutService;
import com.wang.service.inoutService.InoutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteInoutRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InoutService service = new InoutServiceImpl();
        String username = req.getParameter("username");
        String time = req.getParameter("time");
        boolean flag = service.deleteRecord(username, time);
        if(!flag) {
            // 删除失败
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
