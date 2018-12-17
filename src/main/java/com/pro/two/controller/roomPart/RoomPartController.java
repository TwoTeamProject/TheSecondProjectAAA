package com.pro.two.controller.roomPart;

import com.pro.two.service.roompart.RoomPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:RoomPartController
 * discriptoin:
 * author:张晓峰
 * createTime:2018-11-24 13:57
 */
@Controller
@RequestMapping("/roomPart")
public class RoomPartController {

    @Autowired
    private RoomPartService roomPartService;

    /**
     * 客人入住房间信息
     * @param map
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object getRoomPartList(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("count",roomPartService.getRoomCount(map));
        tempMap.put("data",roomPartService.getRoomPartList(map));
        return tempMap;
    }

    /**
     * 页面跳转方法
     * @param map
     * @return
     */
    @RequestMapping("/toRoomPart")
    public String toList(Map map){
        return "roomPart";
    }

    /**
     * 获取商品价格信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/toGetGoods")
    public Object getGoods(){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("data",roomPartService.getGoods());
        return tempMap;
    }

    /**
     * 退房
     * @param map
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object updateRoom(@RequestParam Map map){
        return roomPartService.updateRoom(map);
    }

    /**
     * 续订
     * @param map
     * @return
     */
    @RequestMapping("/extend")
    @ResponseBody
    public Object extendRoom(@RequestParam Map map){
        //System.out.println(map);
        return roomPartService.extendRoom(map);
    }

    /**
     * 换房
     * @param map
     * @return
     */

    //查询空房
    @RequestMapping("/empty")
    @ResponseBody
    public Object emptyRoom(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("data",roomPartService.emptyRoom(map));
        return tempMap;
    }

    /**
     * 换房
     * @param map
     * @return
     */
    @RequestMapping("/ceRoom")
    @ResponseBody
    public Object update(@RequestParam Map map){
        int updateARoom = roomPartService.update(map);
        //System.out.println(updateARoom);
        return updateARoom;
    }

}
