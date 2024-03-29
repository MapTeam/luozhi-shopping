package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lz.dao.LoginDao;
import com.lz.pojo.User;

public class LoginDaoImpl implements LoginDao {
	private static final Logger log = Logger.getLogger(LoginDaoImpl.class);
	/**
	 * 验证登录
	 * @param conn
	 * @param uname
	 * @param upwd
	 * @return
	 */
	@Override
	public User login(Connection conn, String uname, String upwd) {
		User u = null;
		String sql = "select * from user where uname=? and upwd=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
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
			log.error(e);
		}finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
			}
		}
		return u;
	}

}
