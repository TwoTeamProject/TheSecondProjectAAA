package com.pro.two.controller.roomPart;

import com.pro.two.service.roompart.RoomPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/list")
    @ResponseBody
    public Object getRoomPartList(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("count",roomPartService.getRoomCount());
        tempMap.put("data",roomPartService.getRoomPartList(map));
        return tempMap;
    }
    @RequestMapping("/toRoomPart")
    public String toList(Map map){
        return "roomPart";
    }
    @RequestMapping("/update")
    @ResponseBody
    public Object updateRoom(@RequestParam Map map){
        int result = roomPartService.updateRoom(map);
        Map tempMap = new HashMap();
        if (result==-1){
            tempMap.put("issuc",false);
        }else{
            tempMap.put("issuc",true);
        }
        return tempMap;
    }
    @RequestMapping("/change")
    @ResponseBody
    public Object changeRoom(@RequestParam Map map){
        int result = roomPartService.changeRoom(map);
        Map tempMap = new HashMap();
        if (result==-1){
            tempMap.put("issuc",false);
        }else{
            tempMap.put("issuc",true);
        }
        System.out.println(map);
        return tempMap;
    }
    @RequestMapping("/empty")
    @ResponseBody
    public Object emptyRoom(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("data",roomPartService.emptyRoom(map));
        System.out.println(tempMap);
        return tempMap;
    }

}
