package com.feimang.month.controller;

import com.feimang.month.common.ServerResponse;
import com.feimang.month.service.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluationController {

    @Autowired
    private IEvaluationService evaluationService;

    @GetMapping("/getTestQuestionsRandom/{userId}")
    public ServerResponse getTestQuestionsRandom(@PathVariable("userId")Long userId) {
        return  evaluationService.getTestQuestionsRandom(userId);
    }

    @GetMapping("/getKnowledge/{userId}")
    public ServerResponse getKnowledge(@PathVariable("userId")Long userId) {
        return  evaluationService.getKnowledge(userId);
    }

}
