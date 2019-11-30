package com.lz.dto;

import java.io.Serializable;

import com.lz.pojo.Goods;
import com.lz.pojo.GoodsColor;

public class OrderInputGoods implements Serializable{
	private static final long serialVersionUID = -7397047431861669453L;
//	商品颜色
	private GoodsColor goodscolor;
//	商品信息
	private Goods goods;
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

}
