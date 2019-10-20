package com.fp.easybuy.controller;

import com.fp.easybuy.pojo.easybuy.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车控制器
 */
@Controller
public class ShoppingCartController {
    static List<Product> productList = new ArrayList<>();

    /**
     * 将商品注入到购物车中
     * @param request
     * @return
     */
    @GetMapping("ShoppingCart")
    public String shoppingCart(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Product product = new Product((Long) session.getAttribute("id"), session.getAttribute("name").toString(), (float) session.getAttribute("price"), session.getAttribute("fileName").toString());
        productList.add(product);
        session.setAttribute("product", productList);
        return "redirect:/Shopping";
    }

    /**
     * 将商品从购物车删除
     * @param itemStat
     * @param request
     * @return
     */
    @RequestMapping("/Delect/{itemStat}")
    public String delect(@PathVariable Integer itemStat, HttpServletRequest request)
    {
        productList.remove(itemStat - 1);
        request.getSession().setAttribute("product", productList);
        return "shopping";
    }

    /**
     * 将商品信息保存
     * @param id
     * @param name
     * @param description
     * @param price
     * @param stock
     * @param fileName
     * @param request
     * @return
     */
    @RequestMapping("/productView/{id}/{name}/{description}/{price}/{stock}/{fileName}")
    public String productView(@PathVariable Long id, @PathVariable String name, @PathVariable String description, @PathVariable float price, @PathVariable Integer stock, @PathVariable String fileName, HttpServletRequest request)
    {
        request.getSession().setAttribute("id", id);
        request.getSession().setAttribute("name", name);
        request.getSession().setAttribute("description", description);
        request.getSession().setAttribute("price", price);
        request.getSession().setAttribute("stock", stock);
        request.getSession().setAttribute("fileName", fileName);
        return "redirect:/productView";
    }
}
