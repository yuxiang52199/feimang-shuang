package com.feimang.month.service;

import com.feimang.month.common.ServerResponse;
import com.feimang.month.pojo.UserKlStruct;
import com.feimang.month.vo.AssignmentVo;
import com.feimang.month.vo.EvaluationVo;

import java.util.List;

public interface IEvaluationService {
    ServerResponse<EvaluationVo> getTestQuestionsRandom(Long userId);

    ServerResponse postAssignment(AssignmentVo assignmentVo);

    ServerResponse<List<UserKlStruct>> getKnowledge(Long userId);
}
