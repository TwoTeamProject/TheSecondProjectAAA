package com.pro.two.service.roompart;

import com.pro.two.dao.roompart.RoomPartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:RoomPartServiceImpl
 * discriptoin:
 * author:张晓峰
 * createTime:2018-11-24 13:49
 */
@Service
public class RoomPartServiceImpl implements RoomPartService{
    @Autowired
    private RoomPartDao roomPartDao;

    @Override
    public List<Map> getRoomPartList(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return roomPartDao.getRoomPartList(map);
    }

    @Override
    public int getRoomCount() {
        return roomPartDao.getRoomCount();
    }

    @Override
    public int updateRoom(Map map) {
        return roomPartDao.updateRoom(map);
    }

    @Override
    public int changeRoom(Map map) {
        return roomPartDao.changeRoom(map);
    }

    /**
     * 查询空房
     * @param map
     * @return
     */
    @Override
    public List<Map> emptyRoom(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return roomPartDao.emptyRoom(map);
    }

    @Override
    public int emptyRoomCount() {
        return roomPartDao.emptyRoomCount();
    }
}
