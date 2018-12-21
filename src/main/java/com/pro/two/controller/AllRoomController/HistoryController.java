package com.pro.two.controller.AllRoomController;

import com.pro.two.service.roompart.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:HistoryController
 * discription:
 * author:Ryb
 * createTime:2018-12-17 16:43
 */
@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    /**
     * 获取历史列表
     * @param map
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Object getHistory(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("count",historyService.getCount(map));
        tempMap.put("data",historyService.getHistory(map));
        System.out.println(tempMap);
        return tempMap;
    }

    /**
     * 跳转方法
     * @return
     */
    @RequestMapping("/toGetList")
    public Object toAllRoom(){
        return "HistoryRoom";
    }
}
