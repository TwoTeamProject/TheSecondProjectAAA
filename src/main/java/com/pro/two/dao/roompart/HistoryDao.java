package com.pro.two.dao.roompart;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryDao
 * discription:
 * author:Ryb
 * createTime:2018-12-17 16:37
 */
public interface HistoryDao {
    /**
     * 查询客人入住的房间
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
