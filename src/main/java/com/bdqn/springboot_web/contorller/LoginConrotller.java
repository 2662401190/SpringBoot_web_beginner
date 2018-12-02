package com.bdqn.springboot_web.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 贺威
 * @create 2018-11-29 15:41
 */
@RequestMapping("/user/")
@Controller
public class LoginConrotller {

    /**
     * springBoot 注解 相当于 @RequestMapping(value = "login",method = RequestMethod.POST)
     * @return
     */
    @PostMapping("login")
    public String Login(@RequestParam("username") String userName,
                        @RequestParam("password") String passWord,
                        Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(userName ) &&  "123456".equals(passWord)){

            //登录成功保存用户的值
            session.setAttribute("loginUser", userName);
            //登录成功，防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名密码错误");
            return "login";
        }


    }
}
