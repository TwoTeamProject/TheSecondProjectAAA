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
        //System.out.println(map.get("start")+"---"+map.get("end"));
        return roomPartDao.getRoomPartList(map);
    }

    @Override
    public int getRoomCount(Map map) {
        return roomPartDao.getRoomCount(map);
    }

    @Override
    public List<Map> getGoods() {
        return roomPartDao.getGoods();
    }

    @Override
    public int updateRoom(Map map) {
        roomPartDao.updateRoomPart(map);
        roomPartDao.updateRoom(map);
        if(map.get("GOODS_ID")!= null || map.get("GOODS_ID")!=""){
            String[] GOODS_ID = (map.get("GOODS_ID") + "").split(",");
            String[] GOODS_NUM = (map.get("GOODS_NUM") + "").split(",");
            for (int i = 0;i<GOODS_ID.length;i++){
                map.put("GOODS_ID",GOODS_ID[i]);
                map.put("GOODS_NUM",GOODS_NUM[i]);
                roomPartDao.updateGoods(map);
            }
        }
        return 0;
    }

    @Override
    public int extendRoom(Map map) {
        return roomPartDao.extendRoom(map);
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
    public int update(Map map) {
        roomPartDao.update(map);
        roomPartDao.updateO(map);
        return roomPartDao.updateT(map);
    }
}
