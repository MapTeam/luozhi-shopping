package com.lz.pojo;

public class Address implements java.io.Serializable {
    private static final long serialVersionUID = -1535416839392589444L;


    /** 地址id */
    private Integer addressid;

    /** 用户id */
    private Integer uid;

    /** 收货人 */
    private String name;

    /** 电话 */
    private Integer tel;

    /** 是否为默认地址 */
    private Integer isdefault;

    /** 省份 */
    private String province;

    /** 市/县 */
    private String city;

    /** 区/乡 */
    private String village;

    /** 详细地址 */
    private String detail;


    /**
     * 获取地址id
     * 
     * @return 地址id
     */
    public Integer getAddressid() {
        return this.addressid;
    }

    /**
     * 设置地址id
     * 
     * @param addressid
     *          地址id
     */
    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
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
     * 获取收货人
     * 
     * @return 收货人
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置收货人
     * 
     * @param name
     *          收货人
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取电话
     * 
     * @return 电话
     */
    public Integer getTel() {
        return this.tel;
    }

    /**
     * 设置电话
     * 
     * @param tel
     *          电话
     */
    public void setTel(Integer tel) {
        this.tel = tel;
    }

    /**
     * 获取是否为默认地址
     * 
     * @return 是否为默认地址
     */
    public Integer getIsdefault() {
        return this.isdefault;
    }

    /**
     * 设置是否为默认地址
     * 
     * @param isdefault
     *          是否为默认地址
     */
    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * 获取省份
     * 
     * @return 省份
     */
    public String getProvince() {
        return this.province;
    }

    /**
     * 设置省份
     * 
     * @param province
     *          省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市/县
     * 
     * @return 市/县
     */
    public String getCity() {
        return this.city;
    }

    /**
     * 设置市/县
     * 
     * @param city
     *          市/县
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区/乡
     * 
     * @return 区/乡
     */
    public String getVillage() {
        return this.village;
    }

    /**
     * 设置区/乡
     * 
     * @param village
     *          区/乡
     */
    public void setVillage(String village) {
        this.village = village;
    }

    /**
     * 获取详细地址
     * 
     * @return 详细地址
     */
    public String getDetail() {
        return this.detail;
    }

    /**
     * 设置详细地址
     * 
     * @param detail
     *          详细地址
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", uid=" + uid + ", name=" + name + ", tel=" + tel + ", isdefault="
				+ isdefault + ", province=" + province + ", city=" + city + ", village=" + village + ", detail="
				+ detail + "]";
	}

}