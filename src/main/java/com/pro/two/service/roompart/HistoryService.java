package com.pro.two.service.roompart;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryService
 * discription:
 * author:Ryb
 * createTime:2018-12-17 16:40
 */
public interface HistoryService {
    /**
     * 查询历史住房信息
     * @param map
     * @return
     */
    List<Map> getHistory(Map map);

    /**
     * 获取分页总数量
     * @return
     */
    int getCount(Map map);
}
