package org.lanqiao.oqaf.controller.servlet;

import org.lanqiao.oqaf.domain.User;
import org.lanqiao.oqaf.service.IUserService;
import org.lanqiao.oqaf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户信息修改（头像和背景图单独处理）
 */
@WebServlet("/updateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userDetails = request.getParameter("userDetails");
        String sex = request.getParameter("sex");
        String userSchool = request.getParameter("userSchool");
        int userId = (int) request.getSession().getAttribute("userId");
        User user = new User();
        user.setUser_Id(userId);
        user.setUser_Details(userDetails);
        user.setUser_Name(username);
        user.setUser_Sex(sex);
        user.setUser_school(userSchool);
        service.updateUser(user);
        User userInfo = service.getUserById(userId);
        request.getSession().setAttribute("userInfo" , userInfo);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
