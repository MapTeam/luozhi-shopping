package com.lz.pojo;

import java.util.Date;

public class GoodsOrder implements java.io.Serializable {
    private static final long serialVersionUID = 1910986375469950434L;


    /** 订单id */
    private Integer goid;

    /** 订单名 */
    private String goname;


    /** 用户id */
    private Integer uid;

    /** 出货单id */
    private String outgoodid;


    /** 地址 */
    private Integer addressid;

    /** 订单的状态 */
    private Integer gostate;

    /** godate */
    private Date godate;
//不想买的原因
    private String reason;
//卖家拒绝申请的原因
    private String refusereason;
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

	

	/**
     * 获取订单id
     * 
     * @return 订单id
     */
    public Integer getGoid() {
        return this.goid;
    }

    /**
     * 设置订单id
     * 
     * @param goid
     *          订单id
     */
    public void setGoid(Integer goid) {
        this.goid = goid;
    }

    /**
     * 获取订单名
     * 
     * @return 订单名
     */
    public String getGoname() {
        return this.goname;
    }

    /**
     * 设置订单名
     * 
     * @param goname
     *          订单名
     */
    public void setGoname(String goname) {
        this.goname = goname;
    }


    /**
     * 获取用户id
     * 
     * @return 用户id
     */
    public Integer getUid() {
        return this.uid;
    }

    /**
     * 设置用户id
     * 
     * @param uid
     *          用户id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取出货单id
     * 
     * @return 出货单id
     */
    public String getOutgoodid() {
        return this.outgoodid;
    }

    /**
     * 设置出货单id
     * 
     * @param outgoodid
     *          出货单id
     */
    public void setOutgoodid(String outgoodid) {
        this.outgoodid = outgoodid;
    }


    /**
     * 获取地址
     * 
     * @return 地址
     */
    public Integer getAddressid() {
        return this.addressid;
    }

    /**
     * 设置地址
     * 
     * @param addressid
     *          地址
     */
    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    /**
     * 获取订单的状态
     * 
     * @return 订单的状态
     */
    public Integer getGostate() {
        return this.gostate;
    }

    /**
     * 设置订单的状态
     * 
     * @param gostate
     *          订单的状态
     */
    public void setGostate(Integer gostate) {
        this.gostate = gostate;
    }

    /**
     * 获取godate
     * 
     * @return godate
     */
    public Date getGodate() {
        return this.godate;
    }

    /**
     * 设置godate
     * 
     * @param godate
     */
    public void setGodate(Date godate) {
        this.godate = godate;
    }

	@Override
	public String toString() {
		return "GoodsOrder [goid=" + goid + ", goname=" + goname +  ", uid=" + uid
				+ ", outgoodid=" + outgoodid +", addressid=" + addressid + ", gostate="
				+ gostate + ", godate=" + godate + "]";
	}

}