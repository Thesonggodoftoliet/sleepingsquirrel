package com.sleepingsquirrel.servlet;

import com.sleepingsquirrel.instance.Health;
import com.sleepingsquirrel.service.HealthUpdateService;
import com.sleepingsquirrel.service.impl.HealthUpdateServiceImpl;
import org.json.JSONException;

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
       // String streamIn = new BufferedReader(new InputStreamReader(request.getInputStream())).readLine();
        //String health = request.getParameter("health");
       // net.sf.json.JSONObject temp = new net.sf.json.JSONObject().getJSONObject(streamIn);
        InputStream js = request.getInputStream();
        InputStreamReader jsr = new InputStreamReader(js);
        BufferedReader br = new BufferedReader(jsr);

        String userjson = br.readLine();
        org.json.JSONArray userJsonArr = null;
        try {
            userJsonArr = new org.json.JSONArray(userjson);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        org.json.JSONObject userObj = null;
        try {
            userObj = userJsonArr.getJSONObject(0);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("获取到的数据"+userObj.toString());

        Health data = new Health();
        try {
            data.setUserid(userObj.getInt("userid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            data.setCalorie(userObj.getInt("calorie"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            data.setNumofstep(userObj.getInt("numofstep"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            data.setDate(userObj.getString("date"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HealthUpdateService HUS = new HealthUpdateServiceImpl();
        String tag = HUS.updateInfo(data);
        out.print(tag);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}