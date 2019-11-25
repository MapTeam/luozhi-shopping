package com.lz.pojo;

public class GoodsIntroduceImg implements java.io.Serializable {
    private static final long serialVersionUID = 2958031198179118361L;


    /** 商品详情id */
    private Integer giid;

    /** 商品id */
    private Integer gid;

    /** 详情图片组 */
    private String introduceImgs;


    /**
     * 获取商品详情id
     * 
     * @return 商品详情id
     */
    public Integer getGiid() {
        return this.giid;
    }

    /**
     * 设置商品详情id
     * 
     * @param giid
     *          商品详情id
     */
    public void setGiid(Integer giid) {
        this.giid = giid;
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
     * 获取详情图片组
     * 
     * @return 详情图片组
     */
    public String getIntroduceImgs() {
        return this.introduceImgs;
    }

    /**
     * 设置详情图片组
     * 
     * @param introduceImgs
     *          详情图片组
     */
    public void setIntroduceImgs(String introduceImgs) {
        this.introduceImgs = introduceImgs;
    }

	@Override
	public String toString() {
		return "GoodsIntroduceImg [giid=" + giid + ", gid=" + gid + ", introduceImgs=" + introduceImgs + "]";
	}

}