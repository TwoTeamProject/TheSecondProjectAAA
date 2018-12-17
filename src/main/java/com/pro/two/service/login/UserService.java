package com.pro.two.service.login;

import com.pro.two.Entity.User;

import java.util.List;
import java.util.Map;

/**
 * className:UserService
 * discription:
 * author:sjq
 * createTime:2018-12-10 09:32
 */
public interface UserService {

    /**
     * 根据账号获取员工
     * @param userid
     * @return
     */
   User findByUserId(String userid, String password);



}
