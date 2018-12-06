package com.pro.two.controller.goods;

import com.pro.two.service.Goods.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:SupplierController
 * discription:
 * author:Ryb
 * createTime:2018-11-26 19:47
 */
@Controller
@RequestMapping("/Supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     *
     * 获取供应商信息
     * @return
     */
    //返回JSON
    @ResponseBody
    @RequestMapping("/List")
    public Object getGoodsList(){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("data",supplierService.getSuppList());
        return tempMap;
    }

    /**
     * 供应商列表请求方法
     * @return
     */
        @RequestMapping("/toList")
    public String toGetList(){
        return "all-goods/supplier";
    }

    /**
     * 添加供应商信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/addSupp")
    public Object add(@RequestParam Map map){
        int result = supplierService.add(map);
        Map tempMap = new HashMap();
        if(result==-1){
            tempMap.put("issuc",false);
        }else{
            tempMap.put("issuc",true);
        }
        return tempMap;
    }

    /**
     * 根据SUPP_ID删除供应商信息
     * @param SUPP_ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteRole(@RequestParam Integer SUPP_ID){
        int result = supplierService.delete(SUPP_ID);
        Map tempMap = new HashMap();
        if(result==-1){
            tempMap.put("issuc",false);
        }else{
            tempMap.put("issuc",true);
        }
        return tempMap;
    }

}
