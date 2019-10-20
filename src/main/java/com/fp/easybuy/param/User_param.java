package com.fp.easybuy.param;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户参数类
 */
public class User_param {
    private Long id;
    /*登录名*/
    @NotNull(message = "登录名不能为空")
    private String loginName;
    /*用户名*/
    @NotNull(message = "用户名不能为空")
    private String userName;
    /*密码*/
    @NotNull(message = "密碼不能为空")
    @Length(min = 6,max = 15,message = "密码需要在6到15之间")
    private String password;
    /*性别(1:男 0：女)*/
    private Integer sex;
    /*身份证号*/
    @Length(min = 18,max = 18,message = "身份证号为11位")
    private String identityCode;
    /*邮箱*/
    @Pattern(regexp = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$",message = "邮箱可格式错误")
    private String email;
    /*手机*/
    @Length(min = 6,max = 11,message = "手机号码错误")
    private String mobile;
    /*类型（1：后台 0:前台）*/
    private Integer type;
    /*用户地址*/
    private User_address_param userAddressParam;

    public User_param(@NotNull(message = "登录名不能为空") String loginName, @NotNull(message = "用户名不能为空") String userName, @NotNull(message = "密碼不能为空") @Length(min = 6, max = 15) String password, Integer sex, @Length(min = 18, max = 18, message = "身份证号为11位") String identityCode, @Pattern(regexp = "/^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$/") String email, @Length(min = 6, max = 11, message = "手机号码错误") String mobile, Integer type, User_address_param userAddressParam) {
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
        this.type = type;
        this.userAddressParam = userAddressParam;
    }

    public User_address_param getUserAddressParam() {
        return userAddressParam;
    }

    public void setUserAddressParam(User_address_param userAddressParam) {
        this.userAddressParam = userAddressParam;
    }

    public User_param() {
    }

    public User_param(@NotNull(message = "登录名不能为空") String loginName, @NotNull(message = "用户名不能为空") String userName, @NotNull(message = "密碼不能为空") @Length(min = 6, max = 15) String password, Integer sex, @Length(min = 18, max = 18, message = "身份证号为11位") String identityCode, @Pattern(regexp = "/^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$/") String email, @Length(min = 6, max = 11, message = "手机号码错误") String mobile, Integer type) {
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
        this.type = type;
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
