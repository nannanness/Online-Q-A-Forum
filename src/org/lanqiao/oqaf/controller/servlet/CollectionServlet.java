package org.lanqiao.oqaf.controller.servlet;

import org.lanqiao.oqaf.domain.Collection;
import org.lanqiao.oqaf.domain.Replay;
import org.lanqiao.oqaf.domain.User;
import org.lanqiao.oqaf.service.ICollectionService;
import org.lanqiao.oqaf.service.impl.CollectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/collectionServlet")
public class CollectionServlet extends HttpServlet {
    private ICollectionService service = new CollectionServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        System.out.println("pid----------" + pid);
        int uid = Integer.parseInt(request.getParameter("uid"));
        System.out.println("uid----------" + uid);
        User user = (User) request.getSession().getAttribute("userInfo");
        int userId = user.getUser_Id();
        System.out.println("userId----------" + userId);
        String method = request.getParameter("method");
        System.out.println("method----------" + method);
        switch (method) {
            case "collectReplay":
                collectReplay(request, response, pid, uid, userId);
                break;
            case "cancelCollectReplay":
                cancelCollectReplay(request,response,pid,uid,userId);
        }
    }

    protected void collectReplay(HttpServletRequest request, HttpServletResponse response, int pid, int uid, int userId) throws ServletException, IOException {
        Replay replay = service.getOneReplay(pid, uid);
        System.out.println("replay----------" + replay);
        String replayContent = replay.getReplayContent();
        System.out.println("replayContent----------" + replayContent);
        Collection collection = new Collection(pid, userId, uid, replayContent);

        service.collectReplay(collection);
    }

    protected void cancelCollectReplay(HttpServletRequest request, HttpServletResponse response, int pid, int uid, int userId) throws ServletException, IOException {
        Replay replay = service.getOneReplay(pid, uid);
        System.out.println("replay----------" + replay);
        String replayContent = replay.getReplayContent();
        System.out.println("replayContent----------" + replayContent);
        Collection collection = new Collection(pid, userId, uid, replayContent);
        service.cancelCollectReplay(collection);
    }
}

