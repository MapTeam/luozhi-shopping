package com.lz.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Address;
import com.lz.pojo.Admincount;

public class AdmincountDaoTest {
	BaseDao dao=new BaseDaoImpl();
	@Test
	public void insert(){
		Admincount a=new Admincount();
		a.setAcount("admin001");
		a.setApwd("123456");
		a.setCuml(2);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.insertObject(conn, a));
		DBConnection1.close(conn);
	}
	@Test
	public void delete(){
		Admincount a=new Admincount();
		a.setAid(4);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.deleteObjectById(conn, a));
		DBConnection1.close(conn);
	}
	@Test
	public void update(){
		Admincount a=new Admincount();
		a.setAid(2);
		a.setAcount("admin0002");
		a.setApwd("123456");
		a.setCuml(2);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.updateObjectById(conn, a));
		DBConnection1.close(conn);
	}
	@Test
	public void selectAll(){		
		Connection conn=DBConnection1.getConnection();
		List<Object> list=dao.selectAllObject(conn,Admincount.class);
		DBConnection1.close(conn);
		for (Object object : list) {
			System.out.println(object.toString());
		}
	}
	@Test
	public void selectById(){
		Admincount a=new Admincount();
		a.setAid(1);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.selectObjectById(conn, a));
		DBConnection1.close(conn);
	}
}
