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
}
