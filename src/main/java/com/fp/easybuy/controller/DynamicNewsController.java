package com.fp.easybuy.controller;

import com.fp.easybuy.pojo.easybuy.News;
import com.fp.easybuy.pojo.easybuy.Product;
import com.fp.easybuy.repository.News_repository;
import com.fp.easybuy.repository.Product_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 新闻动态类
 */
@Controller
public class DynamicNewsController {
    @Autowired
    News_repository newsRepository;
    @Autowired
    Product_repository productRepository;

//    测试
//    @RequestMapping("/hui")
//    @ResponseBody
//    public List<News> fang()
//    {
//      return random(newsRepository.findAll(new Sort("id")));
//    }

    /**
     * 首页显示内容：新闻，商品
     * @param request
     * @return
     */
    @RequestMapping("/Journalism")
    public String journalism(HttpServletRequest request)
    {
        List<News> list = random(newsRepository.findAll(new Sort("id")),10);
        request.getSession().setAttribute("News",list);
        ListOfCommodities(request.getSession());

        return "redirect:/Commodity";
    }
    /*抽选出10个*/
    public List random(List newsList,int su)
    {
        Integer min = 0;
        Integer max = newsList.size();
        List newsList1 = new ArrayList<>();
        for (int i = 0;i<su;i++)
        {
            int cardNumber = (int)(Math.random()*(max-min))+min;
            newsList1.add(newsList.get(cardNumber));
        }
        return newsList1;
    }

    /**
     * 商品列表
     * @param session
     */
    public void ListOfCommodities(HttpSession session)
    {
        List<Product> random = random(productRepository.findAll(),8);
        session.setAttribute("random",random);

    }



}
