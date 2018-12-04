package com.pro.two.controller.goods;

import com.pro.two.service.Goods.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:PurchaseController
 * discription:
 * author:Ryb
 * createTime:2018-12-04 14:17
 */
@RequestMapping("/Purchase")
@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    /**
     * 获取缺货单信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/List")
    public Object getList(){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("data",purchaseService.getList());
        return tempMap;

    }

    /**
     * 跳转方法
     * @return
     */
    @RequestMapping("/toList")
    public String toGetList(){
        return "/all-goods/purchase";
    }
}
