package com.pro.two.dao.Goods;

import java.util.List;
import java.util.Map;

/**
 * className:PurchaseDao
 * discription:
 * author:Ryb
 * createTime:2018-12-04 14:01
 */
public interface PurchaseDao {
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
}
