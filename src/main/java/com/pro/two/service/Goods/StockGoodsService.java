package com.pro.two.service.Goods;

import java.util.List;
import java.util.Map;

/**
 * className:StockGoodsService
 * discription:
 * author:Ryb
 * createTime:2018-11-29 21:25
 */
public interface StockGoodsService {
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


}
