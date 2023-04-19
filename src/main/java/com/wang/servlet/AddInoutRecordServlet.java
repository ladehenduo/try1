package com.wang.servlet;

import com.wang.pojo.Record;
import com.wang.pojo.User;
import com.wang.service.inoutService.InoutService;
import com.wang.service.inoutService.InoutServiceImpl;
import com.wang.utils.Date2Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class AddInoutRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InoutService service = new InoutServiceImpl();

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("CurrentUser");
        String username = user.getUsrename();
        String inout_type = req.getParameter("choice");
        boolean flag = false;
        if(!inout_type.equals("")) {
            String time = Date2Date.javaToString(new Date());
            flag = service.addRecord(username, inout_type, time);
        }
        if(!flag) {
            // 添加失败
            resp.getWriter().write("<script   language=javascript>alert('filed');window.location='JSP/submitrecordpage.jsp'</script>");
        }
        else {
            resp.getWriter().write("<script   language=javascript>alert('success');window.location='JSP/submitrecordpage.jsp'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
