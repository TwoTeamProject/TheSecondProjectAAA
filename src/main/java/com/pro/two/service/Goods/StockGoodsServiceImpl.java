package com.pro.two.service.Goods;

import com.pro.two.dao.Goods.StockGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Map;

/**
 * className:StockGoodsServiceImpl
 * discription:
 * author:Ryb
 * createTime:2018-11-29 21:26
 */
@Service
public class StockGoodsServiceImpl implements StockGoodsService{


    //依赖注入
    @Autowired
    private StockGoodsDao stockGoodsDao;

    @Override
    public List<Map> getList(Map map) {
        return stockGoodsDao.getList(map);
    }

    @Override
    public List<Map> getSupp() {
        return stockGoodsDao.getSupp();
    }

    @Override
    public int addStock(Map map) {
        String[] hhh = (map.get("hhh") + "").split(",");
        String[] GOODS_ID = (map.get("GOODS_ID") + "").split(",");
        String[] GOODS_NAME = (map.get("GOODS_NAME") + "").split(",");
        for (int i = 0; i < hhh.length; i++) {
          map.put("hhh",hhh[i]);
          map.put("GOODS_ID",GOODS_ID[i]);
          map.put("GOODS_NAME",GOODS_NAME[i]);
          stockGoodsDao.addStock(map);
        }
        stockGoodsDao.addStockDet(map);
        return 0;
    }
}
