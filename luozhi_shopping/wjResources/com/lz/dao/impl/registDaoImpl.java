package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lz.dao.registDao;
import com.lz.db.DBConnection1;
import com.lz.pojo.User;

public class registDaoImpl implements registDao{

	@Override
	public boolean registSelectByName(String sname) {
		Connection conn=DBConnection1.getConnection();
		String sql="select * from user where uname=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, sname);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}



	@Override
	public User registSelectByEmail(String email) {
		Connection conn=DBConnection1.getConnection();
		User u = null;
		String sql="select * from user where email=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setCredits(rs.getInt("credits"));
				u.setEmail(rs.getString("email"));
				u.setRegistdate(rs.getDate("registdate"));
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpicture(rs.getString("upicture"));
				u.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return u;
	}
}
