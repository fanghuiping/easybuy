package com.fp.easybuy.repository;

import com.fp.easybuy.pojo.easybuy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product_repository extends JpaRepository<Product,Long> {
    /*查询所有*/
    List<Product> findAll();
    /*按分类1查询*/
    List<Product> findByCategoryLevel1Id(Integer categoryLevel1Id);
    /*按分类1和分类2查询*/
    List<Product> findByCategoryLevel1IdAndCategoryLevel2Id(Integer categoryLevel1Id,Integer categoryLevel2Id);
}
