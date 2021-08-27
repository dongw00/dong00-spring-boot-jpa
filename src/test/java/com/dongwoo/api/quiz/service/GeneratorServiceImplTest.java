package com.dongwoo.api.quiz.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GeneratorServiceImplTest {

    @Mock
    GeneratorServiceImpl generatorService;

    @BeforeEach
    void setUp() {
        generatorService = new GeneratorServiceImpl();
    }

    @DisplayName("Random value test")
    @Test
    void randomFactor() {
        List<Integer> randoms = IntStream.range(0, 1000)
            .map(i -> generatorService.randomFactor())
            .boxed()
            .collect(Collectors.toList());

        assertThat(randoms).containsOnlyElementsOf(IntStream.range(11, 100)
            .boxed()
            .collect(Collectors.toList()));
    }
}