package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lz.dao.AddressDao;
import com.lz.db.DBConnection1;

public class AddressDaoImpl implements AddressDao{
	private static final Logger log = Logger.getLogger(AddressDaoImpl.class);
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
		return false;
	}

}
