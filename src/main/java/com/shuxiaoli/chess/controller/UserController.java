package com.shuxiaoli.chess.controller;

import com.shuxiaoli.chess.entity.User;
import com.shuxiaoli.chess.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class UserController {
    public static Integer USER_ID = null;
    @Autowired
    IUserService ius;
    @RequestMapping("/login")
    public String toLogin() {

        return "/jsp/login";
    }

    @RequestMapping(value = "/user_login", method = RequestMethod.POST)
    public String user_login(User user, HttpServletResponse response) throws IOException {
        List<User> findUser = ius.findOne(user.getUser_name());
        for (User i : findUser) {
            if (user.getUser_password().equals(i.getUser_password())) {
                USER_ID = i.getUser_id();
                return "/jsp/index";
            }
        }
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        out.flush();
        out.println("<script>");
        out.println("alert('密码或账号错误，请重新输入！');");
        out.println("history.back();");
        out.println("</script>");
        return "/jsp/login";
    }

//    public void testSaveClasses() {
//        Session session = sessionfactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = new User();
//        session.save(user);
//        //进行crud操作
//        transaction.commit();
//        session.close();
//    }

    @RequestMapping("/register")
    public String register(Model model) {
        List<User> users = ius.findAll();
        model.addAttribute("userList",users);
        return "/jsp/register";
    }
    @RequestMapping(value = "/register_login", method = RequestMethod.POST)
    public String  register_login(User user){
        ius.saveUser(user);
        return "/jsp/login";
    }

// 由客服端或Jsp页面发出一个Request（访问方式为：http://127.0.0.1:8080/login或action='login'),由注入为@Controller的控制类，
// 注入为@RequestMapping（"/login"）控制方法接收请求，调用注入为@Service的类处理相应的逻辑操作，
// 其中对数据库（Mysql）的访问方式采用Hibernate框架。最后再由控制器返回response数据，由Jsp页面接收。
}
