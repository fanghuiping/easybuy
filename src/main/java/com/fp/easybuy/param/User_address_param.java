package com.fp.easybuy.param;

import javax.validation.constraints.NotNull;

/**
 * 用户地址参数类
 */
public class User_address_param {
    private Long id;
    /*用户主键*/
    private Integer userId;
    /*地址*/
    @NotNull(message = "地址不能为空")
    private String address;
    /*是否是默认地址（1:是 0否）*/
    private Integer isDefault;
    /*备注*/
    private String remark;

    public User_address_param() {
    }

    public User_address_param(@NotNull(message = "地址不能为空") String address, Integer isDefault) {
        this.address = address;
        this.isDefault = isDefault;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
