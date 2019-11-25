package com.lz.pojo;

public class GoodscarGoods implements java.io.Serializable {
    private static final long serialVersionUID = -5875603171324820022L;


    /** 购物车与商品的连接表id */
    private Integer gcGid;

    /** 用户id */
    private Integer uid;

    /** 购物车id */
    private Integer gcid;

    /** 商品颜色id */
    private Integer gcolorid;

    /** 商品数量 */
    private Integer goodsnum;


    /**
     * 获取购物车与商品的连接表id
     * 
     * @return 购物车与商品的连接表id
     */
    public Integer getGcGid() {
        return this.gcGid;
    }

    /**
     * 设置购物车与商品的连接表id
     * 
     * @param gcGid
     *          购物车与商品的连接表id
     */
    public void setGcGid(Integer gcGid) {
        this.gcGid = gcGid;
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
     * 获取商品颜色id
     * 
     * @return 商品颜色id
     */
    public Integer getGcolorid() {
        return this.gcolorid;
    }

    /**
     * 设置商品颜色id
     * 
     * @param gcolorid
     *          商品颜色id
     */
    public void setGcolorid(Integer gcolorid) {
        this.gcolorid = gcolorid;
    }

    /**
     * 获取商品数量
     * 
     * @return 商品数量
     */
    public Integer getGoodsnum() {
        return this.goodsnum;
    }

    /**
     * 设置商品数量
     * 
     * @param goodsnum
     *          商品数量
     */
    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

	@Override
	public String toString() {
		return "GoodscarGoods [gcGid=" + gcGid + ", uid=" + uid + ", gcid=" + gcid + ", gcolorid=" + gcolorid
				+ ", goodsnum=" + goodsnum + "]";
	}

}