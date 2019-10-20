package com.fp.easybuy.pojo.easybuy;

import javax.persistence.*;

/**
 * 商品表
 */
@Entity
@Table(name = "easybuy_product")
public class Product {
    /*主键*/
    @Id
    private Long id;
    /*名称*/
    @Column(nullable = false)
    private String name;
    /*描述*/
    @Column(nullable = false)
    private String description;
    /*价格*/
    @Column(nullable = false)
    private float price;
    /*库存*/
    @Column(nullable = false)
    private Integer stock;
    /*分类1*/
    @Column(nullable = false)
    private Integer categoryLevel1Id;
    /*分类2*/
    @Column(nullable = false)
    private Integer categoryLevel2Id;
    /*分类3*/
    @Column(nullable = false)
    private Integer categoryLevel3Id;
    /*文件名称*/
    @Column(nullable = false)
    private String fileName;
    /*是否删除(1：删除 0：未删除)*/
    @Column(nullable = false)
    private Integer isDelete;

    public Product(Long id, String name, float price, String fileName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fileName = fileName;
    }

    public Product() {
    }

    public Product(String name, float price, String fileName) {
        this.name = name;
        this.price = price;
        this.fileName = fileName;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCategoryLevel1Id() {
        return categoryLevel1Id;
    }

    public void setCategoryLevel1Id(Integer categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }

    public Integer getCategoryLevel2Id() {
        return categoryLevel2Id;
    }

    public void setCategoryLevel2Id(Integer categoryLevel2Id) {
        this.categoryLevel2Id = categoryLevel2Id;
    }

    public Integer getCategoryLevel3Id() {
        return categoryLevel3Id;
    }

    public void setCategoryLevel3Id(Integer categoryLevel3Id) {
        this.categoryLevel3Id = categoryLevel3Id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
