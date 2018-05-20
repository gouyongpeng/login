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
		//��ȡ����
				String username = request.getParameter("username");//���� ����
				
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
					//��¼�ɹ�
					System.out.println(username);
					
					//����¼���û���user����浽session��
					session.setAttribute("user", user);
					//�ض�����ҳ
					response.sendRedirect("userHoutai.jsp");
					
				}else{
					//ʧ�� ת������¼ҳ�� �����ʾ��Ϣ
					request.setAttribute("loginInfo", "�û������������");
					request.getRequestDispatcher("user.jsp").forward(request, response);
				}
				
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}