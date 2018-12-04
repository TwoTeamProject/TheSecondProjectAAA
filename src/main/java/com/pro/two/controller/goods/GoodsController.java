package com.pro.two.controller.goods;

import com.pro.two.service.Goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:GoodsController
 * discription:
 * author:Ryb
 * createTime:2018-11-23 16:42
 */

@RequestMapping("/Goods")
@Controller
public class GoodsController {

    /**
     * 依赖注入
     */
    @Autowired
    private GoodsService goodsService;

    /**
     * 分页
     * 获取商品列表信息
     * @return
     */
    //返回JSON
    @ResponseBody
    @RequestMapping("/List")
    public Object getGoodsList(@RequestParam Map map){
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("count",goodsService.getGoodsCount(map));
        tempMap.put("data",goodsService.getGoodsList(map));
        return tempMap;
    }

    /**
     * 商品列表请求方法
     * @return
     */
    @RequestMapping("/toList")
    public String toGetList(){
        return "all-goods/goods";
    }

    /**
     * 添加商品信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/addGoods")
    public Object add(@RequestParam Map map){
        int result = goodsService.add(map);
        Map tempMap = new HashMap();
        if(result==-1){
            tempMap.put("issuc",false);
        }else{
            tempMap.put("issuc",true);
        }
        return tempMap;
    }

    /**
     * 根据GOODS_ID删除商品信息
     * @param GOODS_ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteRole(@RequestParam Integer GOODS_ID){
        int result = goodsService.delete(GOODS_ID);
        Map tempMap = new HashMap();
        if(result==-1){
            tempMap.put("issuc",false);
        }else{
            tempMap.put("issuc",true);
        }
        return tempMap;
    }

    /**
     * 根据GOODS_ID修改商品信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object updateAccount(@RequestParam Map map){
        //System.out.println("更新传过来的参数："+map);
        Map tempMap = new HashMap();
        int result = goodsService.update(map);
        //System.out.println(result);
        if(result==-1){
            tempMap.put("issuc", false);
        }else{
            tempMap.put("issuc", true);
        }
        return tempMap;
    }


}
