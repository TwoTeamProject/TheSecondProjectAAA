package com.pro.two.dao.allRoom;

import java.util.List;
import java.util.Map;

public interface AllRoomDao {
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
    int getAllRoomCount();

    /**
     * 修改房间
     * @param map
     * @return
     */
    int updateRoomPart(Map map);
}
