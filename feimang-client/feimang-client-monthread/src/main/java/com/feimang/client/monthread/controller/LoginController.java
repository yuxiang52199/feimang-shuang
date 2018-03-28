package com.feimang.client.monthread.controller;

import com.feimang.client.monthread.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangds on 2017/10/24.
 */
@Controller
public class LoginController {



    @GetMapping("/logout")
    public String logout(HttpSession session){
       session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
