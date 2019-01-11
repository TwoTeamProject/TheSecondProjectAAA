package com.pro.two.dao.order;

import java.util.List;
import java.util.Map;

/**
 * className:OrderDao
 * discription:
 * author:sjq
 * createTime:2019-01-11 10:53
 */
public interface OrderDao {
    /**
     * 查询订单信息
     * @param map
     * @return
     */
    List<Map> getList(Map map);
    /**
     * 获取分页总数量
     * @return
     */
    int getCount(Map map);
}
