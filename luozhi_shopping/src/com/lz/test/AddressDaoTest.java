package com.lz.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Address;
import com.lz.pojo.Type;

public class AddressDaoTest {
	BaseDao dao=new BaseDaoImpl();
	@Test
	public void insert(){
		Address a=new Address();
		a.setCity("cc");
		a.setDetail("132");
		a.setIsdefault(1);
		a.setName("456");
		a.setProvince("hh");
		a.setTel("456789");
		a.setUid(456);
		a.setVillage("yg");
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.insertObject(conn, a));
		DBConnection1.close(conn);
	}
	@Test
	public void delete(){
		Address a=new Address();
		a.setAddressid(25);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.deleteObjectById(conn, a));
		DBConnection1.close(conn);
	}
	@Test
	public void update(){
		Address a=new Address();
		a.setAddressid(26);
		a.setCity("aaa");
		a.setDetail("132");
		a.setIsdefault(1);
		a.setName("aaaa");
		a.setProvince("aaa");
		a.setTel("aaaaa");
		a.setUid(456);
		a.setVillage("a");
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.updateObjectById(conn, a));
		DBConnection1.close(conn);
	}
	@Test
	public void selectAll(){		
		Connection conn=DBConnection1.getConnection();
		List<Object> list=dao.selectAllObject(conn,Address.class);
		DBConnection1.close(conn);
		for (Object object : list) {
			System.out.println(object.toString());
		}
	}
	@Test
	public void selectById(){
		Address a=new Address();
		a.setAddressid(5);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.selectObjectById(conn, a));
		DBConnection1.close(conn);
	}
}
