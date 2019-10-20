package com.fp.easybuy.repository;

import com.fp.easybuy.pojo.easybuy.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_repository extends JpaRepository<Order,Long> {
      /*新增*/
      Order save(Order order);
}
