package com.feimang.client.monthread.service;

import com.feimang.client.monthread.common.ServerResponse;
import com.feimang.client.monthread.pojo.UserKlStruct;
import com.feimang.client.monthread.vo.AssignmentVo;
import com.feimang.client.monthread.vo.EvaluationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("eureka-month-server")
public interface EvaluationService {
    @GetMapping("/getTestQuestionsRandom/{userId}")
    ServerResponse<EvaluationVo> getTestQuestionsRandom(@PathVariable("userId")Long userId);
    @PostMapping("/postAssignment")
    ServerResponse postAssignment(@RequestBody AssignmentVo assignmentVo);
    @GetMapping("/getKnowledge/{userId}")
    ServerResponse<List<UserKlStruct>> getKnowledge(@PathVariable("userId")Long userId);

}
