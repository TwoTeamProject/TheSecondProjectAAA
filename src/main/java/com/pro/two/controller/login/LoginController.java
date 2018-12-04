package com.pro.two.controller.login;

import com.pro.two.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:LoginController
 * discription:
 * author:sjq
 * createTime:2018-11-22 09:48
 */
@RequestMapping("login")
@Controller
public class LoginController {

    /*依赖注入*/
    @Autowired
    private LoginService loginService;

    /*跳转登陆*/
    @RequestMapping("toLogin")
    public String userLogin(){
        return "login";
    }

    /*登陆*/
    @RequestMapping("inLogin")
    public String inLogin(@RequestParam Map map, HttpSession session){
        List<Map> user = loginService.userLogin(map);
        if(user!=null&&user.size()>0) {
            session.setAttribute("username", map.get("username"));
            return "index";
        }else {
            return "login";
        }
    }

    /**
     * 跳转界面
     * @return
     */
    @RequestMapping("toInterface")
    public String toInterface(){
        return "interface";
    }
}
