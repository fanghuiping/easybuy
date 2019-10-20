package com.fp.easybuy.controller;

import com.fp.easybuy.pojo.easybuy.Product;
import com.fp.easybuy.repository.Product_category_repository;
import com.fp.easybuy.repository.Product_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商品分类控制器
 */
@Controller
public class CommodityClassificationController {
    @Autowired
    Product_repository productRepository;
    @Autowired
    Product_category_repository categoryRepository;

    CommodityController commodityController = new CommodityController();

//    @RequestMapping("/fang")
//    @ResponseBody
//    public Map<Product_category, List<Map<Product_category, List<Product_category>>>> fang() {
//        return commodityController.deployOneTowThree
//                (
//                        commodityController.deploy
//                                (
//                                        commodityController.tabOne
//                                                (
//                                                        categoryRepository
//                                                ),
//                                        commodityController.tabTow
//                                                (
//                                                        commodityController.tabOne
//                                                                (
//                                                                        categoryRepository
//                                                                ),
//                                                        categoryRepository
//                                                ),
//                                        categoryRepository
//                                ),
//                        commodityController.tabThree
//                                (
//                                        commodityController.tabTow
//                                                (
//                                                        commodityController.tabOne
//                                                                (
//                                                                        categoryRepository
//                                                                ),
//                                                        categoryRepository
//                                                ),
//                                        categoryRepository
//
//                                ),
//                        categoryRepository
//                );
//    }

    /**
     * 商品二级分类显示的商品
     * @param tabOne
     * @param tabTow
     * @param tabOneId
     * @param tabTowId
     * @param request
     * @return
     */
    @GetMapping("/commodityClassification/{tabOne}/{tabTow}/{tabOneId}/{tabTowId}")
    public String commodityClassification(@PathVariable String tabOne, @PathVariable String tabTow, @PathVariable Long tabOneId, @PathVariable Long tabTowId, HttpServletRequest request)
    {
        System.out.println(tabOne);
        request.getSession().setAttribute("findProduct",findProduct(tabOneId,tabTowId));
        label(tabOne,tabTow,tabOneId,request);
        return "redirect:/ProductList";
    }

    /**
     * 查询一级标签商品内容
     * @param tabOneId
     * @param request
     * @return
     */
    @GetMapping("/commodityClassification/{tabOneId}")
    public String commodityClassification(@PathVariable Long tabOneId,HttpServletRequest request){
        request.getSession().removeAttribute("tabTow");
        request.getSession().setAttribute("findProduct",findProduct(tabOneId,null));
        return "redirect:/ProductList";
    }

    /**
     * 商品查询
     * @param tabOneId
     * @param tabTowId
     * @return
     */
    public List<Product> findProduct(Long tabOneId, Long tabTowId)
    {
        List<Product> productList;
        if(tabTowId != null)
        {
            productList = productRepository.findByCategoryLevel1IdAndCategoryLevel2Id(tabOneId.intValue(),tabTowId.intValue());
        }
        else
        {
            productList = productRepository.findByCategoryLevel1Id(tabOneId.intValue());
        }
        return productList;

    }

    /**
     * 我现在的位置
     * @param tabOne
     * @param tabTow
     * @param request
     * @return
     */
    public void label(String tabOne,String tabTow,Long tabOneId,HttpServletRequest request)
    {
        request.getSession().setAttribute("tabOne",tabOne);
        request.getSession().setAttribute("tabTow",tabTow);
        request.getSession().setAttribute("tabOneId",tabOneId);
    }


}
