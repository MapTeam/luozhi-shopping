package com.lz.pojo;

public class Goods implements java.io.Serializable {
    private static final long serialVersionUID = -3413640718095905997L;


    /** 商品id */
    private Integer gid;

    /** 商品主图 */
    private String zpicture;

    /** 商品图片 */
    private String gpicture;

    /** 商品名字 */
    private String gname;

    /** 商品介绍 */
    private String gintroduce;

    /** 商品颜色id */
    private Integer gcolorid;

    /** IP周边与数码的区分 */
    private Integer category1;

    /** 类别 */
    private Integer category2;

    /** 品牌 */
    private String gbrand;

    /** 商品价格 */
    private Float gprice;

    /** 商品评分 */
    private Integer ggrade;

    /** 商品库存 */
    private Integer gcount;

    /** 商品材质 */
    private String gmaterial;

    /** 商品热度 */
    private Integer hot;


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
     * 获取商品主图 
     * 
     * @return 商品主图 
     */
    public String getZpicture() {
        return this.zpicture;
    }

    /**
     * 设置商品主图 
     * 
     * @param typeid
     *          商品主图 
     */
    public void setZpicture(String zpicture) {
        this.zpicture = zpicture;
    }

    /**
     * 获取商品主图片
     * 
     * @return 商品主图片
     */
    public String getGpicture() {
        return this.gpicture;
    }

    /**
     * 设置商品主图片
     * 
     * @param gpicture
     *          商品主图片
     */
    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    /**
     * 获取商品名字
     * 
     * @return 商品名字
     */
    public String getGname() {
        return this.gname;
    }

    /**
     * 设置商品名字
     * 
     * @param gname
     *          商品名字
     */
    public void setGname(String gname) {
        this.gname = gname;
    }

    /**
     * 获取商品介绍
     * 
     * @return 商品介绍
     */
    public String getGintroduce() {
        return this.gintroduce;
    }

    /**
     * 设置商品介绍
     * 
     * @param gintroduce
     *          商品介绍
     */
    public void setGintroduce(String gintroduce) {
        this.gintroduce = gintroduce;
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
     * 获取IP周边与数码的区分
     * 
     * @return IP周边与数码的区分
     */
    public Integer getCategory1() {
        return this.category1;
    }

    /**
     * 设置IP周边与数码的区分
     * 
     * @param category1
     *          IP周边与数码的区分
     */
    public void setCategory1(Integer category1) {
        this.category1 = category1;
    }

    /**
     * 获取类别
     * 
     * @return 类别
     */
    public Integer getCategory2() {
        return this.category2;
    }

    /**
     * 设置类别
     * 
     * @param category2
     *          类别
     */
    public void setCategory2(Integer category2) {
        this.category2 = category2;
    }

    /**
     * 获取品牌
     * 
     * @return 品牌
     */
    public String getGbrand() {
        return this.gbrand;
    }

    /**
     * 设置品牌
     * 
     * @param gbrand
     *          品牌
     */
    public void setGbrand(String gbrand) {
        this.gbrand = gbrand;
    }

    /**
     * 获取商品价格
     * 
     * @return 商品价格
     */
    public Float getGprice() {
        return this.gprice;
    }

    /**
     * 设置商品价格
     * 
     * @param gprice
     *          商品价格
     */
    public void setGprice(Float gprice) {
        this.gprice = gprice;
    }

    /**
     * 获取商品评分
     * 
     * @return 商品评分
     */
    public Integer getGgrade() {
        return this.ggrade;
    }

    /**
     * 设置商品评分
     * 
     * @param ggrade
     *          商品评分
     */
    public void setGgrade(Integer ggrade) {
        this.ggrade = ggrade;
    }

    /**
     * 获取商品库存
     * 
     * @return 商品库存
     */
    public Integer getGcount() {
        return this.gcount;
    }

    /**
     * 设置商品库存
     * 
     * @param gcount
     *          商品库存
     */
    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    /**
     * 获取商品材质
     * 
     * @return 商品材质
     */
    public String getGmaterial() {
        return this.gmaterial;
    }

    /**
     * 设置商品材质
     * 
     * @param gmaterial
     *          商品材质
     */
    public void setGmaterial(String gmaterial) {
        this.gmaterial = gmaterial;
    }

    /**
     * 获取商品热度
     * 
     * @return 商品热度
     */
    public Integer getHot() {
        return this.hot;
    }

    /**
     * 设置商品热度
     * 
     * @param hot
     *          商品热度
     */
    public void setHot(Integer hot) {
        this.hot = hot;
    }

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", zpicture=" + zpicture + ", gpicture=" + gpicture + ", gname=" + gname
				+ ", gintroduce=" + gintroduce + ", gcolorid=" + gcolorid + ", category1=" + category1 + ", category2="
				+ category2 + ", gbrand=" + gbrand + ", gprice=" + gprice + ", ggrade=" + ggrade + ", gcount=" + gcount
				+ ", gmaterial=" + gmaterial + ", hot=" + hot + "]";
	}

}