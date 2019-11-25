package com.lz.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBConnection1 {
	private static final Logger log = Logger.getLogger(DBConnection1.class);
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
	
	public static Connection getConnection(){
	    Connection conn = null;
		//得到连接
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e);
		}
		return conn;
	}
	
	public static ComboPooledDataSource getComboPooledDataSource(){
		return dataSource;
	}
	
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	public static void close(Connection conn){
		try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
