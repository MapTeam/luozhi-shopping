package com.lz.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsOrderDto implements Serializable{
	private static final long serialVersionUID = 3105621744783710432L;
	private int goid;//订单编号
	private int addressid;//地址编号
	private int gostate;//状态码
	private String uname;//用户昵称
	private int outgoodid;//出货单号
	private int uid;//用户编号
	private String goname;//订单号
	private String email;//用户邮箱
	private int credits;//用户积分
	private String name;//收货人
	private String tel;//电话号码
	private String province;//省
	private String city;//市
	private String village;//区
	private String detail;//详细地址
	private String godate;//订单提交时间
	private String reason;//原因
	private String refusereason;//拒绝原因
	private String receiveaddress;//最后地址
	List<GoodsOrdergoodDto>  gogoods = new ArrayList<GoodsOrdergoodDto>();
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRefusereason() {
		return refusereason;
	}
	public void setRefusereason(String refusereason) {
		this.refusereason = refusereason;
	}
	public int getGoid() {
		return goid;
	}
	public void setGoid(int goid) {
		this.goid = goid;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public int getGostate() {
		return gostate;
	}
	public void setGostate(int gostate) {
		this.gostate = gostate;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getOutgoodid() {
		return outgoodid;
	}
	public void setOutgoodid(int outgoodid) {
		this.outgoodid = outgoodid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getGoname() {
		return goname;
	}
	public void setGoname(String goname) {
		this.goname = goname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getGodate() {
		return godate;
	}
	public void setGodate(String godate) {
		this.godate = godate;
	}
	public List<GoodsOrdergoodDto> getGogoods() {
		return gogoods;
	}
	public void setGogoods(List<GoodsOrdergoodDto> gogoods) {
		this.gogoods = gogoods;
	}
	
	public String getReceiveaddress() {
		return receiveaddress;
	}
	public void setReceiveaddress(String receiveaddress) {
		this.receiveaddress = receiveaddress;
	}
	@Override
	public String toString() {
		return "GoodsOrderDto [goid=" + goid + ", addressid=" + addressid + ", gostate=" + gostate + ", uname=" + uname
				+ ", outgoodid=" + outgoodid + ", uid=" + uid + ", goname=" + goname + ", email=" + email + ", credits="
				+ credits + ", name=" + name + ", tel=" + tel + ", province=" + province + ", city=" + city
				+ ", village=" + village + ", detail=" + detail + ", godate=" + godate + ", reason=" + reason
				+ ", refusereason=" + refusereason + ", gogoods=" + gogoods + "]";
	}
	
	
	

}
