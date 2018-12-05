package com.pro.two.controller.goods;

import com.pro.two.service.Goods.PurchaseService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 获取缺货单商品详情
     * @return
     */
    @RequestMapping("/ListDet")
    @ResponseBody
    public Object getListDet(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("data",purchaseService.getListDet(map));
        return tempMap;
    }

    /**
     * 跳转方法
     * @return
     */
    @RequestMapping("/toListDet")
    public String togetListDet(){

        return "/all-goods/purchaseDet";
    }

    /**
     * 修改缺货单状态（SD_STATE）
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object updateState(@RequestParam Map map){
        //System.out.println("--------------"+map.get("GOODS_NUM"));
        return purchaseService.updateState(map);
    }
}
