package com.pro.two.dao.login;

import com.pro.two.Entity.User;

import java.util.List;
import java.util.Map;

/**
 * className:UserDao
 * discription:
 * author:sjq
 * createTime:2018-12-10 09:26
 */
public interface UserDao {

    /**
     * 根据账号获取员工
     * @param map
     * @return
     */
    User findByParam(Map map);

}
