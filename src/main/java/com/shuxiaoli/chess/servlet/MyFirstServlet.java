package com.shuxiaoli.chess.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFirstServlet extends HttpServlet {
    /**
     * 构造方法
     */
    public MyFirstServlet() {
        System.out.println("1. 我被创建了......");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 方法被调用......");
        resp.getWriter().append("my frist servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 方法被调用......");
        doGet(req, resp);
    }
    /**
     * service方法
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3. service方法被调用......");
    }

    @Override
    public void destroy() {
        System.out.println("4. 调用destroy方法......");
    }


    /**
     * init方法
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2. init方法被调用......");
    }
}
