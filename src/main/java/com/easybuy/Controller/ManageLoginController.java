package com.easybuy.Controller;

import com.easybuy.Dao.TManageMapper;
import com.easybuy.Services.ManageLoginServices;
import com.easybuy.entity.TManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ManageLoginController {
    @Autowired
    private ManageLoginServices mls;
    @RequestMapping("/managelogin")
    public String login(String userName, String passWord, HttpSession session){
        TManage tm=mls.LoginManage(userName,passWord);
        System.out.println("controller "+tm);
        if(tm!=null){
            session.setAttribute("user",tm.getName());
            return "manage/login-result";
        }
        else
            return "manage/login-fail";
    }
}
