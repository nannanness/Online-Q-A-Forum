package org.lanqiao.oqaf.controller.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.lanqiao.oqaf.domain.User;
import org.lanqiao.oqaf.service.IUserService;
import org.lanqiao.oqaf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/avatarUpLoadServlet")
public class AvatarUpLoadServlet extends HttpServlet {
    IUserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        upLoadAvatar(request, response);

    }

    public void upLoadAvatar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "";
        String pathDie = "imgs/userImg/";
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);//判断是否是表单文件类型
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        List items = null;
        try {
            items = sfu.parseRequest(request);//从request得到所有上传域的列表
        } catch (Exception e) {
        }
        for (Iterator iter = items.iterator(); iter.hasNext(); ) {
            FileItem fileitem = (FileItem) iter.next();
            if (!fileitem.isFormField() && fileitem != null) {//判读不是普通表单域即是file
//                System.out.println(fileitem);
                path = pathDie + fileitem.getName();
                String realPath = request.getServletContext().getRealPath("/");
                String[] s = realPath.split("out");
                File fileUploadHere = new File(s[0] + "web/" + path);
                File fileWarPath = new File(realPath + path);
                FileUtils.copyInputStreamToFile(fileitem.getInputStream(),fileWarPath);
                FileUtils.copyInputStreamToFile(fileitem.getInputStream(),fileUploadHere);
//                System.out.println(path);
            }
        }
        int userId = (int) request.getSession().getAttribute("userId");
        service.updateUserAvatar(userId,path);
        User userInfo = service.getUserById(userId);
        request.getSession().setAttribute("userInfo" , userInfo);
        System.out.println(userInfo.getUser_Img());


    }
}
