package com.feimang.client.monthread.controller;

import com.feimang.client.monthread.VueVo.*;
import com.feimang.client.monthread.common.ServerResponse;
import com.feimang.client.monthread.config.WebSecurityConfig;

import com.feimang.client.monthread.pojo.*;
import com.feimang.client.monthread.service.EvaluationService;
import com.feimang.client.monthread.service.MonthUserService;
import com.feimang.client.monthread.vo.*;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class EvaluationController {

    //https://api.douban.com/v2/book/isbn/9787111562429


    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private WxMpService wxMpService;

    @Autowired
    private MonthUserService monthUserService;

    @Autowired
    private EvaluationService evaluationService;
    /**
     * 测评首页
     * @return
     */
    @RequestMapping("/")
    public String evaluation_index(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

//        WxMpOAuth2AccessToken accessToken;
//        WxMpUser wxMpUser;
//
//        String code=request.getParameter("code");
//        if(StringUtils.isEmpty(code))
//        {
//            model.addAttribute("error","请在微信中打开网页");
//            return "error";
//        }
//        try {
//            accessToken = this.wxMpService.oauth2getAccessToken(request.getParameter("code"));
//            wxMpUser = this.wxMpService.getUserService()
//                    .userInfo(accessToken.getOpenId());
//            //数据转换器
//            ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
//            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            Map<String, String> map = new HashMap<>();
//            map.put("thirduserid", wxMpUser.getOpenId());
//            map.put("unionid", wxMpUser.getUnionId());
//            //判断用户是否存在
//            ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://apis.feimang.com/api/FM_UserStudy/GetUserStudyByWXUserID?thirduserid={thirduserid}&unionid={unionid}", String.class,map);
//            UserStudyVo userStudyVo = mapper.readValue(responseEntity.getBody().toString(), UserStudyVo.class);
//            String userId=null;
//            if(userStudyVo.getUserStudy()==null){
//                //如果不存在 去主数据中注册用户信息
//                UserStudy userStudy = new UserStudy();
//                userStudy.setThirdUserID(wxMpUser.getOpenId());
//                userStudy.setUnionID(wxMpUser.getUnionId());
//                userStudy.setAccountType(2);
//                userStudy.setNickName(wxMpUser.getNickname());
//                userStudy.setUserHead(wxMpUser.getHeadImgUrl());
//                ResponseEntity<String> responseEntity1= restTemplate.postForEntity("https://apis.feimang.com/api/FM_UserStudy/NewRegUserStudy",userStudy,String.class);
//                ResultVo resultVo = mapper.readValue(responseEntity1.getBody().toString(), ResultVo.class);
//                if(resultVo.getCode()==10000&&StringUtils.isEmpty(resultVo.getToken())){
//                    userId=resultVo.getToken();
//                }
//            }
//            else{
//                userId=userStudyVo.getUserStudy().getUserID().toString();
//            }
//            //将用户信息注册到阅分库
//            UserAbstruct userAbstruct = new UserAbstruct();
//            userAbstruct.setNickname(wxMpUser.getNickname());
//            userAbstruct.setUserid(Long.parseLong(userId));
//            userAbstruct.setOpenid(wxMpUser.getOpenId());
//            int status= monthUserService.insertUserRegistration(userAbstruct).getStatus();
//            if(status!=0){
//                return "error";
//            }

            //保存到session中
            HttpSession session = request.getSession();
            //session.setAttribute(WebSecurityConfig.SESSION_KEY,userId);
        session.setAttribute(WebSecurityConfig.SESSION_KEY,234);

            //model.addAttribute("wxMpUser",wxMpUser);
            return "evaluation_index";
//
//        } catch (WxErrorException e) {
//
//            model.addAttribute("error", e.getMessage());
//            return "error";
//        }
    }

    @RequestMapping("/evaluation")
    public String evaluation(Model model, HttpServletRequest request, HttpServletResponse response){
        return "evaluation";
    }

    /**
     * 获取测评试题数据
     * @param request
     * @param response
     * @return  java.lang.String
     */
    @RequestMapping(value = "/getEvaluation",method = RequestMethod.GET)
    @ResponseBody
    public EvaluationListVueVo getEvaluation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String userid=session.getAttribute(WebSecurityConfig.SESSION_KEY).toString();

        List<EvaluationVueVo> list = new ArrayList<>();
        EvaluationVo evaluation= evaluationService.getTestQuestionsRandom(Long.parseLong(userid)).getData();

        //region 转换识字题
        EvaluationVueVo evaluationWord = new EvaluationVueVo();
        evaluationWord.setId(Long.parseLong("0"));
        evaluationWord.setQuid(Long.parseLong("0"));
        evaluationWord.setTit("请选择下面你认识的字");
        evaluationWord.setType(0);
        evaluationWord.setFlag(0);
        List<OptionVueVo> optionWords = new ArrayList<>();
        for (Gbk2312 gbk2312:evaluation.getGbk2312s()) {
            OptionVueVo optionVueVo = new OptionVueVo();
            optionVueVo.setKey(gbk2312.getV());
            optionVueVo.setVal(Integer.parseInt(gbk2312.getId().toString()));
            optionWords.add(optionVueVo);
        }
        evaluationWord.setOption(optionWords);
        list.add(evaluationWord);
        //endregion

        //region 转换问答题

        Integer id=1;
        for (Questions questions :evaluation.getQuestions()){
            EvaluationVueVo evaluationQuestions = new EvaluationVueVo();
            evaluationQuestions.setId(Long.parseLong(id.toString()));
            evaluationQuestions.setQuid(questions.getQuid());
            evaluationQuestions.setType(0);
            evaluationQuestions.setFlag(1);
            evaluationQuestions.setSuid(questions.getSuid());;
            evaluationQuestions.setTit(questions.getQuestions());
            List<OptionVueVo> optionQuestions = new ArrayList<>();
            for(int i=1;i<=6;i++){
                //region 问答题选项
                if(i==1){
                    if(!StringUtils.isEmpty(questions.getOption1())){
                        OptionVueVo option = new OptionVueVo();
                        option.setKey(questions.getOption1());
                        option.setVal(i);
                        optionQuestions.add(option);
                    }

                    continue;
                }
                if(i==2){
                    if(!StringUtils.isEmpty(questions.getOption2())){
                        OptionVueVo option = new OptionVueVo();
                        option.setKey(questions.getOption2());
                        option.setVal(i);
                        optionQuestions.add(option);
                    }

                    continue;
                }
                if(i==3){
                    if(!StringUtils.isEmpty(questions.getOption3())){
                        OptionVueVo option = new OptionVueVo();
                        option.setKey(questions.getOption3());
                        option.setVal(i);
                        optionQuestions.add(option);
                    }

                    continue;
                }
                if(i==4){
                    if(!StringUtils.isEmpty(questions.getOption4())){
                        OptionVueVo option = new OptionVueVo();
                        option.setKey(questions.getOption4());
                        option.setVal(i);
                        optionQuestions.add(option);
                    }

                    continue;
                }
                if(i==5){
                    if(!StringUtils.isEmpty(questions.getOption5())){
                        OptionVueVo option = new OptionVueVo();
                        option.setKey(questions.getOption5());
                        option.setVal(i);
                        optionQuestions.add(option);
                    }

                    continue;
                }
                if(i==6){
                    if(!StringUtils.isEmpty(questions.getOption6())){
                        OptionVueVo option = new OptionVueVo();
                        option.setKey(questions.getOption6());
                        option.setVal(i);
                        optionQuestions.add(option);
                    }

                    continue;
                }
                //endregion
            }
            evaluationQuestions.setOption(optionQuestions);
            list.add(evaluationQuestions);
            id++;
        }
        //endregion
        EvaluationListVueVo evaluationListVueVo=new EvaluationListVueVo();
        evaluationListVueVo.setList(list);
        evaluationListVueVo.setToast(list.size());

        return evaluationListVueVo;
    }

    /**
     * 提交测评结果
     * @param
     * @return  com.feimang.client.monthread.common.ServerResponse
     */
    @RequestMapping(value = "/postAssignment",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse postAssignment(HttpServletRequest request, HttpServletResponse response,@RequestBody List<AnswerVueVo> answerVueVos){
        AssignmentVo assignmentVo = new AssignmentVo();
        List<Gbk2312Vo> gbk2312Vos = new ArrayList<>();
        List<QuestionsVo> questions = new ArrayList<>();
        //循环接受参数

        for (AnswerVueVo item:answerVueVos
             ) {


            //如果id=0  是识字题
            if(item.getQuid()==0){
                for (Integer c:item.getAnswer()
                     ) {
                    Gbk2312Vo gbk2312Vo = new Gbk2312Vo();
                    gbk2312Vo.setId(Long.parseLong(c.toString()));
                    gbk2312Vo.setKnow(true);
                    gbk2312Vos.add(gbk2312Vo);
                }
                continue;
            }
            else {
                QuestionsVo question = new QuestionsVo();
                question.setQuid(item.getQuid());
                String str=null;
                //如果id！=0 问答题
                for (Integer as : item.getAnswer()
                        ) {
                    //region 构建答案
                    if (as == 1) {
                        str = StringUtils.isEmpty(str) ? "A" : str + ",A";
                        continue;
                    }
                    if (as == 2) {
                        str = StringUtils.isEmpty(str) ? "B" : str + ",B";
                        continue;
                    }
                    if (as == 3) {
                        str = StringUtils.isEmpty(str) ? "C" : str + ",C";
                        continue;
                    }
                    if (as == 4) {
                        str = StringUtils.isEmpty(str) ? "D" : str + ",D";
                        continue;
                    }
                    if (as == 5) {
                        str = StringUtils.isEmpty(str) ? "E" : str + ",E";
                        continue;
                    }
                    if (as == 6) {
                        str = StringUtils.isEmpty(str) ? "F" : str + ",F";
                        continue;
                    }
                    //endregion
                }
                question.setAnswer(str);
                questions.add(question);
            }
        }
        HttpSession session = request.getSession();
        String userid=session.getAttribute(WebSecurityConfig.SESSION_KEY).toString();

        assignmentVo.setUserId(Long.parseLong(userid));
        assignmentVo.setSuid(answerVueVos.get(1).getSuid());
        assignmentVo.setGbk2312Vos(gbk2312Vos);
        assignmentVo.setQuestionsVos(questions);

        return evaluationService.postAssignment(assignmentVo);
    }

    /**
     * 进入到测评结果页
     * @param model
     * @param request
     * @param response
     * @return  java.lang.String
     */
    @RequestMapping(value = "/evaluation_result")
    public String evaluation_result(Model model, HttpServletRequest request, HttpServletResponse response){

        return "evaluation_result";
    }
    /**
     * 获取测评结果数据
     * @param request
     * @param response
     * @return  java.lang.String
     */
    @RequestMapping(value = "/getEvaluationResult",method = RequestMethod.GET)
    @ResponseBody
    public   EvaluationResultListVueVo  getEvaluationResult(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        String userid=session.getAttribute(WebSecurityConfig.SESSION_KEY).toString();

        List<UserKlStruct> userKlStructs = evaluationService.getKnowledge(Long.parseLong(userid)).getData();
        List<EvaluationResultVueVo> list = new ArrayList<>();
        EvaluationResultListVueVo evaluationResultListVueVo = new EvaluationResultListVueVo();
        for (UserKlStruct userKlStruct: userKlStructs
             ) {
            EvaluationResultVueVo evaluationResultVueVo = new EvaluationResultVueVo();
            evaluationResultVueVo.setName(userKlStruct.getKnowledge_type().getkType());
            evaluationResultVueVo.setVal(userKlStruct.getScore());
            list.add(evaluationResultVueVo);
        }
        evaluationResultListVueVo.setList(list);
        return evaluationResultListVueVo;
    }







}
