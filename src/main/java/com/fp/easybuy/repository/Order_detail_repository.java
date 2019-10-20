package com.fp.easybuy.repository;

import com.fp.easybuy.pojo.easybuy.Order_detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_detail_repository extends JpaRepository<Order_detail,Long> {
    /*新增订单详细*/
    Order_detail save(Order_detail orderDetail);
}
