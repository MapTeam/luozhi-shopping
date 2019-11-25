package com.lz.pojo;

public class Type implements java.io.Serializable {
    private static final long serialVersionUID = -2981700617812473915L;


    /** 类型id */
    private Integer tid;

    /** ttid */
    private Integer ttid;

    /** IP周边与数码的区分 */
    private Integer category1;

    /** 类别 */
    private Integer category2;

    /** 类型名 */
    private String tname;


    /**
     * 获取类型id
     * 
     * @return 类型id
     */
    public Integer getTid() {
        return this.tid;
    }

    /**
     * 设置类型id
     * 
     * @param tid
     *          类型id
     */
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    /**
     * 获取ttid
     * 
     * @return ttid
     */
    public Integer getTtid() {
        return this.ttid;
    }

    /**
     * 设置ttid
     * 
     * @param ttid
     */
    public void setTtid(Integer ttid) {
        this.ttid = ttid;
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
     * 获取类型名
     * 
     * @return 类型名
     */
    public String getTname() {
        return this.tname;
    }

    /**
     * 设置类型名
     * 
     * @param tname
     *          类型名
     */
    public void setTname(String tname) {
        this.tname = tname;
    }

	@Override
	public String toString() {
		return "Type [tid=" + tid + ", ttid=" + ttid + ", category1=" + category1 + ", category2=" + category2
				+ ", tname=" + tname + "]";
	}

}