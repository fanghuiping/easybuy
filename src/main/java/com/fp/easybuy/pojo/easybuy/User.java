package com.fp.easybuy.pojo.easybuy;

import javax.persistence.*;

/**
 * 用户表
 */
@Entity
@Table(name = "easybuy_user")
public class User {
    /*主键*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*登录名*/
    @Column(nullable = false)
    private String loginName;
    /*用户名*/
    @Column(nullable = false)
    private String userName;
    /*密码*/
    @Column(nullable = false)
    private String password;
    /*性别(1:男 0：女)*/
    @Column(nullable = false)
    private Integer sex;
    /*身份证号*/
    @Column(nullable = false)
    private String identityCode;
    /*邮箱*/
    @Column(nullable = false)
    private String email;
    /*手机*/
    @Column(nullable = false)
    private String mobile;
    /*类型（1：后台 0:前台）*/
    @Column(nullable = false)
    private Integer type;

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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}