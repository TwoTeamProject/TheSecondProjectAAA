package com.pro.two.dao.Goods;

import java.util.List;
import java.util.Map;

/**
 * className:SupplierDao
 * discription:
 * author:Ryb
 * createTime:2018-11-26 19:32
 */
public interface SupplierDao {
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
