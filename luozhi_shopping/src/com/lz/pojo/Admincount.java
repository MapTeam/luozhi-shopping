package com.lz.pojo;

import java.io.Serializable;

public class Admincount implements Serializable{
	
	private static final long serialVersionUID = -20026560038622205L;
	private Integer aid;
	private String acount;
	private String apwd;
	private Integer cuml;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAcount() {
		return acount;
	}
	public void setAcount(String acount) {
		this.acount = acount;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public Integer getCuml() {
		return cuml;
	}
	public void setCuml(Integer cuml) {
		this.cuml = cuml;
	}
	@Override
	public String toString() {
		return "Admincount [aid=" + aid + ", acount=" + acount + ", apwd=" + apwd + ", cuml=" + cuml + "]";
	}
	
}
