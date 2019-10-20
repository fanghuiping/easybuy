package com.fp.easybuy.pojo.easybuy;

import javax.persistence.*;
import java.sql.Date;

/**
 * 订单表
 */
@Entity
@Table(name = "easybuy_order")
public class Order {
    /*主键*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*用户主键id*/
    @Column(nullable = false)
    private Integer userId;
    /*用户登录姓名*/
    @Column(nullable = false, unique = true)
    private String loginName;
    /*用户地址*/
    @Column(nullable = false)
    private String userAddress;
    /*创建时间*/
    @Column(nullable = false)
    private Date createTime;
    /*总消费*/
    @Column(nullable = false)
    private float cost;
    /*订单号*/
    @Column(nullable = false)
    private String serialNumber;

    public Order() {
    }

    public Order(Integer userId, String loginName, String userAddress, Date createTime, float cost, String serialNumber) {
        this.userId = userId;
        this.loginName = loginName;
        this.userAddress = userAddress;
        this.createTime = createTime;
        this.cost = cost;
        this.serialNumber = serialNumber;
    }

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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
