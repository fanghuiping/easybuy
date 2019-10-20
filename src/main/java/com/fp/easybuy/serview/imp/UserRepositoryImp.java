package com.fp.easybuy.serview.imp;

import com.fp.easybuy.pojo.easybuy.User;
import com.fp.easybuy.repository.User_repository;
import com.fp.easybuy.serview.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImp implements UserRepository {
    @Autowired
    User_repository userRepository;
    @Override
    public String LogonJudge(String loginName, String password) {
        User user =  userRepository.findByLoginNameAndPassword(loginName,password);
        if(user == null)
        {
            return "用户名或密码错误";
        }
        return "";
    }
}
