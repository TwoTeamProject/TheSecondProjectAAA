package com.pro.two.service.Goods;

import java.util.List;
import java.util.Map;

/**
 * className:SupplierService
 * discription:
 * author:Ryb
 * createTime:2018-11-26 19:43
 */
public interface SupplierService {
    /**
     * 查询供应商信息
     * @param map
     * @return
     */
    List<Map> getSuppList();

    /**
     * 供应商添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 根据id删除供应商信息
     * @param id
     * @return
     */
    int delete(Integer id);
}
