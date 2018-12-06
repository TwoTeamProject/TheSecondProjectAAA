package com.pro.two.service.Goods;

import java.util.List;
import java.util.Map;

/**
 * className:GoodsService
 * discription:
 * author:Ryb
 * createTime:2018-11-23 16:53
 */
public interface GoodsService {

    /**
     * 查询商品信息
     * @param map
     * @return
     */
    List<Map> getGoodsList(Map map);
    /**
     * 获取分页总数量
     * @return
     */
    int getGoodsCount(Map map);

    /**
     * 商品添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 根据id删除goods
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据GOODS_ID修改商品信息
     * @param map
     * @return
     */
    int update(Map map);
}
