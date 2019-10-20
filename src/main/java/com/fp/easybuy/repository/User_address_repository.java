package com.fp.easybuy.repository;

import com.fp.easybuy.pojo.easybuy.User_address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_address_repository extends JpaRepository<User_address,Long> {
    /*新增用户地址*/
    User_address save(User_address user_address);

    /**
     * 查询用户
     * @param userId
     * @return
     */
    User_address findByUserId(Integer userId);
}
