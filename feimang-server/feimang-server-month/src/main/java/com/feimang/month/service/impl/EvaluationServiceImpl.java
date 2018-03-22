package com.feimang.month.service.impl;

import com.feimang.month.common.ResponseCode;
import com.feimang.month.common.ServerResponse;
import com.feimang.month.dao.*;
import com.feimang.month.pojo.*;
import com.feimang.month.service.IEvaluationService;
import com.feimang.month.vo.AssignmentVo;
import com.feimang.month.vo.EvaluationVo;
import com.feimang.month.vo.Gbk2312Vo;
import com.feimang.month.vo.QuestionsVo;
import com.mysql.fabric.Server;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.Region;
import java.security.AuthProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("evaluationService")
public class EvaluationServiceImpl implements IEvaluationService {

//    @Autowired
//    public Knowledge_TypeMapper knowledge_typeMapper;

    @Autowired
    public Gbk2312Mapper gbk2312Mapper;

    @Autowired
    public QuestionsSuiteMapper questionsSuiteMapper;

    @Autowired
    public QuestionsMapper questionsMapper;

    @Autowired
    public UserQuestionsMapper userQuestionsMapper;

    @Autowired
    public UserAnswerMapper userAnswerMapper;

    @Autowired
    public UserKlStructMapper userKlStructMapper;


