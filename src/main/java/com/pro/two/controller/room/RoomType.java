package com.pro.two.controller.room;

import com.pro.two.service.room.RoomTypeService;
import com.pro.two.util.pageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:RoomTypeDao
 * discription:
 * author:sjq
 * createTime:2018-11-22 21:48
 */
@RequestMapping("room")
@Controller
public class RoomType {

    @Autowired
    private RoomTypeService roomTypeService;

    /**
     * 房型跳转
     * @return
     */
    @RequestMapping("/toType")
    public String toType(){
        return "room-type";
    }

    /**
     * 查询房型
     * @return
     */
    @ResponseBody
    @RequestMapping("/type")
    public Object roomType(){
        List<Map> list = roomTypeService.selectRoomType();
        return roomTypeService.selectRoomType();
    }

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }
    /**
     * 主页跳转
     * @return
     */
    @RequestMapping("/toRoom")
    public String toRoom(){
        return "room";
    }

    /**
     * 主页
     * @return
     */
    @ResponseBody
    @RequestMapping("allRoom")
    public Object room(@RequestParam Map map, Model model, HttpServletRequest request){
        Map m = new HashMap();
        map.put("pageSize",15);
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo") + "");
        String stringPage = new pageUtil(pageNo,15,roomTypeService.getPageCount(map),request).getStringPage();
        /*model.addAttribute("stringPage",stringPage);*/
        m.put("stringPage",stringPage.replace("/pro/room/allRoom","/pro/room/toRoom"));
        m.put("list",roomTypeService.selectRoom(map));
        //System.out.println(m);
        return m;
    }

        /**
         * 新增房间跳转
         * @return
         */
        @RequestMapping("/toAddroom")
        public String toAddroom(){
            return "room-add";
        }

        /**
         * 新增房间
         * @return
         */
        @ResponseBody
        @RequestMapping("/addroom")
        public Object addroom(@RequestParam Map map){
            Object room_code = map.get("room_code");
            /*System.out.println(room_code);*/
            Map maps = new HashMap();
            int result = roomTypeService.insertRoom(map);
            //System.out.println(result);
            if (result!=-1){
                maps.put("issuc",true);
            }else {
                maps.put("issuc",false);
            }
            return maps;
        }

        /**
         * 跳转登记
         * @return
         */
        @RequestMapping("/tocheck")
        public String toCheck(){
            return "checkIn";
        }

        /**
         * 登记
         * @param room_code
         * @return
         */
        @ResponseBody
        @RequestMapping("/checkIn")
        public Object checkIn(@RequestParam Integer room_code){
            //System.out.println(room_code);
            return roomTypeService.selectRoomByCode(room_code);
        }

        /**
         * 入住登记
         * @param map
         * @return
         */
        @ResponseBody
        @RequestMapping("/part")
        public Object part(@RequestParam Map map){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date indate = sdf.parse(map.get("indate")+"");
                Date outdate = sdf.parse(map.get("outdate")+"");
                map.put("outdate",outdate);
                map.put("indate",indate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //System.out.println(map.get("indate"));
            Map maps = new HashMap();
            int result = roomTypeService.insertPart(map);
            roomTypeService.updateState(Integer.valueOf(map.get("room_code")+""));
            //System.out.println(result);
            if (result!=-1){
                maps.put("issuc",true);
            }else {
                maps.put("issuc",false);
            }
            return maps;
        }

    /**
     * 跳转登记
     * @return
     */
    @RequestMapping("/tobatchRoom")
    public String tobatchRoom(String roomIds,Model model){
        model.addAttribute("roomIds",roomIds);
        return "batchRoom";
    }

    /**
     * 批量入住登记
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/batchRoom")
    public Object batchRoom(@RequestParam Map map){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date indate = null;
        try {
            indate = sdf.parse(map.get("indate")+"");
            Date outdate = sdf.parse(map.get("outdate")+"");
            map.put("outdate",outdate);
            map.put("indate",indate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map maps = new HashMap();
        int result = roomTypeService.insertBatchRoom(map);
        roomTypeService.batchUpdateState(map);
        System.out.println(result);
        if (result!=-1){
            maps.put("issuc",true);
        }else {
            maps.put("issuc",false);
        }
        return maps;
    }
}
