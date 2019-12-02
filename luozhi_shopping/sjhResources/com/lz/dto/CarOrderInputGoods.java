package com.lz.dto;

import java.io.Serializable;

import com.lz.pojo.Goods;
import com.lz.pojo.GoodsColor;
/**
 * 购物车提交的订单的商品信息
 * @author sjh
 *
 */
public class CarOrderInputGoods implements Serializable{
	private static final long serialVersionUID = 8232744812624441316L;
	
//	商品颜色
	private GoodsColor goodscolor;
//	商品信息
	private Goods goods;
//	商品的数量
	private int goodscount;
	public GoodsColor getGoodscolor() {
		return goodscolor;
	}
	public void setGoodscolor(GoodsColor goodscolor) {
		this.goodscolor = goodscolor;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	
}
