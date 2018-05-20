package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.Admin;

import com.itheima.utils.DataSourceUtils;

public class AdminDao {

	public Admin alogin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from admin where username=? and password=?";
	return runner.query(sql, new BeanHandler<Admin>(Admin.class), username,password);
	
}
}
