package com.fp.easybuy.pojo.easybuy;

import javax.persistence.*;

/**
 * 订单详细表
 */
@Entity
@Table(name = "easybuy_order_detail")
public class Order_detail {
    /*主键*/
    @Id
    @GeneratedValue
    private Long id;
    /*订单主键*/
    @Column(nullable = false)
    private Integer orderId;
    /*商品主键*/
    @Column(nullable = false)
    private Integer productId;
    /*数量*/
    @Column(nullable = false)
    private Integer quantity;
    /*消费*/
    @Column(nullable = false)
    private float cost;

    public Order_detail() {
    }

    public Order_detail(Integer orderId, Integer productId, Integer quantity, float cost) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
