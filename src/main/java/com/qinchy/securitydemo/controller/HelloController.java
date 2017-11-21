package com.qinchy.securitydemo.controller;

import com.qinchy.securitydemo.model.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(path = {"/index","/"})
    public String index(Model model){
        Msg msg = new Msg("测试标题","测试内容","额外信息");
        model.addAttribute("msg",msg);
        return "index";
    }

    @RequestMapping(path = {"/login"})
    public String login(Model model){
        return "login";
    }
}
