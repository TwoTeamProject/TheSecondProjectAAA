package com.pro.two.service.allRoom;

import java.util.List;
import java.util.Map;

public interface AllRoomService {
    /**
     * 查询酒店所有房间
     * @param map
     * @return
     */
    List<Map> getAllRoom(Map map);
    /**
     * 查询所有房间的数量
     * @return
     */
    int getAllRoomCount(Map map);

    /**
     * 修改房间
     * @param map
     * @return
     */
    int updateRoomPart(Map map);
}
