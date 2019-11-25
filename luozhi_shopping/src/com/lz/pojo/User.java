package com.lz.pojo;

import java.util.Date;

public class User implements java.io.Serializable {
    private static final long serialVersionUID = -5402019254763117511L;


    /** 用户id */
    private Integer uid;

    /** 用户图片 */
    private String upicture;

    /** 用户名称 */
    private String uname;

    /** 用户密码 */
    private String upwd;

    /** 用户邮件 */
    private String email;

    /** 注册时间 */
    private Date registdate;

    /** 购物车id */
    private Integer gcid;

    private Integer credits;
    
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
     * 获取用户图片
     * 
     * @return 用户图片
     */
    public String getUpicture() {
        return this.upicture;
    }

    /**
     * 设置用户图片
     * 
     * @param upicture
     *          用户图片
     */
    public void setUpicture(String upicture) {
        this.upicture = upicture;
    }

    /**
     * 获取用户名称
     * 
     * @return 用户名称
     */
    public String getUname() {
        return this.uname;
    }

    /**
     * 设置用户名称
     * 
     * @param uname
     *          用户名称
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * 获取用户密码
     * 
     * @return 用户密码
     */
    public String getUpwd() {
        return this.upwd;
    }

    /**
     * 设置用户密码
     * 
     * @param upwd
     *          用户密码
     */
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    /**
     * 获取用户邮件
     * 
     * @return 用户邮件
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置用户邮件
     * 
     * @param email
     *          用户邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取注册时间
     * 
     * @return 注册时间
     */
    public Date getRegistdate() {
        return this.registdate;
    }

    /**
     * 设置注册时间
     * 
     * @param registdate
     *          注册时间
     */
    public void setRegistdate(Date registdate) {
        this.registdate = registdate;
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
     * 获取用户积分
     * @return
     */
	public Integer getCredits() {
		return credits;
	}
	/**
	 * 设置用户积分
	 * @param credits
	 */
	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", upicture=" + upicture + ", uname=" + uname + ", upwd=" + upwd + ", email="
				+ email + ", registdate=" + registdate + ", gcid=" + gcid + "]";
	}

}