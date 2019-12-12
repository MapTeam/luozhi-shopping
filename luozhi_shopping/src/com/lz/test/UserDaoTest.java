package com.lz.test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.User;

public class UserDaoTest {
	BaseDaoImpl dao = new BaseDaoImpl();
	
	@Test
	public void insert(){
		User u = new User();
		u.setUpicture("123");
		u.setUpwd("123");
		u.setUname("111");
		u.setRegistdate(new Date());
		u.setEmail("123.com");
		u.setCredits(0);
		Connection conn =  DBConnection1.getConnection();
		System.out.println(dao.insertObject(conn, u)); 
		DBConnection1.close(conn);
	}
	
	@Test
	public void delete(){
		User u = new User();
		u.setUid(22);
//		u.setUpicture("123");
//		u.setUpwd("123");
//		u.setUname("111");
//		u.setRegistdate(new Date());
//		u.setEmail("123.com");
//		u.setGcid(11);
		Connection conn =  DBConnection1.getConnection();
		System.out.println(dao.deleteObjectById(conn, u)); 
		DBConnection1.close(conn);
	}
	@Test
	public void update(){
		User u = new User();
		u.setUid(22);
		u.setUpicture("你好");
		u.setUpwd("789");
		u.setUname("胡辉");
		u.setRegistdate(new Date());
		u.setEmail("456789.com");
		Connection conn =  DBConnection1.getConnection();
		System.out.println(dao.updateObjectById(conn, u)); 
		DBConnection1.close(conn);
	}
	
	@Test
	public void selectAll(){
		User u = new User();
		Connection conn =  DBConnection1.getConnection();
		List<Object> objs = dao.selectAllObject(conn, u.getClass()); 
		DBConnection1.close(conn);
		for (Object object : objs) {
			System.out.println(object);
		}
	}
	
	
	@Test
	public void select(){
		User u = new User();
		u.setUid(5);
		Connection conn =  DBConnection1.getConnection();
		System.out.println(dao.selectObjectById(conn, u)); 
		DBConnection1.close(conn);
	}
}
