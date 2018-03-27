package com.feimang.client.monthread.controller;

import com.feimang.client.monthread.config.WechatMpConfiguration;
//import com.feimang.client.monthread.config.WechatMpProperties;
import com.feimang.client.monthread.config.WechatMpProperties;
import me.chanjar.weixin.common.exception.WxErrorException;
//import me.chanjar.weixin.cp.api.WxCpService;
//import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class pageController {
   // @Autowired
   // protected WxMpConfigStorage configStorage;
    @Autowired
    protected WxMpService wxMpService;

    @Autowired
    protected WechatMpProperties wechatMpProperties;



    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String page(){

        System.out.println(wechatMpProperties.toString());

        return "system/index";
    }


    /**
     * 跳转
     * @return
     */
    @RequestMapping("/redirect")
    public String page2(){
        return "redirect/redirect";
    }


    /**
     *视图
     * @param model
     * @return
     */
    @RequestMapping("/model")
    public String page3(Model model){

        model.addAttribute("name","seawater");

        return "hello";
    }
    /**
     * 通过code获得基本用户信息
     * 详情请见: http://mp.weixin.qq.com/wiki/14/bb5031008f1494a59c6f71fa0f319c66.html
     *
     */
    @RequestMapping(value = "getOAuth2UserInfo")
    public String getOAuth2UserInfo(Model model,HttpServletRequest request, HttpServletResponse response) {


        WxMpOAuth2AccessToken accessToken;
        WxMpUser wxMpUser;

        try {

           // model.addAttribute("openid",properties.getAppId());

            //wxMpService.setWxMpConfigStorage(wechatMpConfiguration.configStorage());
            model.addAttribute("code",request.getParameter("code"));
            accessToken = this.wxMpService.oauth2getAccessToken(request.getParameter("code"));


            wxMpUser = this.wxMpService.getUserService()
                    .userInfo(accessToken.getOpenId());
            model.addAttribute("wxMpUser",wxMpUser);

            return "hello";

        } catch (WxErrorException e) {

            model.addAttribute("error",e.getMessage());
            return "error";
        }

    }
}
