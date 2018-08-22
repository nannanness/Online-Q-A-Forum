package org.lanqiao.oqaf.controller.servlet;

import org.lanqiao.oqaf.domain.Problem_Replay;
import org.lanqiao.oqaf.service.IIndexCountService;
import org.lanqiao.oqaf.service.IRemarkService;
import org.lanqiao.oqaf.service.impl.IndexCountServiceImpl;
import org.lanqiao.oqaf.service.impl.RemarkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
    private IIndexCountService iProblemService = new IndexCountServiceImpl();
    private IRemarkService iRemarkService = new RemarkServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method){
            case "init":
                initIndex(request,response);
                break;
            case "loadMore"://加载更多
                loadMore(request,response);
                break;
            case "search"://搜索
                search(request,response);
                break;
            case "replay":
                replayIndex(request, response);
                break;
            case "ifReplay":
                ifReplay(request,response);
                break;
        }
    }
    //初始化页面
    public void initIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();//获取session对象
        List<Problem_Replay> problem_replayList = iProblemService.getIndexCountByIndex(1);//获取问题回答数据
        List<Problem_Replay> list = getIndexList(request,response,problem_replayList);
        session.setAttribute("problem_replayList",list);//将list添加到session中
    }
    //回答页面
    public void replayIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();//获取session对象
        //-------------------------------------------------------------------
        int userId = (int)session.getAttribute("userId");//获取用户当前的id
        int problemId = Integer.valueOf(request.getParameter("problemId"));
        PrintWriter out = response.getWriter();
        //获取文章的标题
        String title = request.getParameter("problemTitle");
        //获取回答者的id
        session.setAttribute("Articletitle",title);
        session.setAttribute("problemId",problemId);
        request.getRequestDispatcher("/replay.jsp").forward(request,response);

    }
    //加载更多
    public void loadMore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        //获取当前数据内容
        HttpSession session = request.getSession();
        List<Problem_Replay> pro = (List<Problem_Replay>)session.getAttribute("problem_replayList");
        //获取页面上传过来的当前页数
        String index = request.getParameter("index");
        int indexInt = Integer.valueOf(index);
        //获取所有的数据
        List<Problem_Replay> problem_replaysAll = iProblemService.getIndexAll();
        int size = problem_replaysAll.size();
        //判断当前页是否是末页
        if((size/10) > indexInt){
            List<Problem_Replay> problem_replays = iProblemService.getIndexCountByIndex((indexInt+1)*10);
            List<Problem_Replay> list = getIndexList(request,response,problem_replays);//获取新查询来的list
            for(Problem_Replay p:list){
                pro.add(p);
            }
            session.setAttribute("problem_replayList",pro);
            indexInt+=1;
            out.write(String.valueOf(indexInt));
        }


    }

    //搜索页面的跳转
    public void search(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String searchContent =  request.getParameter("searchContent");
        List<Problem_Replay> searchList = iProblemService.getIndexContentByLike(searchContent,searchContent,0);//获取用户搜索的内容
        session.setAttribute("problem_replayList",searchList);//将searchList添加到session中


    }
    //获取页面上需要的list
    public List<Problem_Replay> getIndexList(HttpServletRequest request, HttpServletResponse response, List<Problem_Replay> list) throws IOException {
        String path = request.getServletContext().getRealPath("/");
        String[] realPath = path.split("out");
        System.out.println(realPath);
        for(Problem_Replay p : list){
            String txtPath = p.getReplayContent();
            File file = new File(realPath[0]+"web/"+txtPath);
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024*10];
            int len =0;
            String str=null;
            while ((len =inputStream.read(bytes)) !=-1){
                str = new String((bytes),"GBK");
            }
            p.setReplayContent(str);
        }
        return list;
    }
    //判断用户是否回答过这个问题
    public void ifReplay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");//获取用户当前的id
        int problemId = Integer.valueOf(request.getParameter("problemId"));
        PrintWriter out = response.getWriter();
        List<Problem_Replay> proReplay = iRemarkService.getReplayUsers(problemId);
        List ints = new ArrayList<>();
        for(Problem_Replay p : proReplay){
            ints.add(p.getReplayUserId());
        }
        String title = request.getParameter("problemTitle");
        //获取回答者的id
        session.setAttribute("Articletitle",title);
        session.setAttribute("problemId",problemId);
        if(ints.contains(userId)){

        }else{
            out.write("true");
        }
        out.flush();
        out.close();

    }


}
