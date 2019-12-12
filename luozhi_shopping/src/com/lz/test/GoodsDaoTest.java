package com.lz.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Goods;
import com.lz.pojo.Type;

public class GoodsDaoTest {
	BaseDao dao=new BaseDaoImpl();
	@Test
	public void insert(){
		Goods g=new Goods();
		g.setCategory1(123456);
		g.setCategory2(123456);
		g.setGbrand("456");
		g.setGcolorid(99);
		g.setGcount(500);
		g.setGgrade(10);
		g.setGintroduce("搜索");
		g.setGmaterial("");
		g.setGname("sdas");
		g.setGpicture("img");
		g.setGprice((float) 15.20);
		g.setHot(1);
		g.setZpicture("111");
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.insertObject(conn, g));
		DBConnection1.close(conn);
	}
	@Test
	public void delete(){
		Goods g=new Goods();
		g.setGid(21818669);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.deleteObjectById(conn, g));
		DBConnection1.close(conn);
	}
	@Test
	public void update(){
		Goods g=new Goods();
		g.setGid(21818668);
		g.setCategory1(123456);
		g.setCategory2(123456);
		g.setGbrand("456");
		g.setGcolorid(99);
		g.setGcount(100);
		g.setGgrade(10);
		g.setGintroduce("搜索");
		g.setGmaterial("");
		g.setGname("sdas");
		g.setGpicture("img");
		g.setGprice((float) 15.20);
		g.setHot(1);
		g.setZpicture("111");
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.updateObjectById(conn, g));
		DBConnection1.close(conn);
	}
	@Test
	public void selectAll(){		
		Connection conn=DBConnection1.getConnection();
		List<Object> list=dao.selectAllObject(conn,Goods.class);
		DBConnection1.close(conn);
		for (Object object : list) {
			System.out.println(object.toString());
		}
	}
	@Test
	public void selectById(){
		Goods g=new Goods();
		g.setGid(21813748);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.selectObjectById(conn, g));
		DBConnection1.close(conn);
	}
}
