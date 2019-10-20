package com.fp.easybuy.controller;

import com.fp.easybuy.pojo.easybuy.Product;
import com.fp.easybuy.pojo.easybuy.User;
import com.fp.easybuy.pojo.easybuy.User_address;
import com.fp.easybuy.repository.User_address_repository;
import com.fp.easybuy.repository.User_repository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认地址
 */
@Controller
@Api("默认地址")
public class AddressController {
    @Autowired
    User_address_repository userAddressRepository;
    @Autowired
    User_repository userRepository;

    /**
     * 将用户注册的地址默认显示
     * @param number
     * @param request
     * @return
     */
    @GetMapping("/Address")
    @ApiOperation("将用户注册的地址默认显示")
    public String address(@RequestParam(defaultValue = "1",required = false) String number, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User user = null;
        try{
            user = userRepository.findByLoginName(session.getAttribute("err").toString());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("请先登录");
        }
        User_address userAddress = userAddressRepository.findByUserId(user.getId().intValue());
        session.setAttribute("userAddress",userAddress.getAddress());
        //session兩個值，現有特點，post提交
        session.setAttribute("number",number);
        return "address";
    }

    /**
     * 直接购买
     * @param request
     * @return
     */
    @PostMapping("/Submission")
    @ApiOperation("直接购买")
    public String Submission(HttpServletRequest request)
    {
        List<Product> productArrayList = new ArrayList<>();
        HttpSession session = request.getSession();
        Product product = new Product((Long) session.getAttribute("id"), session.getAttribute("name").toString(), (float) session.getAttribute("price"), session.getAttribute("fileName").toString());
        productArrayList.add(product);
        session.setAttribute("product", productArrayList);
        return "redirect:/Address";
    }

}
