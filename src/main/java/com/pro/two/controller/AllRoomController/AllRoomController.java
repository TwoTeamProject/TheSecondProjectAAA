package com.pro.two.controller.AllRoomController;

import com.pro.two.service.allRoom.AllRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:AllRoomController
 * discriptoin:
 * author:张晓峰
 * createTime:2018-11-27 16:47
 */
@Controller
@RequestMapping("/allRoom")
public class AllRoomController {
    @Autowired
    private AllRoomService allRoomService;

    /**
     * 查询酒店所有房间
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/all")
    public Object allRoomList(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("count",allRoomService.getAllRoomCount(map));
        tempMap.put("data",allRoomService.getAllRoom(map));
        return tempMap;
    }
    @RequestMapping("/toAllRoom")
    public Object toAllRoom(){
        return "allRoom";
    }

    /**
     * 修改房间
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object updateRoom(@RequestParam Map map){
        int result = allRoomService.updateRoomPart(map);
        Map tempMap = new HashMap();
        if (result == -1){
            tempMap.put("issuc", false);
        } else {
            tempMap.put("issuc", true);
        }
        //System.out.println(map);
        return tempMap;
    }
}
