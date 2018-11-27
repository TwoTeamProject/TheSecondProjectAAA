package com.pro.two.service.login;

import java.util.List;
import java.util.Map;

/**
 * className:LoginService
 * discription:
 * author:sjq
 * createTime:2018-11-22 10:03
 */
public interface LoginService {

    /**
     * 用户登陆
     * @param map
     * @return
     */
    List<Map> userLogin(Map map);
}
