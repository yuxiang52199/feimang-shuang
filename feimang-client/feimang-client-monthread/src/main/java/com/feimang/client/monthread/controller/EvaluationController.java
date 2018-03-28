package com.feimang.client.monthread.controller;

import com.feimang.client.monthread.config.WebSecurityConfig;

import com.feimang.client.monthread.pojo.ResultVo;
import com.feimang.client.monthread.pojo.UserStudy;
import com.feimang.client.monthread.vo.UserStudyVo;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@EnableAutoConfiguration
public class EvaluationController {

    //https://api.douban.com/v2/book/isbn/9787111562429


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    protected WxMpService wxMpService;

    /**
     * 测评首页
     * @return
     */
    @RequestMapping("/")
    public String evaluationIndex(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        WxMpOAuth2AccessToken accessToken;
        WxMpUser wxMpUser;

        String code=request.getParameter("code");
        if(StringUtils.isEmpty(code))
        {
            model.addAttribute("error","请在微信中打开网页");
            return "error";
        }
        try {
            accessToken = this.wxMpService.oauth2getAccessToken(request.getParameter("code"));
            wxMpUser = this.wxMpService.getUserService()
                    .userInfo(accessToken.getOpenId());
            //数据转换器
            ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            //判断用户是否存在
            ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://apis.feimang.com/api/FM_UserStudy/GetUserStudyByWXUserID?thirduserid=oUV0dt8PCHuxyBsAu4lxJKF21NLI&unionid=okR1Lt7znbRHVC9cDl5fIbr7ilBs", String.class);
            UserStudyVo userStudyVo = mapper.readValue(responseEntity.getBody().toString(), UserStudyVo.class);
            String userId=null;
            if(userStudyVo.getUserStudy()==null){
                //如果不存在 去主数据中注册用户信息
                UserStudy userStudy = new UserStudy();
                userStudy.setThirdUserID(wxMpUser.getOpenId());
                userStudy.setUnionID(wxMpUser.getUnionId());
                userStudy.setAccountType(2);
                userStudy.setNickName(wxMpUser.getNickname());
                userStudy.setUserHead(wxMpUser.getHeadImgUrl());
                ResponseEntity<String> responseEntity1= restTemplate.postForEntity("https://apis.feimang.com/api/FM_UserStudy/NewRegUserStudy",userStudy,String.class);
                ResultVo resultVo = mapper.readValue(responseEntity1.getBody().toString(), ResultVo.class);
                if(resultVo.getCode()==10000&&StringUtils.isEmpty(resultVo.getToken())){
                    userId=resultVo.getToken();
                }
            }
            else{
                userId=userStudyVo.getUserStudy().getUserID().toString();
            }
            //将用户信息注册到阅分库

            //保存到session中
            HttpSession session = request.getSession();
            session.setAttribute(WebSecurityConfig.SESSION_KEY,userId);

            return "evaluation/index";

        } catch (WxErrorException e) {

            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }



}
