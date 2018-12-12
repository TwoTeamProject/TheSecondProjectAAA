package com.pro.two.controller.goods;

import com.pro.two.service.Goods.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
     * 获取缺货单信息跳转方法
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
        //System.out.println(tempMap);
        return tempMap;
    }


    /**
     * 修改缺货单状态（SD_STATE）
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object updateState(@RequestParam Map map){
        return purchaseService.updateState(map);
    }

    /**
     * 根据GOODS_ID删除缺货单信息
     * @param SD_ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestParam Integer SD_ID){
        int result = purchaseService.delete(SD_ID);
        Map tempMap = new HashMap();
        if(result==-1){
            tempMap.put("issuc",false);
        }else{
            tempMap.put("issuc",true);
        }
        return tempMap;
    }


    /**
     * 获取缺货单历史记录表详情
     * @return
     */
    @ResponseBody
    @RequestMapping("/getHistory")
    public Object getHistory(){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("data",purchaseService.getHistory());
        return tempMap;

    }

    /**
     * 缺货历史表单跳转方法
     * @return
     */
    @RequestMapping("/toGetHistory")
    public String toGetHistory(){

        return "/all-goods/purchaseDet";
    }


    /**
     * 入库表单跳转方法
     * @return
     */
    @RequestMapping("/toInStorage")
    public String toInStorage(){

        return "/all-goods/inStorage";
    }


    /**
     * 获取入库记录表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getInStorage")
    public Object getInStorage(){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("data",purchaseService.getInStorage());
        return tempMap;

    }


}
