package com.lz.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.GoodsCar;
import com.lz.pojo.Type;

public class GoodsCarDaoTest {
	BaseDao dao=new BaseDaoImpl();
	@Test
	public void insert(){
		GoodsCar gc=new GoodsCar();
		gc.setUid(2);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.insertObject(conn, gc));
		DBConnection1.close(conn);
	}
	@Test
	public void delete(){
		GoodsCar gc=new GoodsCar();
		gc.setGcid(16);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.deleteObjectById(conn, gc));
		DBConnection1.close(conn);
	}
	@Test
	public void update(){
		GoodsCar gc=new GoodsCar();
		gc.setGcid(16);
		gc.setUid(5);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.updateObjectById(conn, gc));
		DBConnection1.close(conn);
	}
	@Test
	public void selectAll(){		
		Connection conn=DBConnection1.getConnection();
		List<Object> list=dao.selectAllObject(conn,GoodsCar.class);
		DBConnection1.close(conn);
		for (Object object : list) {
			System.out.println(object.toString());
		}
	}
	@Test
	public void selectById(){
		GoodsCar gc=new GoodsCar();
		gc.setGcid(16);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.selectObjectById(conn, gc));
		DBConnection1.close(conn);
	}
}
