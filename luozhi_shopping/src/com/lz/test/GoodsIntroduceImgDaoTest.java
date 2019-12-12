package com.lz.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.GoodsIntroduceImg;
import com.lz.pojo.Type;

public class GoodsIntroduceImgDaoTest {
	BaseDao dao=new BaseDaoImpl();
	@Test
	public void insert(){
		GoodsIntroduceImg gii=new GoodsIntroduceImg();
		gii.setGid(123564);
		gii.setIntroduceImgs("1324");
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.insertObject(conn, gii));
		DBConnection1.close(conn);
	}
	@Test
	public void delete(){
		GoodsIntroduceImg gii=new GoodsIntroduceImg();
		gii.setGiid(2935);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.deleteObjectById(conn, gii));
		DBConnection1.close(conn);
	}
	@Test
	public void update(){
		GoodsIntroduceImg gii=new GoodsIntroduceImg();
		gii.setGiid(2934);
		gii.setGid(123564);
		gii.setIntroduceImgs("9999");
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.updateObjectById(conn, gii));
		DBConnection1.close(conn);
	}
	@Test
	public void selectAll(){		
		Connection conn=DBConnection1.getConnection();
		List<Object> list=dao.selectAllObject(conn,GoodsIntroduceImg.class);
		DBConnection1.close(conn);
		for (Object object : list) {
			System.out.println(object.toString());
		}
	}
	@Test
	public void selectById(){
		GoodsIntroduceImg gii=new GoodsIntroduceImg();
		gii.setGiid(2920);
		Connection conn=DBConnection1.getConnection();
		System.out.println(dao.selectObjectById(conn, gii));
		DBConnection1.close(conn);
	}
}
