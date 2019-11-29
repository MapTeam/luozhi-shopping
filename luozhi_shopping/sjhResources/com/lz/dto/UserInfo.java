package com.lz.dto;

import java.io.Serializable;
import java.util.Date;

import com.lz.pojo.User;

public class UserInfo implements Serializable{
	private static final long serialVersionUID = 9060613495172250585L;
	
	private String uname;
	private int shopcargoodsnum;
	private User user;
	private String ip;
	private Date date;
	
	public int getShopcargoodsnum() {
		return shopcargoodsnum;
	}
	public void setShopcargoodsnum(int shopcargoodsnum) {
		this.shopcargoodsnum = shopcargoodsnum;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	} 
}
