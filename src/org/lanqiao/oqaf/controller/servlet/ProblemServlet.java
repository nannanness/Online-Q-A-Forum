package org.lanqiao.oqaf.controller.servlet;

import org.lanqiao.oqaf.domain.Problem;
import org.lanqiao.oqaf.service.IProblemService;
import org.lanqiao.oqaf.service.impl.ProblemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 提问Servlet
 */
@WebServlet("/problemServlet")
public class ProblemServlet extends HttpServlet {
    private IProblemService service = new  ProblemServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");
        //获取用户问题标题
        String problemTitle = request.getParameter("title");
        //获取用户的类型
        String problemType = request.getParameter("Type");
        //获取文本域中的内容
        String problemContent = request.getParameter("text");
        Date date = new Date();
        String dataStr = date.toString();
        String sim = new SimpleDateFormat("yyyy-mm-ss HH:MM:SS").format(date);
        Problem problem = new Problem(userId,problemTitle,problemContent,problemType,sim);
        service.insertProblem(problem);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
