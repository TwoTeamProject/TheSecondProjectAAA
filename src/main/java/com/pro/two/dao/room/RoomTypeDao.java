package com.pro.two.dao.room;
import java.util.List;
import java.util.Map;

/**
 * className:RoomTypeDao
 * discription:
 * author:sjq
 * createTime:2018-11-23 08:47
 */
public interface RoomTypeDao {

    /**
     * 查询房型
     * @param
     * @return
     */
    List<Map> selectRoomType();

    /**
     * 主页
     * @return
     */
    List<Map> selectRoom(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 添加房间
     * @param map
     * @return
     */
    int insertRoom(Map map);

    /**
     * 根据房间号查找
     * @param room_code
     * @return
     */
    Map selectRoomByCode(Integer room_code);

    /**
     * 登记入住
     * @param map
     * @return
     */
    int insertPart(Map map);

    /**
     * 登记成功改变状态
     * @param room_state
     * @return
     */
    int updateState(Integer room_state);


    /**
     * 批量入住登记
     * @param map
     * @return
     */
    int insertBatchRoom(Map map);

}
