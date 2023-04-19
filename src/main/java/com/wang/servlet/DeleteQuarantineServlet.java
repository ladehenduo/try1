package com.wang.servlet;

import com.wang.service.inoutService.InoutService;
import com.wang.service.inoutService.InoutServiceImpl;
import com.wang.service.quarantineService.QuarantineService;
import com.wang.service.quarantineService.QuarantineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteQuarantineServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuarantineService service = new QuarantineServiceImpl();
        String username = req.getParameter("username");
        boolean flag = service.deleteQuarantinePeople(username);
        if(!flag) {
            // 删除失败
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
