package com.dongwoo.api.quiz.service;

import com.dongwoo.api.quiz.domain.Factor;
import java.util.Random;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Override
    public int randomFactor() {
        Function<String, Integer> function = Integer::parseInt;

        return new Random().nextInt(function.apply(Factor.MAXIMUM.toString())
            - function.apply(Factor.MINIMUM.toString()) + 1)
            + function.apply(Factor.MINIMUM.toString());
    }
}
