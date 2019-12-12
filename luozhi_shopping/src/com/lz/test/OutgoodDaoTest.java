package com.lz.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Outgood;

public class OutgoodDaoTest {
	BaseDao dao=new BaseDaoImpl();
	@Test
	public void insert(){
		Outgood o=new Outgood();
		o.setLogistics("123457");
		o.setOutgoodname("娜娜啊");
		o.setReceiveAddress("湖南");
		o.setTel("13456789");
		o.setUid(456);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.insertObject(conn, o));
		DBConnection1.close(conn);
	}
	@Test
	public void delete(){
		Outgood o=new Outgood();
		o.setOutgoodid(9);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.deleteObjectById(conn, o));
		DBConnection1.close(conn);
	}
	@Test
	public void update(){
		Outgood o=new Outgood();
		o.setLogistics("123456");
		o.setOutgoodid(11);
		o.setOutgoodname("哈哈");
		o.setReceiveAddress("湖南");
		o.setTel("13456789");
		o.setUid(456);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.updateObjectById(conn, o));
		DBConnection1.close(conn);
	}
	@Test
	public void selectAll(){		
		Connection conn=DBConnection1.getConnection();
		List<Object> list=dao.selectAllObject(conn,Outgood.class);
		DBConnection1.close(conn);
		for (Object object : list) {
			System.out.println(object.toString());
		}
	}
	@Test
	public void selectById(){
		Outgood o=new Outgood();
		o.setOutgoodid(11);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.selectObjectById(conn, o));
		DBConnection1.close(conn);
	}
}
