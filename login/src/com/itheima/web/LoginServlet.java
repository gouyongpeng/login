package com.itheima.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;
import com.itheima.service.UserService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//HttpSession session = request.getSession();
		//获取数据
				String username = request.getParameter("username");//中文 张三
				
				String password = request.getParameter("password");
				HttpSession session = request.getSession();
				UserService service = new UserService();
				User user = null;
				try {
					user = service.login(username,password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				if(user!=null){
					//登录成功
					System.out.println(username);
					
					//将登录的用户的user对象存到session中
					session.setAttribute("user", user);
					//重定向到首页
					response.sendRedirect("userHoutai.jsp");
					
				}else{
					//失败 转发到登录页面 提出提示信息
					request.setAttribute("loginInfo", "用户名或密码错误");
					request.getRequestDispatcher("user.jsp").forward(request, response);
				}
				
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}