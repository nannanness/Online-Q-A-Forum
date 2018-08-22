package org.lanqiao.oqaf.controller.servlet;

import org.lanqiao.oqaf.Utils.NumCheck;
import org.lanqiao.oqaf.domain.User;
import org.lanqiao.oqaf.service.IUserService;
import org.lanqiao.oqaf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
    private int userId;
    private IUserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //判断用户的操作
        String method = request.getParameter("method");
        switch(method){
            case "login":
                Login(request, response);
                break;
            case "register":
                register(request, response);
                break;
            case "esc":
                esc(request,response);
            case "getCheck":
                getCheck(request,response);
                break;
        }

    }
    //获取验证码
    public void getCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String num = NumCheck.getNumCheck().toString();//获取验证码
        PrintWriter out = response.getWriter();
        out.write(num);
        HttpSession session = request.getSession();
        session.setAttribute("numCheck1",num);
        out.flush();
        out.close();
    }
    //判断用户登陆
    public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");//获取到用户输入的用户名
        String password = request.getParameter("password");//获取用户的输入的密码
        List<User> userInfos = userService.getUserInfo();//获取所有用户的信息
        HttpSession session = request.getSession();//获取session对象
        boolean flag = false;//判断是否登陆成功
        for(User u : userInfos){
            if((username.equals(u.getUser_Name()) || username.equals(u.getUser_phone()))&&password.equals(u.getPass_Word())){
                flag = true;
                userId=u.getUser_Id();
            }
        }
        if(flag){
            session.setAttribute("ifLogin",true);//判断登陆成功后的给session中放入ifLogin
            session.setAttribute("userId",userId);//将用户的id放入session中
            User userInfo = userService.getUserById(userId);//获取当前用户
            session.setAttribute("userInfo",userInfo);//将用户放入到session
            session.setAttribute("userImg",userInfo.getUser_Img());//将图片路径放入到session中
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","你输入的有误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    //判断用户注册
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean flagPhone = true;
        String phoneNum = request.getParameter("phoneNum");//获取用户输入的手机号
        String checkNum = request.getParameter("numCheck");//获取用户输入的验证码
        HttpSession session = request.getSession();
        String num = (String)session.getAttribute("numCheck1");//获取session中的验证码
        List<User> userInfoList = userService.getUserInfo();//获取所有用户
        if(phoneNum!=null &&!phoneNum.equals("")){
            for(User u:userInfoList){
                if(u.getUser_phone().equals(phoneNum)){
                    flagPhone = false;
                }
            }
        }
        if(flagPhone && checkNum.equals(num)){
            out.write("注册成功");
            userService.insterUser(phoneNum);

        }else if(!flagPhone){
            out.write("你已经注册");

        }else {
            out.write("你的验证码有误");
        }
        out.flush();
        out.close();


    }
    //退出登陆
    public void esc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("ifLogin");
        session.removeAttribute("userId");
        session.removeAttribute("userImg");
        response.getWriter().write("退出成功");

    }




}
