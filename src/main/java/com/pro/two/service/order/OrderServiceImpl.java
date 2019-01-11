package com.pro.two.service.order;

import com.pro.two.dao.order.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:OrderServiceImpl
 * discription:
 * author:sjq
 * createTime:2019-01-11 11:01
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Map> getList(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        //System.out.println(map.get("start")+"---"+map.get("end"));
        return orderDao.getList(map);
    }

    @Override
    public int getCount(Map map) {
        return orderDao.getCount(map);
    }
}
