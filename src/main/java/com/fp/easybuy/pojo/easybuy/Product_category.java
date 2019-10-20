package com.fp.easybuy.pojo.easybuy;

import javax.persistence.*;

/**
 * 商品分类表
 */
@Entity
@Table(name = "easybuy_product_category")
public class Product_category {
    /*主键*/
    @Id
    @GeneratedValue
    private Long id;
    /*名称*/
    @Column(nullable = false)
    private String name;
    /*父级目录id*/
    @Column(nullable = false)
    private Integer parentId;
    /*级别(1:一级 2：二级 3：三级)*/
    @Column(nullable = false)
    private Integer type;
    /*图标*/
    @Column(nullable = false)
    private String iconClass;

    @Override
    public String toString() {
        return super.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }
}
