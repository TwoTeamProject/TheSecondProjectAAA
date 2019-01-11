package com.pro.two.service.order;

import java.util.List;
import java.util.Map;

/**
 * className:OrderService
 * discription:
 * author:sjq
 * createTime:2019-01-11 11:01
 */
public interface OrderService {
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
