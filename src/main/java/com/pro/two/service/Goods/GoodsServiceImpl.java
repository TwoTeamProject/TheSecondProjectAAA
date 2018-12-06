package com.pro.two.service.Goods;

import com.pro.two.dao.Goods.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:GoodsServiceImpl
 * discription:
 * author:Ryb
 * createTime:2018-11-23 16:55
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;


    @Override
    public List<Map> getGoodsList(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return goodsDao.getGoodsList(map);
    }

    @Override
    public int getGoodsCount(Map map) {
        return goodsDao.getGoodsCount(map);
    }

    @Override
    public int add(Map map) {
        return goodsDao.add(map);
    }

    @Override
    public int delete(Integer id) {
        return goodsDao.delete(id);
    }

    @Override
    public int update(Map map) {
        return goodsDao.update(map);
    }
}
