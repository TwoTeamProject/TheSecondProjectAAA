package com.pro.two.controller.goods;

import com.pro.two.service.Goods.InStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * className:InStorageController
 * discription:
 * author:Ryb
 * createTime:2018-12-06 21:26
 */
@RequestMapping("/inStorage")
@Controller
public class InStorageController {

    @Autowired
    private InStorageService inStorageService;

    /**
     * 入库，添加商品数量等信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object addStorage(@RequestParam Map map){

        return inStorageService.addStorage(map);
    }
}
