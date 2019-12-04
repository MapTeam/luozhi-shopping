package com.lz.dto;

public class GoodsOrdergoodDto {
	private String gname;//商品名称
	private String goodspicture;//商品颜色图片
	private String colortype;//颜色
	private int goodsnum;//购买数量
	private int gcolorid;//颜色编号
	private int gid;//商品编号
	private String gbrand;//商品品牌
	private String gintroduce;//商品详情
	private int goodscount;//库存
	private float gprice;
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
	public String getColortype() {
		return colortype;
	}
	public void setColortype(String colortype) {
		this.colortype = colortype;
	}
	public int getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}
	public int getGcolorid() {
		return gcolorid;
	}
	public void setGcolorid(int gcolorid) {
		this.gcolorid = gcolorid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGbrand() {
		return gbrand;
	}
	public void setGbrand(String gbrand) {
		this.gbrand = gbrand;
	}
	public String getGintroduce() {
		return gintroduce;
	}
	public void setGintroduce(String gintroduce) {
		this.gintroduce = gintroduce;
	}
	public int getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	
	public float getGprice() {
		return gprice;
	}
	public void setGprice(float gprice) {
		this.gprice = gprice;
	}
	@Override
	public String toString() {
		return "GoodsOrdergoodDto [gname=" + gname + ", goodspicture=" + goodspicture + ", colortype=" + colortype
				+ ", goodsnum=" + goodsnum + ", gcolorid=" + gcolorid + ", gid=" + gid + ", gbrand=" + gbrand
				+ ", gintroduce=" + gintroduce + ", goodscount=" + goodscount + "]";
	}
	
}
