package com.lz.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.BaseDao;
import com.lz.pojo.User;

public class BaseDaoImpl implements BaseDao {

	@Override
	public boolean insertObject(Connection conn, Object obj) {
		boolean flag = false;
		Class c = obj.getClass();
		List<Method> methods = new ArrayList<Method>();
		StringBuffer sb = new StringBuffer();
		String sql = "INSERT INTO ";
		sb.append(sql);
		sb.append("`"+c.getSimpleName().toLowerCase()+"`(");
		Field[] f = c.getDeclaredFields();
		for (int i = 0;i<f.length;i++) {
			if(i>1){
				String field = f[i].getName();
				String m = "get"+field.substring(0, 1).toUpperCase()+field.substring(1);
				try {
					methods.add(c.getMethod(m, null));
				} catch (Exception e) {
					e.printStackTrace();
				}
				sb.append(f[i].getName());
				if(i<f.length-1){
					sb.append(",");
				}
			}
		}
		sb.append(") VALUES(");
		for (int i = 0;i<f.length;i++) {
			if(i>1){
				sb.append("?");
				if(i<f.length-1){
					sb.append(",");
				}
			}
		}
		sb.append(")");
		sql = sb.toString();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < f.length-2; i++) {
				try {
					ps.setObject(i+1, methods.get(i).invoke(obj, null));
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			int fl = ps.executeUpdate();
			if(fl>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null&&!ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean deleteObjectById(Connection conn, Object obj) {
		boolean flag = false;
		Class c = obj.getClass();
		Method m = null;
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM `");
		sb.append(c.getSimpleName().toLowerCase()+"` WHERE ");
		Field[] f = c.getDeclaredFields();
		
		String field = f[1].getName();
		String mt = "get"+field.substring(0, 1).toUpperCase()+field.substring(1);
		try {
			m = c.getMethod(mt, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sb.append(field+"=?");
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sb.toString());
			try {
				ps.setObject(1, m.invoke(obj, null));
			} catch (Exception e) {
				e.printStackTrace();
			}
			int fl = ps.executeUpdate();
			if(fl>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null&&!ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean updateObjectById(Connection conn, Object obj) {
		boolean flag = false;
		Class c = obj.getClass();
		List<Method> methods = new ArrayList<Method>();
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE `");
		sb.append(c.getSimpleName().toLowerCase()+"` SET ");
		
		Field[] f = c.getDeclaredFields();
		for (int i = 0;i<f.length;i++) {
			if(i>1){
				String field = f[i].getName();
				String m = "get"+field.substring(0, 1).toUpperCase()+field.substring(1);
				try {
					methods.add(c.getMethod(m, null));
				} catch (Exception e) {
					e.printStackTrace();
				}
				sb.append(f[i].getName()+"=?");
				if(i<f.length-1){
					sb.append(",");
				}
			}
		}
		String fieldid = f[1].getName();
		sb.append(" WHERE "+fieldid+"=?");
		String m = "get"+fieldid.substring(0, 1).toUpperCase()+fieldid.substring(1);
		try {
			methods.add(c.getMethod(m, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sb.toString());
			for (int i = 0; i < f.length-1; i++) {
				try {
					ps.setObject(i+1, methods.get(i).invoke(obj, null));
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			int fl = ps.executeUpdate();
			if(fl>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null&&!ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public List<Object> selectAllObject(Connection conn,Class c) {
		List<Object> objs = new ArrayList<Object>();
		//存所有set方法
		List<Method> setmethods = new ArrayList<Method>();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM `");
		sb.append(c.getSimpleName().toLowerCase()+"`");
		//获取所有属性
		Field[] f = c.getDeclaredFields();
		//获取set方法
		for (int i = 0;i<f.length;i++) {
			if(i>0){
				String field = f[i].getName();
				String m1 = "set"+field.substring(0, 1).toUpperCase()+field.substring(1);
				try {
					setmethods.add(c.getMethod(m1, f[i].getType()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sb.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				try {
					Object obj = c.newInstance();
					for (int i = 0; i < setmethods.size(); i++) {
						setmethods.get(i).invoke(obj, rs.getObject(i+1));
					}
					objs.add(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null&&!ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objs;
	}

	@Override
	public Object selectObjectById(Connection conn, Object obj) {
		Class c = obj.getClass();
		Object retureObj = null;
		List<Method> setmethods = new ArrayList<Method>();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM `");
		sb.append(c.getSimpleName().toLowerCase()+"` WHERE ");
		
		Field[] f = c.getDeclaredFields();
		sb.append(f[1].getName()+"=?");
		
		String fieldid = f[1].getName();
		//获取id
		Method getid = null;
		String m = "get"+fieldid.substring(0, 1).toUpperCase()+fieldid.substring(1);
		try {
			getid = c.getMethod(m, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//获取set方法
		for (int i = 0;i<f.length;i++) {
			if(i>0){
				String field = f[i].getName();
				String m1 = "set"+field.substring(0, 1).toUpperCase()+field.substring(1);
				try {
					setmethods.add(c.getMethod(m1, f[i].getType()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sb.toString());
			try {
				ps.setObject(1, getid.invoke(obj, null));
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				try {
					retureObj = c.newInstance();
					for (int i = 0; i < setmethods.size(); i++) {
						setmethods.get(i).invoke(retureObj, rs.getObject(i+1));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null&&!ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retureObj;
	}

}
