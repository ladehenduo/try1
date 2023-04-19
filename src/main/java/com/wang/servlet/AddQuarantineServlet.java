package com.wang.servlet;

import com.wang.service.quarantineService.QuarantineService;
import com.wang.service.quarantineService.QuarantineServiceImpl;
import com.wang.utils.Date2Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AddQuarantineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuarantineService service = new QuarantineServiceImpl();
        boolean f1 = true;
        String username = req.getParameter("username");
        String time = Date2Date.javaToString(new Date());
        String room = req.getParameter("room");
        String sday = req.getParameter("day");
        if(username == null || room == null || sday == null) f1 = false;
        if(f1) {
            System.out.println(sday);
            int day = Integer.valueOf(sday);
            System.out.println(day);
            boolean flag = service.addQuarantinePeople(username, time, day, room);
            if(!flag) {
                // 添加失败
                resp.getWriter().write("<script   language=javascript>alert('failed');window.location='JSP/submitquarantine.jsp'</script>");
            }
            else {
                resp.getWriter().write("<script   language=javascript>alert('success');window.location='JSP/submitquarantine.jsp'</script>");
            }
        }
        else {
            resp.getWriter().write("<script   language=javascript>alert('failed');window.location='JSP/submitquarantine.jsp'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
