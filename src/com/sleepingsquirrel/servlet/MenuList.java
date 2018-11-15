package com.sleepingsquirrel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sleepingsquirrel.instance.Food;
import com.sleepingsquirrel.service.MenuDispalyService;
import com.sleepingsquirrel.service.impl.MenuDisplayServiceImpl;

/**
 * Servlet implementation class MenuList
 */
@WebServlet("/MenuList")
public class MenuList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String foodname = request.getParameter("searchfoodname");
		System.out.println("从前端获得的"+foodname);
		MenuDispalyService MDS = new MenuDisplayServiceImpl();
		List<Food> Foodlist;
		Foodlist = MDS.Search(foodname);
		JSONArray foodlist = new JSONArray();
		if(Foodlist.isEmpty()) {

		}
		else{
			System.out.println("菜名"+Foodlist.get(0).getName());
            for(Food a : Foodlist){
                JSONObject jo = new JSONObject();
                try {
					jo.put("id", a.getId());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					jo.put("name", a.getName());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					jo.put("calorie", a.getCalorie());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                foodlist.put(jo);
            }
		}

		out.print(foodlist);
		out.flush();
		out.close();
		System.out.println("测试返回"+foodlist.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
