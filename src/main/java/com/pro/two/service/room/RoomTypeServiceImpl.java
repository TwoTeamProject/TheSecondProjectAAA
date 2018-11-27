package com.pro.two.service.room;

import com.pro.two.dao.room.RoomTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:RoomTypeServiceImpl
 * discription:
 * author:sjq
 * createTime:2018-11-23 08:54
 */
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeDao roomTypeDao;

    /**
     * 查询房型
     * @param
     * @return
     */
    @Override
    public List<Map> selectRoomType() {
        return roomTypeDao.selectRoomType();
    }

    /**
     * 主页
     * @param
     * @return
     */
    @Override
    public List<Map> selectRoom(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo") + "");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize") + "");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",(pageNo*pageSize+1));
       /* System.out.println((pageNo-1)*pageSize+","+(pageNo*pageSize+1)+".....................");*/
        return roomTypeDao.selectRoom(map);
    }

    /**
     * 总数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return roomTypeDao.getPageCount(map);
    }

    /**
     * 添加房间
     * @param map
     * @return
     */
    @Override
    public int insertRoom(Map map){
        return roomTypeDao.insertRoom(map);
    }

    /**
     * 根据房间号查找
     * @param room_code
     * @return
     */
    @Override
    public Map selectRoomByCode(Integer room_code) {
        return roomTypeDao.selectRoomByCode(room_code);
    }

    /**
     * 登记入住
     * @param map
     * @return
     */
    @Override
    public int insertPart(Map map) {
        return roomTypeDao.insertPart(map);
    }

    /**
     * 登记成功改变状态
     * @param room_code
     * @return
     */
    @Override
    public int updateState(Integer room_code) {
        return roomTypeDao.updateState(room_code);
    }
}
