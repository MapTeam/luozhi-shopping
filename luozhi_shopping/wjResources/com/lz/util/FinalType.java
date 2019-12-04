package com.lz.util;

public interface FinalType {
	//未发货
	public final static int NOSHIPPED=0;
	//已发货
	public final static int SHIPPED=1;
	//待支付
	public final static int NOPAY=2;
	//已收货
	public final static int OVER=3;
	//申请退货订单
	public final static int GOODBACK=4;
	//已退货订单
	public final static int OVERGOODBACK=5;
	//拒绝退货订单
	public final static int REFUSEGOODBACK=6;
	//取消订单
	public final static int cancel=7;
}
