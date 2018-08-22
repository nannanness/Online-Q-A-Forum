package org.lanqiao.oqaf.controller.servlet;

import org.lanqiao.oqaf.domain.Article;
import org.lanqiao.oqaf.service.IArticleService;
import org.lanqiao.oqaf.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前用户
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");
        String articleType = request.getParameter("text");
       //获取文章标题
        String articleTitle =  request.getParameter("title");
        //获取文章的内容
        String articleContent = request.getParameter("articleContent");
        //获取根路径
        String realPath = request.getServletContext().getRealPath("/");
        String[] path = realPath.split("out");
        String relativePath = path[0]+"web/";
        System.out.println("我是相对路径="+path[0]);
        String str = UUID.randomUUID()+".txt";
        System.out.println(str);
        //字符串转换为文件存入数据库中  //测试
        Writer writer = new OutputStreamWriter(new FileOutputStream(new File(relativePath+"article/article"+str)),"UTF-8");
        char[] c = new char[1024];
        writer.write(articleContent,0,articleContent.length());
        writer.flush();
        Date date = new Date();
        String sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
        Article article = new Article("article/article"+str,34,userId,articleTitle,articleType,sim);
        IArticleService service = new ArticleServiceImpl();
        service.insertArticle(article);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    }
