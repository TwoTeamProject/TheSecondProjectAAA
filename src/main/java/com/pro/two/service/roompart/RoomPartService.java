package com.pro.two.service.roompart;

import java.util.List;
import java.util.Map;

public interface RoomPartService {

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
    int getRoomCount(Map map);

    /**
     * 获取商品价格信息
     * @return
     */
    List<Map> getGoods();

    /**
     * 退房 1、更改TB_ROOM房间状态
     * 退房 2、更改TB_ROOM_PART房间状态
     * 退房 3、TB_GOODS表中商品数量
     * @param map
     * @return
     */
    int updateRoom(Map map);

    /**
     * 续订房间
     * @param map
     * @return
     */
    int extendRoom(Map map);



    /**
     * 查询空房
     * @param map
     * @return
     */
    List<Map> emptyRoom(Map map);

    /**
     * 更换房间
     * @param map
     * @return
     */
    int update(Map map);


    /**
     * 查询客人入住的房间
     * @param map
     * @return
     */
    List<Map> getRoomPartListB(Map map);

    /**
     * 获取分页总数量
     * @return
     */
    int getRoomCountB(Map map);
}
