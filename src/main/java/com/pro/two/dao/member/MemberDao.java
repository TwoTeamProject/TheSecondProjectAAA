package com.pro.two.dao.member;


import java.util.List;
import java.util.Map;

/**
 * 用户会员
 */
public interface MemberDao {
    /**
     * 会员登陆
     * @param map
     * @return
     */
    List<Map> memberLogin(Map map);

    /**
     * 会员注册
     * @param map
     * @return
     */
    int memberRegister(Map map);

    /**
     * 获取select信息
     * @return
     */
    List<Map> getSelect();
}
