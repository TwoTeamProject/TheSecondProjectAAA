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
     * 获取会员信息
     * @return
     */
    List<Map> getMemberMsg(Map map);

    /**
     * 获取会员信息
     * @return
     */
    List<Map> getOrderMsg(Map map);

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

    /**
     * 取消订单
     * @param map
     * @return
     */
    int deleteOrder(Map map);

    /**
     * 查询空房数量
     * @param map
     * @return
     */
    List<Map> QueryVacancy(Map map);
}
