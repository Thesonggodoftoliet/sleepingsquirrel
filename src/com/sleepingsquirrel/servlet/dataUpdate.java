package com.sleepingsquirrel.servlet;

import com.sleepingsquirrel.instance.Health;
import com.sleepingsquirrel.service.HealthUpdateService;
import com.sleepingsquirrel.service.impl.HealthUpdateServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/dataUpdate")
public class dataUpdate extends HttpServlet {

    public dataUpdate() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String streamIn = new BufferedReader(new InputStreamReader(request.getInputStream())).readLine();
        //String health = request.getParameter("health");
        net.sf.json.JSONObject temp = new net.sf.json.JSONObject().fromObject(streamIn);

        System.out.println("获取到的数据"+temp.toString());

        Health data = new Health();
        data.setUserid(temp.getInt("userid"));
        data.setCalorie(temp.getInt("calorie"));
        data.setNumofstep(temp.getInt("numofstep"));
        data.setDate(temp.getString("date"));

        HealthUpdateService HUS = new HealthUpdateServiceImpl();

        out.print(HUS.updateInfo(data));
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}