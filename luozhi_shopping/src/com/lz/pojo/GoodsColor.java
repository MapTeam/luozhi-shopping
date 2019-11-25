package com.lz.pojo;

public class GoodsColor implements java.io.Serializable {
    private static final long serialVersionUID = 4216235265490955170L;


    /** 颜色id */
    private Integer gcolorid;

    /** 商品id */
    private Integer gid;

    /** 商品图片 */
    private String goodspicture;

    /** 颜色名 */
    private String colortype;

    /** 库存 */
    private Integer goodscount;


    /**
     * 获取颜色id
     * 
     * @return 颜色id
     */
    public Integer getGcolorid() {
        return this.gcolorid;
    }

    /**
     * 设置颜色id
     * 
     * @param gcolorid
     *          颜色id
     */
    public void setGcolorid(Integer gcolorid) {
        this.gcolorid = gcolorid;
    }

    /**
     * 获取商品id
     * 
     * @return 商品id
     */
    public Integer getGid() {
        return this.gid;
    }

    /**
     * 设置商品id
     * 
     * @param gid
     *          商品id
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取商品图片
     * 
     * @return 商品图片
     */
    public String getGoodspicture() {
        return this.goodspicture;
    }

    /**
     * 设置商品图片
     * 
     * @param goodspicture
     *          商品图片
     */
    public void setGoodspicture(String goodspicture) {
        this.goodspicture = goodspicture;
    }

    /**
     * 获取颜色名
     * 
     * @return 颜色名
     */
    public String getColortype() {
        return this.colortype;
    }

    /**
     * 设置颜色名
     * 
     * @param colortype
     *          颜色名
     */
    public void setColortype(String colortype) {
        this.colortype = colortype;
    }

    /**
     * 获取库存
     * 
     * @return 库存
     */
    public Integer getGoodscount() {
        return this.goodscount;
    }

    /**
     * 设置库存
     * 
     * @param goodscount
     *          库存
     */
    public void setGoodscount(Integer goodscount) {
        this.goodscount = goodscount;
    }

	@Override
	public String toString() {
		return "GoodsColor [gcolorid=" + gcolorid + ", gid=" + gid + ", goodspicture=" + goodspicture + ", colortype="
				+ colortype + ", goodscount=" + goodscount + "]";
	}

}