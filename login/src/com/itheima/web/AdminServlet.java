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
		//��ȡ����
				String username = request.getParameter("username");//���� ����
			
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
					//��¼�ɹ�
					System.out.println(username);
					System.out.println("123");
					//����¼���û���user����浽session��
					session.setAttribute("admin", admin);
					//�ض�����ҳ
					response.sendRedirect("adminHoutai.jsp");
					
				}else{
					//ʧ�� ת������¼ҳ�� �����ʾ��Ϣ
					request.setAttribute("loginInfo", "�û������������");
					request.getRequestDispatcher("admin.jsp").forward(request, response);
				}
				
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}