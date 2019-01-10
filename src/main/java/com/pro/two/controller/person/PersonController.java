package com.pro.two.controller.person;

import com.pro.two.Entity.User;
import com.pro.two.service.person.PersonService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:PersonController
 * discription:
 * author:sjq
 * createTime:2018-11-28 16:58
 */
@Controller
@RequestMapping("person")
public class PersonController {

    //依赖注入
    @Autowired
    private PersonService personService;

    /**
     * 员工列表跳转
     * @return
     */
    @RequestMapping("toList")
    public Object toList(){
        return "person/person-list";
    }

    /**
     * 员工列表跳转
     * @return
     */
    /*@RequestMapping("toList2")
    public Object toList2(){
        return "person/person-messages";
    }*/

    /**
     * 员工列表
     * @return
     */
    /*@ResponseBody
    @RequestMapping("list")
    public Object personList(Map map){
        *//*Map map1 = new HashMap();
        map1.put("list",personService.personList(map));
        map1.put("count",personService.personCount());*//*
        *//*System.out.println(personService.personList(map));*//*
        return personService.personList(map);
    }*/
    /**
     * 跳转员工列表
     * @return
     */
    @RequestMapping("toListDemo")
    public Object demo(){
        return "person/list";
    }

    /**
     * 员工列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/listDemo")
    public Object personListDemo(@RequestBody Map map){
       /* System.out.println(personService.personListDemo(map));*/
        Map map1 = new HashMap();
        map1.put("data",personService.personListDemo(map));
        map1.put("total",personService.getPageCount(map));
        return map1;
    }

    /**
     * 员工添加
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public Object add(@RequestBody Map map){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date user_create_date = sdf.parse(map.get("CREATE_DATE")+"");
            map.put("CREATE_DATE",user_create_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(map);
        return personService.add(map);
    }

    /**
     * 员工更新
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public Object update(@RequestBody Map map){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date user_create_date = sdf.parse(map.get("CREATE_DATE")+"");
            map.put("CREATE_DATE",user_create_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return personService.update(map);
    }

    /**
     * 删除
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/del/{user_id}")
    public Object del(@PathVariable Integer user_id){
        return personService.delete(user_id);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/batchDel/{ids}")
    public Object batchDel(@PathVariable String ids){
        return personService.batchDelete(ids);
    }

    /**
     * 查询职位
     * @return
     */
    @ResponseBody
    @RequestMapping("role")
    public Object role(){
        return personService.role();
    }

    /**
     * 跳转个人信息
     * @return
     */
    @RequestMapping("topersonInfo")
    public Object topersonalInfo(){
        return "person/personInfo";
    }

    /**
     * 更新密码
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("updatePassWord")
    public Object updatePassWord(@RequestParam Map map){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String userId = user.getUserId()+"";
        map.put("userId",userId);
        return personService.updatePassWord(map);
    }
}
