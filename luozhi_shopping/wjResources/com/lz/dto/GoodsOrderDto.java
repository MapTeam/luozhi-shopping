package com.lz.dto;

import java.io.Serializable;
import java.util.Date;

public class GoodsOrderDto implements Serializable{
	private int goid;//订单编号
	private String goname;//订单号
	private int gcolorid;//颜色编号
	private int uid;//用户编号
	private int outgoodid;//出货单号
	private int goodsnum;//购买数量
	private int addressid;//地址编号
	private int gostate;//状态码
	private String uname;//用户昵称
	private String email;//用户邮箱
	private int credits;//用户积分
	private String gname;//商品名称
	private String gintroduce;//商品详情
	private String name;//收货人
	private String tel;//电话号码
	private String province;//省
	private String city;//市
	private String village;//区
	private String detail;//详细地址
	private int gid;//商品编号
	private String goodspicture;//商品颜色图片
	private String colortype;//颜色
	private int goodscount;//库存
	private Date godate;
	public Date getGodate() {
		return godate;
	}
	public void setGodate(Date godate) {
		this.godate = godate;
	}
	public int getGoid() {
		return goid;
	}
	public void setGoid(int goid) {
		this.goid = goid;
	}
	public String getGoname() {
		return goname;
	}
	public void setGoname(String goname) {
		this.goname = goname;
	}
	public int getGcolorid() {
		return gcolorid;
	}
	public void setGcolorid(int gcolorid) {
		this.gcolorid = gcolorid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getOutgoodid() {
		return outgoodid;
	}
	public void setOutgoodid(int outgoodid) {
		this.outgoodid = outgoodid;
	}
	public int getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
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
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGintroduce() {
		return gintroduce;
	}
	public void setGintroduce(String gintroduce) {
		this.gintroduce = gintroduce;
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
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGoodspicture() {
		return goodspicture;
	}
	public void setGoodspicture(String goodspicture) {
		this.goodspicture = goodspicture;
	}
	public String getColortype() {
		return colortype;
	}
	public void setColortype(String colortype) {
		this.colortype = colortype;
	}
	public int getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	@Override
	public String toString() {
		return "GoodsOrderDto [goid=" + goid + ", goname=" + goname + ", gcolorid=" + gcolorid + ", uid=" + uid
				+ ", outgoodid=" + outgoodid + ", goodsnum=" + goodsnum + ", addressid=" + addressid + ", gostate="
				+ gostate + ", uname=" + uname + ", email=" + email + ", credits=" + credits + ", gname=" + gname
				+ ", gintroduce=" + gintroduce + ", name=" + name + ", tel=" + tel + ", province=" + province
				+ ", city=" + city + ", village=" + village + ", detail=" + detail + ", gid=" + gid + ", goodspicture="
				+ goodspicture + ", colortype=" + colortype + ", goodscount=" + goodscount + "]";
	}
	

	
	
	

}
