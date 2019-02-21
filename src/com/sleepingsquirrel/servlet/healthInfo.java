package com.sleepingsquirrel.servlet;

import com.sleepingsquirrel.instance.Health;
import com.sleepingsquirrel.service.HealthHistory;
import com.sleepingsquirrel.service.impl.HealthHistoryImpl;
import net.sf.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        org.json.JSONArray healthlist = new org.json.JSONArray();

        for (Health a:healthList){
            JSONObject ob = new JSONObject();
            try {
                ob.put("userid",a.getUserid());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                ob.put("numoftep",a.getNumofstep());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                ob.put("calorie",a.getCalorie());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                ob.put("date",a.getDate());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            healthlist.put(ob);
        }
        System.out.println("我在servlet"+healthlist.toString());

        PW.print(healthlist);
        PW.flush();
        PW.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
