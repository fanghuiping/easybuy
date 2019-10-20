package com.fp.easybuy.controller;

import com.fp.easybuy.pojo.easybuy.Product_category;
import com.fp.easybuy.repository.Product_category_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品分类列表
 */
@Controller
public class CommodityController {
    @Autowired
    Product_category_repository categoryRepository;

    //    测试
//    @RequestMapping("/fang")
//    @ResponseBody
//    public List<Product_category> fang()
//    {
//        return categoryRepository.findAll();
//    }
    @RequestMapping("/Commodity")
    public String commodity(HttpServletRequest request) {
//        List<Product_category> productCategoryList1 = categoryRepository.findByType(1);

//        for (Product_category category :productCategoryList1)
//        {
//            productCategoryList2.add(categoryRepository.findByParentIdAndType(category.getId().intValue(),2));
//        }

//        for (Product_category category :productCategoryList1)
//        {
//            List<Product_category> categories1 = new ArrayList<>();
//            for (List<Product_category> categories : productCategoryList2) {
//                for (Product_category category2 : categories)
//                {
//                    if (category.getId().intValue() == category2.getParentId().intValue()) {
//                        categories1.add(category2);
//                    }
//                }
//            }
//            map.put(category,categories1);
//        }

//        循环遍历出Map
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        for (Map.Entry<Product_category,List<Product_category>> listEntry : map.entrySet())
//        {
//            System.out.println("标1");
//            System.out.println(listEntry.getKey().getName());
//            System.out.println("标2");
//            for (Product_category category : listEntry.getValue())
//            {
//                System.out.println(category.getName());
//            }
//        }
        request.getSession().setAttribute("Map", deploy(tabOne(categoryRepository), tabTow(tabOne(categoryRepository), categoryRepository), categoryRepository));
        return "index";
    }

    /**
     * 获得一级标签
     *
     * @return
     */
    public List<Product_category> tabOne(Product_category_repository categoryRepository) {
        List<Product_category> productCategoryList1 = categoryRepository.findByType(1);
        return productCategoryList1;
    }

    /**
     * 获取二级标签的值
     *
     * @param productCategoryList1
     * @return
     */
    public List<List<Product_category>> tabTow(List<Product_category> productCategoryList1, Product_category_repository categoryRepository) {
        List<List<Product_category>> productCategoryList2 = new ArrayList<>();
        for (Product_category category : productCategoryList1) {
            productCategoryList2.add(categoryRepository.findByParentIdAndType(category.getId().intValue(), 2));
        }
        return productCategoryList2;
    }

    /**
     * 获得三级标签并与二级标签封装
     *
     * @param productCategoryList2
     * @return
     */
    public Map<Product_category, List<Product_category>> tabThree(List<List<Product_category>> productCategoryList2, Product_category_repository categoryRepository) {
        Map<Product_category, List<Product_category>> listMap = new HashMap<>();
        List<Product_category> productCategoryList3;
        for (List<Product_category> categories : productCategoryList2) {
            for (Product_category category2 : categories) {
                productCategoryList3 = categoryRepository.findByParentIdAndType(category2.getId().intValue(), 3);
                listMap.put(category2, productCategoryList3);
            }
        }
        return listMap;
    }

    /**
     * 将标签1和标签2装到Map分类装好
     *
     * @param productCategoryList1
     * @param productCategoryList2
     * @return
     */
    public Map<Product_category, List<Product_category>> deploy(List<Product_category> productCategoryList1, List<List<Product_category>> productCategoryList2, Product_category_repository categoryRepository) {
        Map<Product_category, List<Product_category>> map = new HashMap<>();
        for (Product_category category : productCategoryList1) {
            List<Product_category> categories1 = new ArrayList<>();
            for (List<Product_category> categories : productCategoryList2) {
                for (Product_category category2 : categories) {
                    if (category.getId().intValue() == category2.getParentId().intValue()) {
                        categories1.add(category2);
                    }
                }
            }
            map.put(category, categories1);
        }

        return map;
    }

    /**
     * 将1标签2标签3标签全部保存
     * @param oneMap
     * @param towMap
     * @param categoryRepository
     * @return
     */
    public Map<Product_category, List<Map<Product_category, List<Product_category>>>> deployOneTowThree(Map<Product_category, List<Product_category>> oneMap, Map<Product_category, List<Product_category>> towMap, Product_category_repository categoryRepository) {
        Map<Product_category, List<Map<Product_category, List<Product_category>>>> mapMap = new HashMap<>();

        Map<Product_category, List<Product_category>> listMap = new HashMap<>();

        for (Map.Entry<Product_category, List<Product_category>> listEntry : oneMap.entrySet()) {
            List<Map<Product_category, List<Product_category>>> maps = new ArrayList<>();
            for (Product_category category : listEntry.getValue()) {
                Map<Product_category, List<Product_category>> listMap1 = new HashMap<>();
                for (Map.Entry<Product_category, List<Product_category>> listEntry1 : towMap.entrySet()) {
                    if (listEntry1.getKey().getId() == category.getId()) {
                        listMap1.put(listEntry1.getKey(), listEntry1.getValue());
                    }

                }
                maps.add(listMap1);
            }
            mapMap.put(listEntry.getKey(), maps);
        }
        return mapMap;
    }
}
