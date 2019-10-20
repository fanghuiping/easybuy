package com.fp.easybuy.controller;

import com.fp.easybuy.param.User_address_param;
import com.fp.easybuy.param.User_param;
import com.fp.easybuy.pojo.easybuy.User;
import com.fp.easybuy.pojo.easybuy.User_address;
import com.fp.easybuy.repository.User_address_repository;
import com.fp.easybuy.repository.User_repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 注册控制器
 */
@Controller
public class RegisterController {
    @Autowired
    User_repository userRepository;
    @Autowired
    User_address_repository userAddressRepository;

//    测试
//    @RequestMapping("/fang")
//    @ResponseBody
//    public Long fang()
//    {
//        User user = new User();
//        User_param userParam = new User_param("da","方慧平","123456",1,"360281200101136810","fang@qq.com","17379839318",0,new User_address_param("益乐新村",0));
//        BeanUtils.copyProperties(userParam,user);
//        User user1 = userRepository.save(user);
//        return user1.getId();
//    }

    /*注册*/
    @RequestMapping("/registerController")
    public String register(@Valid User_param userParam, BindingResult result, Model model)
    {
        User_address userAddress = new User_address();
        if(result.hasErrors())
        {
            model.addAttribute("erroMsg",verification(result));
            return "register";
        }
        if(duplicateName(userParam.getLoginName()).equals(false))
        {
            model.addAttribute("erroMsg","用户名已有");
            return "register";
        }
        Long id = saveUser(userParam);
        saveUserAddress(userParam.getUserAddressParam(),id);
        return "reg-result";
    }

    /*验证字段报错结果*/
    public String verification(BindingResult result)
    {
        String erroMsg = "";
        List<ObjectError> listErro = result.getAllErrors();
        for (ObjectError error : listErro)
        {
            erroMsg = erroMsg + error.getCode()+";"+ error.getDefaultMessage()+"\n";
        }
        return erroMsg;
    }

    /*新增User地址*/
    public void saveUserAddress(User_address_param userAddressParam,Long id)
    {
        User_address userAddress = new User_address();
        BeanUtils.copyProperties(userAddressParam,userAddress);

        userAddress.setUserId(id.intValue());
        userAddress.setCreateTime(new java.sql.Date(System.currentTimeMillis()));
        userAddress.setIsDefault(0);

        userAddressRepository.save(userAddress);
    }
    /*新增User返回地址id*/
    public Long saveUser(User_param userParam)
    {
        User user = new User();
        BeanUtils.copyProperties(userParam,user);
        user.setType(0);
        User user1 = userRepository.save(user);
        return user1.getId();
    }
    /*不允许重复名*/
    @PostMapping("/duplicateName")
    @ResponseBody
    public String duplicateName(String loginName)
    {
        User user = userRepository.findByLoginName(loginName);
        if (user != null)
        {
            return "false";
        }
        return "true";
    }



}
