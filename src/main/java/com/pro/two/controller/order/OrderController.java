package com.pro.two.controller.order;

import com.pro.two.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:OrderController
 * discription:
 * author:sjq
 * createTime:2019-01-11 11:06
 */

@Controller
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 网上订单查询
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/List")
    public Object getList(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("count",orderService.getCount(map));
        tempMap.put("data",orderService.getList(map));
        return tempMap;
    }

    /**
     * 网上订单列表请求方法
     * @return
     */
    @RequestMapping("/toList")
    public String toGetList(){

        return "order/order";
    }
}
