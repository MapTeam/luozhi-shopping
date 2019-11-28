package com.lz.dto;

import java.io.Serializable;
import java.util.List;

import com.lz.pojo.Goods;

public class ClassifyDto implements Serializable{
	private static final long serialVersionUID = 5960948301402180404L;
	
	private int pageCount;
	private int pageNo;
	private List<Goods> goods;
	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
	
}
