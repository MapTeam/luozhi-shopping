package com.lz.pojo;

public class Outgood implements java.io.Serializable {
    private static final long serialVersionUID = 6229349314455319412L;


    /** 出货单id */
    private Integer outgoodid;

    /** 出货单名 */
    private String outgoodname;

    /** 用户id */
    private Integer uid;

    /** 收货地址 */
    private String receiveAddress;

    /** 物流信息 */
    private String logistics;


    /**
     * 获取出货单id
     * 
     * @return 出货单id
     */
    public Integer getOutgoodid() {
        return this.outgoodid;
    }

    /**
     * 设置出货单id
     * 
     * @param outgoodid
     *          出货单id
     */
    public void setOutgoodid(Integer outgoodid) {
        this.outgoodid = outgoodid;
    }

    /**
     * 获取出货单名
     * 
     * @return 出货单名
     */
    public String getOutgoodname() {
        return this.outgoodname;
    }

    /**
     * 设置出货单名
     * 
     * @param outgoodname
     *          出货单名
     */
    public void setOutgoodname(String outgoodname) {
        this.outgoodname = outgoodname;
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
     * 获取收货地址
     * 
     * @return 收货地址
     */
    public String getReceiveAddress() {
        return this.receiveAddress;
    }

    /**
     * 设置收货地址
     * 
     * @param receiveAddress
     *          收货地址
     */
    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    /**
     * 获取物流信息
     * 
     * @return 物流信息
     */
    public String getLogistics() {
        return this.logistics;
    }

    /**
     * 设置物流信息
     * 
     * @param logistics
     *          物流信息
     */
    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

	@Override
	public String toString() {
		return "Outgood [outgoodid=" + outgoodid + ", outgoodname=" + outgoodname + ", uid=" + uid + ", receiveAddress="
				+ receiveAddress + ", logistics=" + logistics + "]";
	}

}