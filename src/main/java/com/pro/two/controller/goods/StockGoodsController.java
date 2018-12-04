package com.pro.two.controller.goods;

import com.pro.two.service.Goods.StockGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * className:StockGoodsController
 * discription:
 * author:Ryb
 * createTime:2018-11-29 21:27
 */
@RequestMapping("/stockGoods")
@Controller
public class StockGoodsController {

    @Autowired
    private StockGoodsService stockGoodsService;

    /**
     * 获取缺货物品列表
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object getList(@RequestParam Map map){
        List<Map> list = stockGoodsService.getList(map);
        //System.out.println(list);
        return list;
    }

    /**
     * 获取供应商姓名
     * @return
     */
    @RequestMapping("/Supp")
    @ResponseBody
    public Object getSupp(){
        return stockGoodsService.getSupp();
    }

    /**
     * 跳转方法
     * @return
     */
    @RequestMapping("/toStock")
    public String toStock(){
        return "all-goods/stockGoods";
    }

    /**
     * 生成缺货单
     * @return
     */
    @ResponseBody
    @RequestMapping("/getStock")
    public Object getStock(@RequestParam Map map){
        //System.out.println(map.get("hhh")+"---"+map.get("GOODS_ID")+"----"+map.get("GOODS_NAME"));
        //System.out.println(map.get("SUPP_NAME"));
        return stockGoodsService.addStock(map);
    }

}
