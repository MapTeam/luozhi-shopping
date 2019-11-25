package com.lz.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Type;

public class TypeDaoTest {
	BaseDao dao=new BaseDaoImpl();
	@Test
	public void insert(){
		Type t=new Type();
		t.setCategory1(4);
		t.setCategory2(5);
		t.setTname("沈嘉豪");
		t.setTtid(8);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.insertObject(conn, t));
		DBConnection1.close(conn);
	}
	@Test
	public void delete(){
		Type t=new Type();
		t.setTid(9420606);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.deleteObjectById(conn, t));
		DBConnection1.close(conn);
	}
	@Test
	public void update(){
		Type t=new Type();
		t.setTid(9420605);
		t.setCategory1(4);
		t.setCategory2(5);
		t.setTname("沈嘉豪");
		t.setTtid(8);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.updateObjectById(conn, t));
		DBConnection1.close(conn);
	}
	@Test
	public void selectAll(){		
		Connection conn=DBConnection1.getConnection();
		List<Object> list=dao.selectAllObject(conn,Type.class);
		DBConnection1.close(conn);
		for (Object object : list) {
			System.out.println(object.toString());
		}
	}
	@Test
	public void selectById(){
		Type t=new Type();
		t.setTid(9420604);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.selectObjectById(conn, t));
		DBConnection1.close(conn);
	}
}
