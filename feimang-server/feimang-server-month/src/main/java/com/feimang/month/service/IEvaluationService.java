package com.feimang.month.service;

import com.feimang.month.common.ServerResponse;

public interface IEvaluationService {
    ServerResponse getTestQuestionsRandom(Long userId);

    ServerResponse getKnowledge(Long userId);
}
