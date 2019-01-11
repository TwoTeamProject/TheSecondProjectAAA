package com.pro.two.controller.member;

import com.pro.two.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:MemberController
 * discription:
 * author:赵一凡
 * createTime:2018-11-23 10:16
 */

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 挑战之房间选择
     * @return
     */
    @RequestMapping("/toChoose")
    public String toTest(){
        return "member/member-roomchoose";
    }

    /**
     * 跳转至订单信息
     * @return
     */
    @RequestMapping("/toOrder")
    public String toOrder(){
        return "member/member-Order";
    }

    /**
     * 跳转至登陆
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "member/member-login";
    }

    /**
     * 跳转至注册
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "member/member-register";
    }

    /**
     * 跳转至主界面
     * @return
     */
    @RequestMapping("/toSub")
    public String toMain(){
        return "member/member-submission";
    }

    /**
     * 会员注册
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/Login")
    public Object memberLogin(@RequestParam Map map ){
        List<Map> resultMap = memberService.memberLogin(map);
        return resultMap;
    }

    /**
     * 会员注册
     * @param map
     * @return
     */
    @RequestMapping("/Register")
    public String memberRegister(@RequestParam Map map, HttpSession session){
        int result = memberService.memberRegister(map);
        if (result==-1){
            session.setAttribute("issuc",false);
            return "member/member-register";
        }else{
            session.setAttribute("issuc",true);
            return "member/member-login";
        }
    }

    /**
     * 获取会员信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMemberMsg")
    public Object getMemberMsg(@RequestParam Map map){
        Object msg = memberService.getMemberMsg(map);
        return msg;
    }

    /**
     * 获取订单信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getOrderMsg")
    public Object getOrderMsg(@RequestParam Map map){
        Object msg = memberService.getOrderMsg(map);
        return msg;
    }

    /**
     * 取消订单
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteOrder")
    public Object deleteOrder(@RequestParam  Map map){
        System.out.println(map);
        Map rst = new HashMap();
        rst.put("rst",memberService.deleteOrder(map));
        System.out.println(rst);
        return rst;
    }

    /**
     * 获取房间类型
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRoomType")
    public Object getRoomType(@RequestParam Map map){
        Object obj = memberService.getRoomType(map);
        return obj;
    }


    /**
     * 提交订单
     * @param map
     * @return
     */
    @RequestMapping("/submitOrder")
    public String submitOrder(@RequestParam  Map map){
        memberService.submitOrder(map);
        return "member/member-order";
    }
}
