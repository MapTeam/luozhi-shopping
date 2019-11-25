package com.lz.pojo;

public class GoodsCar implements java.io.Serializable {
    private static final long serialVersionUID = -4126763625936544247L;


    /** 购物车id */
    private Integer gcid;

    /** 用户id */
    private Integer uid;


    /**
     * 获取购物车id
     * 
     * @return 购物车id
     */
    public Integer getGcid() {
        return this.gcid;
    }

    /**
     * 设置购物车id
     * 
     * @param gcid
     *          购物车id
     */
    public void setGcid(Integer gcid) {
        this.gcid = gcid;
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

	@Override
	public String toString() {
		return "GoodsCar [gcid=" + gcid + ", uid=" + uid + "]";
	}

}