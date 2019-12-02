package com.lz.dto;

import java.io.Serializable;
import java.util.List;

import com.lz.pojo.Address;
import com.lz.pojo.Goods;
import com.lz.pojo.GoodsColor;
/**
 * 购物车订单
 * @author sjh
 *
 */
public class OrderInputByCar implements Serializable{
	private static final long serialVersionUID = -3748282006920437782L;
//	地址的集合
	private List<Address> addresslist;
//  商品的集合
	private List<OrderInputGoods> orderinputgoods;
	
	public List<OrderInputGoods> getOrderinputgoods() {
		return orderinputgoods;
	}
	public void setOrderinputgoods(List<OrderInputGoods> orderinputgoods) {
		this.orderinputgoods = orderinputgoods;
	}
	public List<Address> getAddresslist() {
		return addresslist;
	}
	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}
	
	
}
