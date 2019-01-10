package com.pro.two.service.member;

import java.util.List;
import java.util.Map;

public interface MemberService {
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
     * 获取房间类型信息
     * @return
     */
    List<Map> getRoomType(Map map);

    /**
     * 提交订单
     * @param map
     * @return
     */
    int submitOrder(Map map);
}
