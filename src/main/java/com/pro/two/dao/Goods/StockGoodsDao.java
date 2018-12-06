package com.pro.two.dao.Goods;

import java.util.List;
import java.util.Map;

/**
 * className:StockGoodsDao
 * discription:
 * author:Ryb
 * createTime:2018-11-29 21:22
 */
public interface StockGoodsDao {

    /**
     * 获取缺货物品列表
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 获取供应商名称
     * @return
     */
    List<Map> getSupp();

    /**
     * 向缺货表添加商品信息
     * @return
     */
    int addStock(Map map);

    /**
     * 向缺货单中添加信息
     * @return
     */
    int addStockDet(Map map);
}
