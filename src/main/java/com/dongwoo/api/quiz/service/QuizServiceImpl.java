package com.dongwoo.api.quiz.service;

import com.dongwoo.api.quiz.domain.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final GeneratorService generatorService;

    @Override
    public Quiz createQuiz() {
        return new Quiz(generatorService.randomFactor(), generatorService.randomFactor());
    }
}
