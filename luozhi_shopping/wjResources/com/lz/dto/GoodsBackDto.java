package com.lz.dto;

import java.io.Serializable;

public class GoodsBackDto implements Serializable{
	private int goodsnum;//购买数量
	private String gname;//商品名称
	private String goodspicture;//商品颜色图片
	private String reason;//原因
	private String refusereason;//拒绝原因
	private int gid;//商品id
	private int goid;//订单编号
	public int getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGoodspicture() {
		return goodspicture;
	}
	public void setGoodspicture(String goodspicture) {
		this.goodspicture = goodspicture;
	}
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
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	public int getGoid() {
		return goid;
	}
	public void setGoid(int goid) {
		this.goid = goid;
	}
	@Override
	public String toString() {
		return "GoodsBackDto [goodsnum=" + goodsnum + ", gname=" + gname + ", goodspicture=" + goodspicture
				+ ", reason=" + reason + ", refusereason=" + refusereason + ", gid=" + gid + "]";
	}
	

}
