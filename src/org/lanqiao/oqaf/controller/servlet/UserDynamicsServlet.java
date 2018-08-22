package org.lanqiao.oqaf.controller.servlet;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.lanqiao.oqaf.domain.*;
import org.lanqiao.oqaf.service.ICareUserService;
import org.lanqiao.oqaf.service.ICollectionService;
import org.lanqiao.oqaf.service.IUserDynamicsService;
import org.lanqiao.oqaf.service.IUserService;
import org.lanqiao.oqaf.service.impl.CareUserServiceImpl;
import org.lanqiao.oqaf.service.impl.CollectionServiceImpl;
import org.lanqiao.oqaf.service.impl.UserDynamicsService;
import org.lanqiao.oqaf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@WebServlet("/userDynamicsServlet")
public class UserDynamicsServlet extends HttpServlet {
    private IUserDynamicsService service = new UserDynamicsService();
    private ICareUserService careUserService = new CareUserServiceImpl();
    private IUserService userService = new UserServiceImpl();
    private ICollectionService collectionService = new CollectionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lookUserIdStr = request.getParameter("lookUserId");
        int lookUserIdInt=0;
        if(lookUserIdStr!=null){
            lookUserIdInt = Integer.valueOf(request.getParameter("lookUserId"));//获取要查看用户的id
        }
        Object userIdStr = request.getSession().getAttribute("userId");
        int userId =-1;
        if(userIdStr !=null){
            userId = (int) request.getSession().getAttribute("userId");//获取当前用户
        }
        String method = request.getParameter("method");
        switch(method){
            case "init":
                initUserInfo(request,response);
                break;
            case "cancleSight":
                cancleSight(request,response);
                break;
            case "sightUser":
                sightUser(request,response);
                break;
            case "lookUserInfo":
                if(lookUserIdInt !=userId){
                    lookUserInfo(request,response);
                }else{
                    initUserInfo(request,response);
                }
                break;
            case "careLookUser":
                careLookUser(request,response);
                break;
            case "deleteCollection":
                deleteCollection(request,response);
                break;
            case "deleteResponse":
                deleteResponse(request,response);
                break;
            case "deleteQusetion":
                deleteQusetion(request,response);
                break;
            case"deleteAriticle":
                deleteAriticle(request,response);
                break;
        }

    }
    //初始化用户信息
    public void initUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int userId = (int) request.getSession().getAttribute("userId");
        // 根据要访问的人id查出用户,保存在request中
        User user = userService.getUserById(userId);
        request.setAttribute("userInfo",user);
        // 查用户回答
        List<UserResponse> listUserResponse = service.queryUserResponse(userId);
        // 获取用户回答内容
        List<UserResponse> userResponselist = getUserResponse(request,response,listUserResponse);
        // 查用户提问
        List<UserQuestion> listUserQuestion = service.queryUserQuestion(userId);
        // 查用户文章
        List<UserArticle> listUserArticle = service.queryUserArticle(userId);
        // 获取文章内容
        List<UserArticle> userArticlelist = getUserArticle(request,response,listUserArticle);
        //查询用户收藏信息
        List<UserInfoCollection> collections = collectionService.getUserInfoCollection(userId);
        collections = getrenewCollection(request,response,collections);
        // 查询用户关注的人
        List<CareUser> listIdol = careUserService.findIdol(userId);
        // 查询用户关注的人
        List<CareUser> listFans = careUserService.findFans(userId);
        // 保存到session中
        request.setAttribute("listUserResponse",userResponselist);
        request.setAttribute("listUserQuestion",listUserQuestion);
        request.setAttribute("listUserArticle",userArticlelist);
        request.setAttribute("listUserCollection",collections);
        request.setAttribute("listIdol",listIdol);
        request.setAttribute("listFans",listFans);
        request.getRequestDispatcher("userInfo.jsp").forward(request,response);
    }
    ///得到用户的信息 转换成文本
    public List<UserResponse> getUserResponse(HttpServletRequest request, HttpServletResponse response,List<UserResponse> list) throws IOException {
        String path = request.getServletContext().getRealPath("/");
        String[] realPath = path.split("out");
        for(UserResponse ur : list){
            String txtPath = ur.getReplayContent();
            File file = new File(realPath[0]+"web/"+txtPath);
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len =0;
            String str=null;
            while ((len =inputStream.read(bytes)) !=-1){
                str = new String((bytes),"GBK");
            }
            ur.setReplayContent(str);
        }
        return list;
    }
    //删除用户的文章
    public void deleteAriticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesison = request.getSession();
        int articleId = Integer.valueOf(request.getParameter("articleId"));
        int userId = (int)sesison.getAttribute("userId");
        service.deleteArticle(articleId,userId);
        request.getRequestDispatcher("/userDynamicsServlet?method=init").forward(request,response);

    }
    //将用户的回答删除
    public void deleteResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesison = request.getSession();
        int problemId = Integer.valueOf(request.getParameter("problemId"));
        int userId = (int)sesison.getAttribute("userId");
        service.deleteResponse(problemId,userId);
        request.getRequestDispatcher("/userDynamicsServlet?method=init").forward(request,response);
    }
    //删除用户的提问
    public void deleteQusetion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesison = request.getSession();
        int problemId = Integer.valueOf(request.getParameter("problemId"));
        int userId = (int)sesison.getAttribute("userId");
        service.deleteQuestion(problemId,userId);
        request.getRequestDispatcher("/userDynamicsServlet?method=init").forward(request,response);

    }
    //将用户收藏中的文本取出
    public List<UserInfoCollection> getrenewCollection(HttpServletRequest request, HttpServletResponse response,List<UserInfoCollection> collections) throws IOException {
        String path = request.getServletContext().getRealPath("/");
        String[] realPath = path.split("out");
        for(UserInfoCollection ur : collections){
            String txtPath = ur.getReplayContent();
            File file = new File(realPath[0]+"web/"+txtPath);
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len =0;
            String str=null;
            while ((len =inputStream.read(bytes)) !=-1){
                str = new String((bytes),"GBK");
            }
            ur.setReplayContent(str);
        }
        return collections;
    }
    //删除用户要删除的收藏
    public void deleteCollection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int problemId = Integer.valueOf(request.getParameter("problemId"));
        int replayUserId = Integer.valueOf(request.getParameter("replayUserId"));
        int userId = (int)request.getSession().getAttribute("userId");
        collectionService.deleteCollection(problemId,userId,replayUserId);
        request.getRequestDispatcher("userDynamicsServlet?method=init").forward(request,response);

    }
    //取消关注
    public void cancleSight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int careUserId = Integer.parseInt(request.getParameter("Interviewed"));//关注人的id
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");//当前用户的id
        CareUser careUser = new CareUser(careUserId,userId);
        careUserService.cancleSight(careUser);
        request.getRequestDispatcher("/userDynamicsServlet?method=init").forward(request,response);
    }

    //关注粉丝
    public void sightUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");//当前用户的id
        int fansId = Integer.valueOf(request.getParameter("fans"));//粉丝的id
        User careUser = userService.getUserById(userId);//用户的详细信息
        User fansUser = userService.getUserById(fansId);//粉丝的id
        careUserService.sightUser(fansUser,careUser);//插入对象
        request.getRequestDispatcher("/userDynamicsServlet?method=init").forward(request,response);

    }
    //用户关注观看者
    public void careLookUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int fansId = (int)session.getAttribute("userId");//当前用户的id
        int careUserId = (int)(session.getAttribute("lookUserId"));//粉丝的id
        User careUser = userService.getUserById(careUserId);//用户的详细信息
        User fansUser = userService.getUserById(fansId);//粉丝的id
        careUserService.sightUser(careUser,fansUser);//插入对象
        request.getRequestDispatcher("/userDynamicsServlet?method=init").forward(request,response);

    }

    //查看别人信息
    public void lookUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int lookUserId = Integer.valueOf(request.getParameter("lookUserId"));//获取要查看用户的id
        HttpSession session = request.getSession();
        session.setAttribute("lookUserId",lookUserId);
        // 根据要访问的人id查出用户,保存在request中
        User user = userService.getUserById(lookUserId);
        request.setAttribute("userInfo",user);
        // 查用户回答
        List<UserResponse> listUserResponse = service.queryUserResponse(lookUserId);
        // 获取用户回答内容
        List<UserResponse> userResponselist = getUserResponse(request,response,listUserResponse);
        // 查用户提问
        List<UserQuestion> listUserQuestion = service.queryUserQuestion(lookUserId);
        // 查用户文章
        List<UserArticle> listUserArticle = service.queryUserArticle(lookUserId);
        // 获取文章内容
        List<UserArticle> userArticlelist = getUserArticle(request,response,listUserArticle);
        // 查询用户关注的人
        List<CareUser> listIdol = careUserService.findIdol(lookUserId);
        // 查询用户关注的人
        List<CareUser> listFans = careUserService.findFans(lookUserId);
        // 保存到session中
        request.setAttribute("listUserResponse",userResponselist);
        request.setAttribute("listUserQuestion",listUserQuestion);
        request.setAttribute("listUserArticle",userArticlelist);
        request.setAttribute("listIdol",listIdol);
        request.setAttribute("listFans",listFans);
        request.getRequestDispatcher("lookUserInfo.jsp").forward(request,response);
    }


    public List<UserArticle> getUserArticle(HttpServletRequest request, HttpServletResponse response,List<UserArticle> list) throws IOException {
        String path = request.getServletContext().getRealPath("/");
        String[] realPath = path.split("out");
        for(UserArticle ua : list){
            String txtPath = ua.getArticleContent();
            File file = new File(realPath[0]+"web/"+txtPath);
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len =0;
            String str=null;
            while ((len =inputStream.read(bytes)) !=-1){
                str = new String((bytes),"utf-8");
            }
            ua.setArticleContent(str);
        }
        return list;
    }
}
