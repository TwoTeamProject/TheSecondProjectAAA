package com.pro.two.service.Goods;

import com.pro.two.dao.Goods.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:PurchaseServiceImpl
 * discription:
 * author:Ryb
 * createTime:2018-12-04 14:04
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {


    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public List<Map> getList() {

        return purchaseDao.getList();
    }

    @Override
    public List<Map> getListDet(Map map) {

        return purchaseDao.getListDet(map);
    }

    @Override
    public int updateState(Map map) {
        return purchaseDao.updateState(map);
    }
}
