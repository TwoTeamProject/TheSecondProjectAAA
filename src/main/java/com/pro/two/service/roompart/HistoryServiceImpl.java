package com.pro.two.service.roompart;

import com.pro.two.dao.roompart.HistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryServiceImpl
 * discription:
 * author:Ryb
 * createTime:2018-12-17 16:41
 */
@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryDao historyDao;


    @Override
    public List<Map> getHistory(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return historyDao.getHistory(map);
    }

    @Override
    public int getCount(Map map) {
        return historyDao.getCount(map);
    }
}
