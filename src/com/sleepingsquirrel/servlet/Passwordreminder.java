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

import org.json.JSONException;

import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.service.PasswordreminderService;
import com.sleepingsquirrel.service.impl.PasswordremindeServiceImpl;
import com.sleepingsquirrel.service.impl.RegisterServiceImpl;

/**
 * Servlet implementation class Passwordreminder
 */
@WebServlet("/Passwordreminder")
public class Passwordreminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Passwordreminder() {
        super();
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

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		/*
		String userphone = request.getParameter("userphone");
		String useremail = request.getParameter("useremail");
		String userpwd = request.getParameter("userpwd");
		*/

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

		PasswordreminderService service = new PasswordremindeServiceImpl();
		String tag = service.editPassword(newUser);

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
