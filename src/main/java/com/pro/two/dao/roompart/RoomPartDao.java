package com.pro.two.dao.roompart;

import java.util.List;
import java.util.Map;

public interface RoomPartDao {
    /**
     * 查询客人入住的房间
     * @param map
     * @return
     */
    List<Map> getRoomPartList(Map map);

    /**
     * 获取分页总数量
     * @return
     */
    int getRoomCount();

    /**
     * 退房
     * @param map
     * @return
     */
    int updateRoom(Map map);

    /**
     * 换房
     * @param map
     * @return
     */
    int changeRoom(Map map);

    /**
     * 查询空房
     * @param map
     * @return
     */
    List<Map> emptyRoom(Map map);

    /**
     * 空房分页数量
     * @return
     */
    int emptyRoomCount();

    /**
     *                                                                                                                更换房间
     * @param map
     * @return
     */
    int update(Map map);
}
