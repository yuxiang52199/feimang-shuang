package com.feimang.month.controller;

import com.feimang.month.common.ServerResponse;
import com.feimang.month.pojo.UserAbstruct;
import com.feimang.month.pojo.UserKlStruct;
import com.feimang.month.service.IEvaluationService;
import com.feimang.month.vo.AssignmentVo;
import com.feimang.month.vo.EvaluationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationController {

    @Autowired
    private IEvaluationService evaluationService;




    @GetMapping("/getTestQuestionsRandom/{userId}")
    public ServerResponse<EvaluationVo> getTestQuestionsRandom(@PathVariable("userId")Long userId) {
        return  evaluationService.getTestQuestionsRandom(userId);
    }
    @PostMapping("/postAssignment")
    ServerResponse postAssignment(@RequestBody  AssignmentVo assignmentVo){
        return evaluationService.postAssignment(assignmentVo);
    }

    @GetMapping("/getKnowledge/{userId}")
    public ServerResponse<List<UserKlStruct>> getKnowledge(@PathVariable("userId")Long userId) {
        return  evaluationService.getKnowledge(userId);
    }






}
