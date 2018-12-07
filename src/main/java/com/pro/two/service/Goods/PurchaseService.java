package com.pro.two.service.Goods;

import java.util.List;
import java.util.Map;

/**
 * className:PurchaseService
 * discription:
 * author:Ryb
 * createTime:2018-12-04 14:04
 */
public interface PurchaseService {
    /**
     * 获取缺货单信息
     * @return
     */
    List<Map> getList();

    /**
     * 获取缺货单商品详情
     * @return
     */
    List<Map> getListDet(Map map);

    /**
     * 修改缺货单状态（SD_STATE）
     * @return
     */
    int updateState(Map map);

    /**
     * 根据SD_ID删除缺货单信息
     * @param SD_ID
     * @return
     */
    int delete(Integer SD_ID);


    /**
     * 缺货单历史记录表详情
     * @return
     */
    List<Map> getHistory();

    /**
     * 缺货单历史记录表详情
     * @return
     */
    List<Map> getInStorage();
}
