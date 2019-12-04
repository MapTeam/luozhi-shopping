package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lz.dao.AddressDao;

public class AddressDaoImpl implements AddressDao{

	@Override
	public boolean insertFirstDefault(Connection conn, int addressid) {
		String sql="UPDATE  address SET isdefault=1 WHERE addressid=?";
		PreparedStatement ps=null;		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, addressid);
			int rs =ps.executeUpdate();
			if (rs>0) {
				return true;
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
		return false;
	}

}
