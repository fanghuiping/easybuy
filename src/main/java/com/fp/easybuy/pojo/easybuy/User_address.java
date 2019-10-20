package com.fp.easybuy.pojo.easybuy;

import javax.persistence.*;
import java.sql.Date;

/**
 * 用户地址表
 */
@Entity
@Table(name = "easybuy_user_address")
public class User_address {
    /*主键*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*用户主键*/
    @Column(nullable = false)
    private Integer userId;
    /*地址*/
    @Column(nullable = false)
    private String address;
    /*创建时间*/
    @Column(nullable = false)
    private Date createTime;
    /*是否是默认地址（1:是 0否）*/
    @Column(nullable = false)
    private Integer isDefault;
    /*备注*/
    @Column(nullable = false)
    private String remark;

    @Override
    public String toString() {
        return super.toString();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
