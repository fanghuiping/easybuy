package com.fp.easybuy.repository;

import com.fp.easybuy.pojo.easybuy.Product_category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product_category_repository extends JpaRepository<Product_category, Long> {
    /*查询type菜单*/
    List<Product_category> findByType(Integer type);
    /*查询parentid菜单*/
    List<Product_category> findByParentIdAndType(Integer parentId,Integer type);

}
