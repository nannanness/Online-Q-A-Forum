package org.lanqiao.oqaf.controller.servlet;

import com.alibaba.fastjson.JSONObject;
import org.lanqiao.oqaf.domain.Remark;
import org.lanqiao.oqaf.service.IRemarkService;
import org.lanqiao.oqaf.service.impl.RemarkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/RemarkServlet")
public class RemarkServlet extends HttpServlet {
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("textRemark");
        IRemarkService service = new RemarkServiceImpl();
        Date date = new Date();
        String sql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        int proId = Integer.parseInt(request.getParameter("proId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int remId= Integer.parseInt(request.getParameter("remId"));

        Remark remark = new Remark(proId,userId,remId,text,sql);
        service.insertRemark(remark);
        String jsonRemark = JSONObject.toJSONString(remark);
    }
}
