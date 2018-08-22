package org.lanqiao.oqaf.controller.servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.lanqiao.oqaf.domain.Replay;
import org.lanqiao.oqaf.service.IReplayService;
import org.lanqiao.oqaf.service.impl.ReplayServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 回答界面的servlet
 */
@WebServlet("/ReplayServlet")
public class ReplayServlet extends HttpServlet {
    private IReplayService service = new ReplayServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取回答的内容
        String replayContent = request.getParameter("replayContent");
        //获取路径
        String path = request.getServletContext().getRealPath("/");
        String[] Realapath = path.split("out");
        String relativePath = Realapath[0]+"web/";
        //使用UUID来得到随机数
        String str = UUID.randomUUID() + ".txt";
        //使用Writer将字符串存在文件中
        Writer out = new OutputStreamWriter(new FileOutputStream(new File(relativePath+"replay/replay"+str)));
        char[] c = new char[1024];
        out.write(replayContent,0,replayContent.length());
        out.close();
        Date date = new Date();
        String sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);

        //获取当前用户id
        int userId = (int) session.getAttribute("userId");
        //获取回答的问题id
        int problemId = (int) session.getAttribute("problemId");
        Replay replay = new Replay(problemId,userId,0,"replay/replay"+str,sim,0);
        service.insertReplay(replay);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
