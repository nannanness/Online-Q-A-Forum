package org.lanqiao.oqaf.controller.servlet;

import com.alibaba.fastjson.JSONObject;
import org.lanqiao.oqaf.domain.Remark;
import org.lanqiao.oqaf.domain.Remarks;
import org.lanqiao.oqaf.service.IRemarkGetService;
import org.lanqiao.oqaf.service.impl.RemarkGetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/remarksServlet")
public class RemarksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IRemarkGetService iRemarkGetService=new RemarkGetServiceImpl();
        int proId = Integer.parseInt(request.getParameter("proId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Remarks> remarks = iRemarkGetService.getRemarks(proId,userId);
        String jsonRemarks = JSONObject.toJSONString(remarks);
        System.out.println(jsonRemarks.toString());
        PrintWriter out = response.getWriter();
        out.write(jsonRemarks);
    }
}
