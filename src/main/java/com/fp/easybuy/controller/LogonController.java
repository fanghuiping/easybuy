package com.fp.easybuy.controller;

import com.fp.easybuy.pojo.easybuy.User;
import com.fp.easybuy.repository.User_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 */
@Controller
public class LogonController {
    @Autowired
    User_repository userRepository;
//    @RequestMapping("/fang")
//    @ResponseBody
//    public User fang()
//    {
//       User user =  userRepository.findByLoginNameAndPassword("admin","e10adc3949ba59abbe56e057f20f883e");
//        return user;
//    }
    /*登录*/
    @RequestMapping("/Logon")
    public String Logon(String loginName, String password, HttpServletRequest request)
    {
        User user =  userRepository.findByLoginNameAndPassword(loginName,password);
        if(user == null)
        {
            request.setAttribute("err","用户名或密码错误");
            return "login";
        }
        request.getSession().setAttribute("err",loginName);
        return "redirect:/Journalism";
    }
}
