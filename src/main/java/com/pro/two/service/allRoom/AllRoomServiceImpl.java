package com.pro.two.service.allRoom;


import com.pro.two.dao.allRoom.AllRoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:AllRoomServiceImpl
 * discriptoin:
 * author:张晓峰
 * createTime:2018-11-27 16:26
 */
@Service
public class AllRoomServiceImpl implements AllRoomService{
    @Autowired
    private AllRoomDao allRoomDao;
    @Override
    public List<Map> getAllRoom(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return allRoomDao.getAllRoom(map);
    }

    @Override
    public int getAllRoomCount() {
        System.out.println(allRoomDao.getAllRoomCount());
        return allRoomDao.getAllRoomCount();
    }

    @Override
    public int updateRoomPart(Map map) {
        System.out.println(map);
        return allRoomDao.updateRoomPart(map);
    }
}
