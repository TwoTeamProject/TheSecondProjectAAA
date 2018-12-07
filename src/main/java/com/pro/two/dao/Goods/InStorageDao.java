package com.pro.two.dao.Goods;

import java.util.Map;

/**
 * className:InStorageService
 * discription:
 * author:Ryb
 * createTime:2018-12-06 21:29
 */
public interface InStorageDao {

    /**
     * 入库
     * @return
     */
    int addStorage(Map map);

    /**
     * 修改TB_STOCKDET表中state状态为2
     * @param map
     * @return
     */
    int updateState(Map map);
}
