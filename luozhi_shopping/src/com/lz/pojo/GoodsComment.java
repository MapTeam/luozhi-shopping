package com.lz.pojo;

import java.util.Date;

public class GoodsComment implements java.io.Serializable {
    private static final long serialVersionUID = -3602447499336152826L;


    /** 商品评价id */
    private Integer commentid;

    /** 商品id */
    private Integer gid;

    /** 用户id */
    private Integer uid;

    /** 评价内容 */
    private String commentcontent;

    /** 评价等级 */
    private Integer commentlevel;

    /** 评价时间 */
    private Date commentdate;


    /**
     * 获取商品评价id
     * 
     * @return 商品评价id
     */
    public Integer getCommentid() {
        return this.commentid;
    }

    /**
     * 设置商品评价id
     * 
     * @param commentid
     *          商品评价id
     */
    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
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
     * 获取评价内容
     * 
     * @return 评价内容
     */
    public String getCommentcontent() {
        return this.commentcontent;
    }

    /**
     * 设置评价内容
     * 
     * @param commentcontent
     *          评价内容
     */
    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    /**
     * 获取评价等级
     * 
     * @return 评价等级
     */
    public Integer getCommentlevel() {
        return this.commentlevel;
    }

    /**
     * 设置评价等级
     * 
     * @param commentlevel
     *          评价等级
     */
    public void setCommentlevel(Integer commentlevel) {
        this.commentlevel = commentlevel;
    }

    /**
     * 获取评价时间
     * 
     * @return 评价时间
     */
    public Date getCommentdate() {
        return this.commentdate;
    }

    /**
     * 设置评价时间
     * 
     * @param commentdate
     *          评价时间
     */
    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

	@Override
	public String toString() {
		return "GoodsComment [commentid=" + commentid + ", gid=" + gid + ", uid=" + uid + ", commentcontent="
				+ commentcontent + ", commentlevel=" + commentlevel + ", commentdate=" + commentdate + "]";
	}

}