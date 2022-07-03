package com.easybuy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/topagelogin")
    public String login(){
        return "login";
    }
    @RequestMapping("/shopping")
    public String shopping(){
        return "shopping";
    }
    @RequestMapping("/guestbook")
    public String guestbook(){
        return "guestbook";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/chatroom")
    public String chatroom(){
        return "chat-room";
    }
}

