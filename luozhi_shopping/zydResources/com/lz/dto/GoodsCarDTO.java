package com.lz.dto;

import java.io.Serializable;

import com.lz.pojo.Goods;

public class GoodsCarDTO implements Serializable{
    @Override
	public String toString() {
		return "GoodsCarDTO [zpicture=" + zpicture + ", gpicture=" + gpicture + ", gname=" + gname + ", gintroduce="
				+ gintroduce + ", category2=" + category2 + ", gbrand=" + gbrand + ", gprice=" + gprice + ", colortype="
				+ colortype + "]";
	}
	/** 商品主图 */
    private String zpicture;

    /** 商品图片 */
    private String gpicture;

    /** 商品名字 */
    private String gname;

    /** 商品介绍 */
    private String gintroduce;
    /** 类别 */
    private Integer category2;
    public String getZpicture() {
		return zpicture;
	}
	public void setZpicture(String zpicture) {
		this.zpicture = zpicture;
	}
	public String getGpicture() {
		return gpicture;
	}
	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
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
	public Integer getCategory2() {
		return category2;
	}
	public void setCategory2(Integer category2) {
		this.category2 = category2;
	}
	public String getGbrand() {
		return gbrand;
	}
	public void setGbrand(String gbrand) {
		this.gbrand = gbrand;
	}
	public Float getGprice() {
		return gprice;
	}
	public void setGprice(Float gprice) {
		this.gprice = gprice;
	}
	public String getColortype() {
		return colortype;
	}
	public void setColortype(String colortype) {
		this.colortype = colortype;
	}
	/** 品牌 */
    private String gbrand;
    /** 商品价格 */
    private Float gprice;
    /** 颜色名 */
    private String colortype;





   

 


	
	
	
}
              

