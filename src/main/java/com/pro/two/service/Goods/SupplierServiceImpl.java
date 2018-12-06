package com.pro.two.service.Goods;

import com.pro.two.dao.Goods.SupplierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:SupplierServiceImpl
 * discription:
 * author:Ryb
 * createTime:2018-11-26 19:45
 */
@Service
public class SupplierServiceImpl implements  SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public List<Map> getSuppList() {
        return supplierDao.getSuppList();
    }

    @Override
    public int add(Map map) {
        return supplierDao.add(map);
    }

    @Override
    public int delete(Integer id) {
        return supplierDao.delete(id);
    }
}
