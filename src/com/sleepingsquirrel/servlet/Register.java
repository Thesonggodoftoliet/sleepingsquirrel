package com.sleepingsquirrel.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.service.impl.RegisterServiceImpl;

import org.json.JSONException;

/**
 * Servlet implementation class Registe
 */
@WebServlet("/Registe")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		PrintWriter out =response.getWriter();

		User newUser = new User();
		try {
			newUser.setUserphone(userObj.getString("userphone"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newUser.setUseremail(null);
		try {
			newUser.setUserpwd(userObj.getString("userpwd"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RegisterServiceImpl regService = new RegisterServiceImpl();
		String tag = regService.addUser(newUser);

		out.write(tag);
		out.flush();
		out.close();
		System.out.println("测试返回"+tag);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