    /**
     * 随机获取一套试题
     * @param userId
     * @return  void
     */
    public ServerResponse getTestQuestionsRandom(Long userId){

        if(userId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //获取字库
        List<Gbk2312> gbk2312s=gbk2312Mapper.getGbk2312ListRandom();

        //随机获取一套题
        QuestionsSuite suite=questionsSuiteMapper.getQuestionsSuiteRandom(userId);

        //获取对应题库
        List<Questions> questions = questionsMapper.selectListBySuid(suite.getSuid());

        EvaluationVo evaluationVo = new EvaluationVo();
        evaluationVo.setGbk2312s(gbk2312s);
        evaluationVo.setQuestions(questions);
        evaluationVo.setSuid(suite.getSuid());

        return ServerResponse.createBySuccess(evaluationVo);
    }

    /**
     * 提交试卷
     * @param assignmentVo
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse postAssignment(Long userId,AssignmentVo assignmentVo){
        if(assignmentVo == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        if(CollectionUtils.isEmpty(assignmentVo.getGbk2312Vos())||CollectionUtils.isEmpty(assignmentVo.getQuestionsVos())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<UserAnswer> userAnswers=new ArrayList<>();
        UserAnswer userAnswer = new UserAnswer();
        List<UserKlStruct> userKlStructs = new ArrayList<>();
        UserQuestions userQuestions = new UserQuestions();
        userQuestions.setUserid(userId);
        userQuestions.setSuid(assignmentVo.getSuid());

        int uqid=userQuestionsMapper.insertSelective(userQuestions);

        if(uqid<=0){
            return ServerResponse.createByErrorMessage("答题失败!");
        }

        //region 认字题
        //获取认字题答对数量
        int gbk2312VoCount=((List<Gbk2312Vo>)CollectionUtils.select(assignmentVo.getGbk2312Vos(), new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                Gbk2312Vo gbk2312Vo=(Gbk2312Vo) object;
                return gbk2312Vo.isKnow();
            }
        })).size();
        //获取识字量
        int chineseCount=gbk2312VoCount*375;
        //总识字量大于4600 则每个知识维度得分25分
        if(chineseCount>=4600){
            //region 赋值
            userAnswer.setkType1(25);
            userAnswer.setkType2(25);
            userAnswer.setkType3(25);
            userAnswer.setkType4(25);
            userAnswer.setkType5(25);
            userAnswer.setkType6(25);
            userAnswer.setkType7(25);
            userAnswer.setkType8(25);
            userAnswer.setkType9(25);
            userAnswer.setkType10(25);
            //endregion
        }
        //endregion

        //region 选择题

        //获取对应题库
        List<Questions> questions = questionsMapper.selectListBySuid(assignmentVo.getSuid());

        for (QuestionsVo que:assignmentVo.getQuestionsVos()) {

            List<Questions> tempQuestions= (List<Questions>)CollectionUtils.select(questions, new Predicate() {
                @Override
                public boolean evaluate(Object object) {
                    Questions tempQue=(Questions) object;
                    return que.getQuid()==tempQue.getQuid()&&que.getAnswer()==tempQue.getAnswer();
                }
            });
            if (!CollectionUtils.isEmpty(tempQuestions)){

                //region 赋值
                if(tempQuestions.get(0).getkType1()>userAnswer.getkType1()){
                    userAnswer.setkType1(tempQuestions.get(0).getkType1());
                }
                if(tempQuestions.get(0).getkType2()>userAnswer.getkType2()){
                    userAnswer.setkType2(tempQuestions.get(0).getkType2());
                }
                if(tempQuestions.get(0).getkType3()>userAnswer.getkType3()){
                    userAnswer.setkType3(tempQuestions.get(0).getkType3());
                }
                if(tempQuestions.get(0).getkType4()>userAnswer.getkType4()){
                    userAnswer.setkType4(tempQuestions.get(0).getkType4());
                }
                if(tempQuestions.get(0).getkType5()>userAnswer.getkType5()){
                    userAnswer.setkType5(tempQuestions.get(0).getkType5());
                }
                if(tempQuestions.get(0).getkType6()>userAnswer.getkType6()){
                    userAnswer.setkType6(tempQuestions.get(0).getkType6());
                }
                if(tempQuestions.get(0).getkType7()>userAnswer.getkType7()){
                    userAnswer.setkType7(tempQuestions.get(0).getkType7());
                }
                if(tempQuestions.get(0).getkType8()>userAnswer.getkType8()){
                    userAnswer.setkType8(tempQuestions.get(0).getkType8());
                }
                if(tempQuestions.get(0).getkType9()>userAnswer.getkType9()){
                    userAnswer.setkType9(tempQuestions.get(0).getkType9());
                }
                if(tempQuestions.get(0).getkType10()>userAnswer.getkType10()){
                    userAnswer.setkType10(tempQuestions.get(0).getkType10());
                }
                //endregion
            }

        }


        //endregion


        for(int i=1;i<=10;i++){
            UserKlStruct userKlStruct = new UserKlStruct();
            userKlStruct.setKlid(i);
            userKlStruct.setUserid(userId);
            userKlStruct.setUqid(uqid);

            //region 赋值
            if(i==1){
                userKlStruct.setScore(userAnswer.getkType1());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==2){
                userKlStruct.setScore(userAnswer.getkType2());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==3){
                userKlStruct.setScore(userAnswer.getkType3());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==4){
                userKlStruct.setScore(userAnswer.getkType4());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==5){
                userKlStruct.setScore(userAnswer.getkType5());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==6){
                userKlStruct.setScore(userAnswer.getkType6());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==7){
                userKlStruct.setScore(userAnswer.getkType7());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==8){
                userKlStruct.setScore(userAnswer.getkType8());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==9){
                userKlStruct.setScore(userAnswer.getkType9());
                userKlStructs.add(userKlStruct);
                continue;
            }
            if(i==10){
                userKlStruct.setScore(userAnswer.getkType10());
                userKlStructs.add(userKlStruct);
                continue;
            }
            //endregion
        }

        //批量插入
        userKlStructMapper.insertUserKlStructBatch(userKlStructs);

        return  ServerResponse.createBySuccessMessage("提交成功");
    }

    /**
     * 获取我的知识结构
     * @param userId
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse getKnowledge(Long userId){
        if(userId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<UserKlStruct> userKlStructs = userKlStructMapper.selectListByUserId(userId);

        return ServerResponse.createBySuccess(userKlStructs);
    }

}
