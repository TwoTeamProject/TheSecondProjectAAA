package com.pro.two.controller.login;

import com.pro.two.service.login.LoginService;
import com.pro.two.service.login.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
@SuppressWarnings("all")
public class LoginController {

    /*依赖注入*/
    @Autowired
    private LoginService loginService;


    /**
     * shiro
     * @param request
     * @param response
     * @param session
     */
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response,HttpSession session){
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
       /* String users=request.getParameter("user");
        System.out.println(users);
        String validateCode = session.getAttribute("validateCode") + "";
        System.out.println(validateCode);
        &&validateCode.equalsIgnoreCase(users)*/
        Subject subject = SecurityUtils.getSubject();
        if(userid!=null&&!"".equals(userid)) {
            UsernamePasswordToken token = new UsernamePasswordToken(userid, password);
            try {
                subject.login(token);
            } catch (Exception e) {
                token.clear();
            }
            try {
                response.sendRedirect("/pro/room/toIndex");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /*跳转登陆*/
    @RequestMapping("toLogin")
    public String userLogin(){
        return "login";
    }

    /*登陆*/
    @RequestMapping("inLogin")
    public String inLogin(@RequestParam Map map, HttpSession session, HttpServletRequest request,HttpServletResponse response){
        List<Map> user = loginService.userLogin(map);
        if(user!=null&&user.size()>0) {
            session.setAttribute("username", map.get("username"));
            session.getAttribute("username");
            /*System.out.println(session.getAttribute("username"));*/
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

    @ResponseBody
    @RequestMapping("welcome")
    public Object welcome(HttpSession session){
        return session.getAttribute("username")+"";
    }

}
