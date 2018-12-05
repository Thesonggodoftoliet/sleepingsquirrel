package com.sleepingsquirrel.servlet;

import com.sleepingsquirrel.instance.Health;
import com.sleepingsquirrel.service.HealthHistory;
import com.sleepingsquirrel.service.impl.HealthHistoryImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/healthInfo")
public class healthInfo extends HttpServlet {

    public healthInfo() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter PW = response.getWriter();
        String userid = request.getParameter("userid");
        HealthHistory HH = new HealthHistoryImpl();
        Health temp = new Health();
        temp.setUserid(Integer.parseInt(userid));
        List<Health> healthList = HH.getHistory(temp);

        net.sf.json.JSONArray healthlist = net.sf.json.JSONArray.fromObject(healthList);

        PW.print(healthlist);
        PW.flush();
        PW.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
