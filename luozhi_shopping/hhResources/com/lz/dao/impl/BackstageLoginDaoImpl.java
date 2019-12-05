package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.BackstageLoginDao;
import com.lz.pojo.Admincount;

public class BackstageLoginDaoImpl implements BackstageLoginDao{

	@Override
	public Admincount selectPasswordByuserame(Connection conn, String username) {
		Admincount admin=null;
		String sql="select * from admincount where acount=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				admin=new Admincount();
				admin.setAcount(rs.getString("acount"));
				admin.setAid(rs.getInt("aid"));
				admin.setApwd(rs.getString("apwd"));
				admin.setCuml(rs.getInt("cuml"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return admin;
	}

}
