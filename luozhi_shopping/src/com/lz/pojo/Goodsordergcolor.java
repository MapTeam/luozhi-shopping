package com.lz.pojo;


public class Goodsordergcolor implements java.io.Serializable {
    private static final long serialVersionUID = -7102611437029899346L;


    /** id */
    private Integer gogcid;

    /** 商品颜色id */
    private Integer gcolorid;

    /** 商品数量 */
    private Integer goodsnum;

    /** 订单名 */
    private String goname;


    /**
     * 获取id
     * 
     * @return id
     */
    public Integer getGogcid() {
        return this.gogcid;
    }

    /**
     * 设置id
     * 
     * @param gogcid
     *          id
     */
    public void setGogcid(Integer gogcid) {
        this.gogcid = gogcid;
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

    

	public String getGoname() {
		return goname;
	}

	public void setGoname(String goname) {
		this.goname = goname;
	}

	@Override
	public String toString() {
		return "Goodsordergcolor [gogcid=" + gogcid + ", gcolorid=" + gcolorid + ", goodsnum=" + goodsnum + ", goname="
				+ goname + "]";
	}
    
    
}