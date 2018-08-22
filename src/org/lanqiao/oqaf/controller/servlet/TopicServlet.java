package org.lanqiao.oqaf.controller.servlet;

import org.lanqiao.oqaf.domain.Problem_Replay;
import org.lanqiao.oqaf.service.IIndexCountService;
import org.lanqiao.oqaf.service.IProblemService;
import org.lanqiao.oqaf.service.impl.IndexCountServiceImpl;
import org.lanqiao.oqaf.service.impl.ProblemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/topicServlet")
public class TopicServlet extends HttpServlet {
    private IIndexCountService iProblemService = new IndexCountServiceImpl();
    private int nowPage = 1;
    private int sumPage;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        String page = request.getParameter("page");
        takePage(page);
        switch(method){
            case "init":
                topicInit(request,response);
                break;
            case "codeClass":
                codeClass(request,response);
                break;
            case "topicSearch":
                topicSearch(request,response);
                break;
            case "moreHotTopic":
                getMoreTopicHot(request,response);
                break;
        }
    }

    public void takePage(String page){
        if(page != null){
            switch (page){
                case "prev":
                    nowPage--;
                    break;
                case "next":
                    nowPage++;
                    break;
                case "home":
                    nowPage = 1;
                    break;
            }
        }
    }

    //话题初始化
    public void topicInit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();//获取session对象
        int temp = iProblemService.getIndexAll().size()%10;
        if(temp > 0 && temp < 10){
            sumPage = iProblemService.getIndexAll().size()/10 + 1;
        }else {
            sumPage = iProblemService.getIndexAll().size()/10;
        }
        session.setAttribute("nowPage",nowPage);
        session.setAttribute("sumPage",sumPage);
        List<Problem_Replay> problem_replayList = iProblemService.getIndexCountByIndex(nowPage);//获取问题回答数据
        List<Problem_Replay> Topiclist = getIndexList(request,response,problem_replayList);
        session.setAttribute("Topiclist",Topiclist);//将list添加到session中
        session.setAttribute("topicmethod","init");
        request.getRequestDispatcher("topic.jsp").forward(request,response);

    }
    //编程类
    public void codeClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();//获取session对象
        String type = request.getParameter("type");//获取请求的参数

        int temp = iProblemService.getIndexCountByType(type).size()%10;
        if(temp > 0 && temp < 10){
            sumPage = iProblemService.getIndexCountByType(type).size()/10 + 1;
        }else {
            sumPage = iProblemService.getIndexCountByType(type).size()/10;
        }
        session.setAttribute("nowPage",nowPage);
        session.setAttribute("sumPage",sumPage);
        List<Problem_Replay> typeCountList = iProblemService.getIndexCountByTypeByPage(type,nowPage);
        typeCountList = getIndexList(request,response,typeCountList);
        session.setAttribute("Topiclist",typeCountList);//将list添加到session中
        session.setAttribute("topicmethod","codeClass");
        request.getRequestDispatcher("topic.jsp").forward(request,response);

//        System.out.println(type);
    }

    //topic中搜索的内容
    public void topicSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String search = request.getParameter("searchContent");
        int temp = iProblemService.getIndexContentByLikeByAll(search,search).size()%10;
        if(temp > 0 && temp < 10){
            sumPage = iProblemService.getIndexContentByLikeByAll(search,search).size()/10 + 1;
        }else {
            sumPage = iProblemService.getIndexContentByLikeByAll(search,search).size()/10;
        }
        session.setAttribute("nowPage",nowPage);
        session.setAttribute("sumPage",sumPage);
        List<Problem_Replay> searchList = iProblemService.getIndexContentByLike(search,search,nowPage);//获取用户搜索的内容
        searchList = getIndexList(request,response,searchList);
        session.setAttribute("Topiclist",searchList);//将list添加到session中
        session.setAttribute("topicmethod","topicSearch");
        request.getRequestDispatcher("topic.jsp").forward(request,response);

//        System.out.println("我是的"+search);
    }

    //根据评论数目进行排序获取热门话题
    public void getMoreTopicHot(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int temp = iProblemService.getAllProblemReplay().size()%10;
        if(temp > 0 && temp < 10){
            sumPage = iProblemService.getAllProblemReplay().size()/10 + 1;
        }else {
            sumPage = iProblemService.getAllProblemReplay().size()/10;
        }
        session.setAttribute("nowPage",nowPage);
        session.setAttribute("sumPage",sumPage);
        //得到list集合
        List<Problem_Replay> prList = iProblemService.getAllProblemReplayByPage(nowPage);
        prList = getIndexList(request,response,prList);
        session.setAttribute("Topiclist",prList);
        session.setAttribute("topicmethod","moreHotTopic");
        request.getRequestDispatcher("/topic.jsp").forward(request,response);
    }

    //获取页面上需要的list
    public List<Problem_Replay> getIndexList(HttpServletRequest request, HttpServletResponse response,List<Problem_Replay> list) throws IOException {
        String path = request.getServletContext().getRealPath("/");
        String[] realPath = path.split("out");
//        System.out.println(realPath);
        for(Problem_Replay p : list){
            String txtPath = p.getReplayContent();
            File file = new File(realPath[0]+"web/"+txtPath);
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len =0;
            String str=null;
            while ((len = inputStream.read(bytes)) !=-1){
                str = new String((bytes),"GBK");
            }
            p.setReplayContent(str);
        }
        return list;
    }

}
