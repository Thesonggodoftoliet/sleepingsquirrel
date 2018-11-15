package com.sleepingsquirrel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.service.LoginService;
import com.sleepingsquirrel.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String userphone = request.getParameter("userphone");
		String userpwd = request.getParameter("userpwd");
		LoginService ls =new LoginServiceImpl();
		User tuser = new User();
		tuser.setUserphone(userphone);
		tuser.setUserpwd(userpwd);
		String tag =  ls.loginCheck(tuser);
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
