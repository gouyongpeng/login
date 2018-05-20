package com.itheima.web;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Admin;

import com.itheima.service.AdminService;



public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//HttpSession session = request.getSession();
		//获取数据
				String username = request.getParameter("username");//中文 张三
			
				String password = request.getParameter("password");
				HttpSession session = request.getSession();
				AdminService service = new AdminService();
			
				Admin admin = null;
				try {
					admin = service.alogin(username,password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				if(admin!=null){
					//登录成功
					System.out.println(username);
					System.out.println("123");
					//将登录的用户的user对象存到session中
					session.setAttribute("admin", admin);
					//重定向到首页
					response.sendRedirect("adminHoutai.jsp");
					
				}else{
					//失败 转发到登录页面 提出提示信息
					request.setAttribute("loginInfo", "用户名或密码错误");
					request.getRequestDispatcher("admin.jsp").forward(request, response);
				}
				
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}