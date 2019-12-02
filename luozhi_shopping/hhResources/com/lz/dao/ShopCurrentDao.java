package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.dto.OrderInputGoods;
import com.lz.pojo.Address;

public interface ShopCurrentDao {
	    /**
	     * 通过gcolorid查找到该商品改颜色的所有信息
	     * @param conn
	     * @param gcolorid
	     * @return
	     */
		public OrderInputGoods selectGoodsInformationByGcolorid(Connection conn,int gcolorid);
		/**
		 * 通过用户id查找到有关这个id的所有地址信息
		 * @param conn
		 * @param uid
		 * @return
		 */
		public List<Address> selectUserAddressByUid(Connection conn,int uid);
		/**
		 * 通过用户id更改所有的状态
		 * @param conn
		 * @param uid
		 */
		public boolean updateAllisdefault(Connection conn,int uid);
		/**
		 * 通过地址id改其默认值
		 * @param conn
		 * @param addressid
		 * @return
		 */
		public boolean updateDefaultByAddressId(Connection conn,int addressid);
}
