package com.fp.easybuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目控制器
 */
@Controller
public class EasybuyController {
    @RequestMapping("/")
    public String a() {
        return "redirect:/Journalism";
    }

    @RequestMapping("/newsView")
    public String newsView() {
        return "news-view";
    }

    @RequestMapping("/Login")
    public String Login() {
        return "login";
    }

    @RequestMapping("/Register")
    public String Register() {
        return "register";
    }

    @RequestMapping("/Index")
    public String index() {
        return "index";
    }

    @RequestMapping("/Shopping")
    public String shopping() {
        return "shopping";
    }

    @RequestMapping("/ProductList")
    public String ProductList() {
        return "product-list";
    }

    @RequestMapping("/productView")
    public String productView() {
        return "product-view";
    }

//    @RequestMapping("/Address")
//    public String address()
//    {
//        return "address";
//    }

}
