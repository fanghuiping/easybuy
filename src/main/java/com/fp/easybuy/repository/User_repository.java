package com.fp.easybuy.repository;

import com.fp.easybuy.pojo.easybuy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_repository extends JpaRepository<User,Long> {
     /*新增用户*/
     User save(User user);
     /*查询重复姓名*/
     User findByLoginName(String loginName);
     /*验证*/
     User findByLoginNameAndPassword(String loginName,String password);
}
