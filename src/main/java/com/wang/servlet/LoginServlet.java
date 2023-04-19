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
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        UserService userService = new UserServiceImpl();
        User user = userService.getUser(username, password);

        if(user!=null) { // 有此账户
            if(user.getPassword().equals(password)){
                session.setAttribute("CurrentUser", user);
                resp.sendRedirect("JSP/mainframe.jsp");
            }
            else {
                resp.getWriter().write("<script   language=javascript>alert('password error');window.location='index.jsp'</script>");
            }
        }
        else { // 查无此人
            resp.getWriter().write("<script   language=javascript>alert('no Account');window.location='index.jsp'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
