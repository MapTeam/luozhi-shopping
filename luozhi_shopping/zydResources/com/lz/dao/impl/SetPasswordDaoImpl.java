package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.SetPasswordDao;
import com.lz.dto.GoodsCarDTO;
import com.lz.pojo.User;
import com.lz.util.Md5;

public class SetPasswordDaoImpl implements SetPasswordDao{

	@Override
	public boolean SetPassword(Connection conn,User user) {
            boolean flag=false;
           String password=(String)user.getUpwd();
		   String email=user.getEmail();
		    password=Md5.md5(password);
		    System.out.println(password);
           String sql = "update user set upwd=? where email=?;";
	     	PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			int  result = ps.executeUpdate();
			if(result>0){
			  flag=true;
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
		return flag;
	}

}
