package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.AdminDao;

import com.itheima.domain.Admin;


public class AdminService {
	public Admin alogin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		AdminDao dao= new AdminDao();
		return dao.alogin(username,password);
		
	}
}
