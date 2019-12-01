package com.lz.dto;

import java.io.Serializable;
import java.util.List;

import com.lz.pojo.Address;
import com.lz.pojo.Goods;
import com.lz.pojo.GoodsColor;

public class OrderInputByCar implements Serializable{
	private static final long serialVersionUID = -3748282006920437782L;
//	地址的集合
	private List<Address> addresslist;
//  商品的集合
	private List<OrderInputGoods> orderinputgoods;
//	商品的数量
	private int goodscount;
	
	
	
	public List<OrderInputGoods> getOrderinputgoods() {
		return orderinputgoods;
	}
	public void setOrderinputgoods(List<OrderInputGoods> orderinputgoods) {
		this.orderinputgoods = orderinputgoods;
	}
	public int getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	public List<Address> getAddresslist() {
		return addresslist;
	}
	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}
	
	
}
