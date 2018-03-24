package com.feimang.month.service.impl;

import com.feimang.month.common.Const;
import com.feimang.month.common.ResponseCode;
import com.feimang.month.common.ServerResponse;
import com.feimang.month.dao.*;
import com.feimang.month.pojo.*;
import com.feimang.month.service.IEvaluationService;
import com.feimang.month.vo.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("evaluationService")
public class EvaluationServiceImpl implements IEvaluationService {

    //region 成员变量
    @Autowired
    private Gbk2312Mapper gbk2312Mapper;

    @Autowired
    private QuestionsSuiteMapper questionsSuiteMapper;

    @Autowired
    private QuestionsMapper questionsMapper;

    @Autowired
    private UserQuestionsMapper userQuestionsMapper;

    @Autowired
    private UserAnswerMapper userAnswerMapper;

    @Autowired
    private UserKlStructMapper userKlStructMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private UserKlMapper userKlMapper;

    @Autowired
    private UserAbstructMapper userAbstructMapper;

    @Autowired
    private UserTagMapper userTagMapper;

    //endregion

    //region 测评部分
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
    @Transactional
    public ServerResponse postAssignment(Long userId,AssignmentVo assignmentVo){
        if(assignmentVo == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        /**
         * 判断集合是否为空：CollectionUtils.isEmpty
         */
        if(CollectionUtils.isEmpty(assignmentVo.getGbk2312Vos())||CollectionUtils.isEmpty(assignmentVo.getQuestionsVos())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        /**
         *  正确答案存入：27个问题中正确的==》userAnswer
         *  把正确的答案在那个每个维度的最大值存入==》userKlStruct
         *  记录用户答过某套题==》userQuestions
         */
        List<UserAnswer> userAnswers=new ArrayList<>();
        UserAnswer userAnswer = new UserAnswer();
        List<UserKlStruct> userKlStructs = new ArrayList<>();
        UserQuestions userQuestions = new UserQuestions();
        userQuestions.setUserid(userId);
        userQuestions.setSuid(assignmentVo.getSuid());
        /**
         * 插入记录用户答过某题的记录==》问题，我看到了有当前时间这个字段，没有这个字段插入，如何放？？？插入的返回值？是代表‘插入是否失败’：uqid是插入的id号？
         */
        int uqid=userQuestionsMapper.insertSelective(userQuestions);

        if(uqid<=0){
            return ServerResponse.createByErrorMessage("答题失败!");
        }

        /**
         * CollectionUtils.select：提取集合中字段；返回后台的文字都是认识的，则需要一个过程，知道有几个就可以了
         */
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

        //获取对应题库：某套题
        List<Questions> questions = questionsMapper.selectListBySuid(assignmentVo.getSuid());
        /**
         * QuestionsVo：题号和回答。实体对象遍历集合。因为对CollectionUtils.select不熟，大概理解que：用户答案；tempQue：标准答案
         *  关于return 是根据 用户答题的id 和 正确的答案中问题id 一样 且答案一样的时候  ==》 返回数据
         *  当有返回值的时候，说明用户回答正确：则把本题相对应的维度给用户赋值
         *  关于赋值规则：当本题的某个维度大于用户此维度，则把题的维度赋值给用户
         */
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
                /**
                 * 这里应该有关于有正确答案的整条数据插入==》useranswer
                 */
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

        //获取最新一次的测评
        UserQuestions userQuestions= userQuestionsMapper.selectLastByUserID(userId);

        if(userQuestions==null||userQuestions.getUqid()==null||userQuestions.getUqid()==0){
            return  ServerResponse.createByErrorMessage("请该用户先参加测评!");
        }

        //获取本次测评对应的结果
        List<UserKlStruct> userKlStructs = userKlStructMapper.selectListByUQid(userQuestions.getUqid());
        return ServerResponse.createBySuccess(userKlStructs);
    }

    //endregion

    //region 生成计划方向

    /**
     * 根据生成计划方向表选 选出标签
     * @param userId
     * @param flg
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse getTagByKlFlg(Long userId,Integer flg){

        if(userId == null||flg==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //获取最新一次的测评
        UserQuestions userQuestions= userQuestionsMapper.selectLastByUserID(userId);

        if(userQuestions==null||userQuestions.getUqid()==null||userQuestions.getUqid()==0){
            return  ServerResponse.createByErrorMessage("请该用户先参加测评!");
        }
        //获取本次测评对应的结果
        List<UserKlStruct> userKlStructs = userKlStructMapper.selectListByUQid(userQuestions.getUqid());
        //按得分排序
        Collections.sort(userKlStructs, new Comparator<UserKlStruct>() {
            @Override
            public int compare(UserKlStruct o1, UserKlStruct o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        });

        //取长
        if(flg== Const.KLFlg.KL_LENGTH.getCode()){
            //获取前三个维度
            List<UserKlStruct> tempList=userKlStructs.subList(0,3);
            for (UserKlStruct struct:tempList
                 ) {
                List<Tag> tags=tagMapper.selectListByPrimaryKlid(struct.getKlid());
                struct.getKnowledge_type().setTags(tags);

            }
            return ServerResponse.createBySuccess(tempList);
        }
        //补短
        if(flg== Const.KLFlg.KL_SHORT.getCode()){
            //获取后三个维度
            List<UserKlStruct> tempList=userKlStructs.subList(7,9);
            for (UserKlStruct struct:tempList
                    ) {
                List<Tag> tags=tagMapper.selectListByPrimaryKlid(struct.getKlid());
                struct.getKnowledge_type().setTags(tags);

            }
            return ServerResponse.createBySuccess(tempList);
        }
        //自定义
        if(flg== Const.KLFlg.KL_CUSTOM.getCode()){
            //获取所有维度
            for (UserKlStruct struct:userKlStructs
                    ) {
                List<Tag> tags=tagMapper.selectListByPrimaryKlid(struct.getKlid());
                struct.getKnowledge_type().setTags(tags);

            }
            return ServerResponse.createBySuccess(userKlStructs);
        }
        return ServerResponse.createByErrorMessage("获取失败!");
    }


    /**
     * 提交生成计划方向
     * @param klResultVo
     * @return  com.feimang.month.common.ServerResponse
     */
    @Transactional
    public ServerResponse postKlResult(Long userId,KlResultVo klResultVo){

        if(klResultVo==null||klResultVo.getUserAbstruct()==null||klResultVo.getUserKl()==null||CollectionUtils.isEmpty(klResultVo.getUserTags()) ){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //修改用户信息
        userAbstructMapper.updateByPrimaryKeySelective(klResultVo.getUserAbstruct());

        //设置选择计划方向
        UserKl userKl=userKlMapper.selectByPrimaryKey(userId);
        if(userKl==null){
            userKlMapper.insertSelective(klResultVo.getUserKl());
        }
        else {
            userKlMapper.updateByPrimaryKeySelective(klResultVo.getUserKl());
        }
        //设置标签
        //删除历史选择
        userTagMapper.deleteByUserId(userId);
        //插入新选择的标签
        userTagMapper.insertUserTagBatch(klResultVo.getUserTags());

        return ServerResponse.createBySuccessMessage("提交成功！");
    }

    //endregion

}
