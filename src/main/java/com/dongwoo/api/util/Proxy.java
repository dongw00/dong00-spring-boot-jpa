package com.dongwoo.api.util;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.stereotype.Component;

@Component
public class Proxy {

    public static Consumer<String> print = System.out::print;

    public static Function<Object, String> toString = String::valueOf;
    public static Function<String, Integer> strToInteger = Integer::parseInt;

    public static Function<Integer, Integer> intAbs = Math::abs;
    public static Function<Double, Double> doubleAbs = Math::abs;
    public static Function<Float, Float> floatAbs = Math::abs;
    public static Function<Long, Long> longAbs = Math::abs;
    public static Function<Double, Double> ceil = Math::ceil;
    public static Function<Double, Double> floor = Math::floor;

    public static BiFunction<Integer, Integer, Integer> intMax = Math::max;
    public static BiFunction<Double, Double, Double> doubleMax = Math::max;
    public static BiFunction<Long, Long, Long> longMax = Math::max;
    public static BiFunction<Float, Float, Float> floatMax = Math::max;

    public static BiFunction<Integer, Integer, Integer> intMin = Math::min;
    public static BiFunction<Long, Long, Long> longMin = Math::min;
    public static BiFunction<Double, Double, Double> doubleMin = Math::min;
    public static BiFunction<Float, Float, Float> floatMin = Math::min;

    public static Supplier<Double> randomDouble = Math::random;
    public static BiFunction<Integer, Integer, Integer> rangeRandom = (f, s) ->
        (int) (Math.random() * (s - f)) + f + 1;

    public static Function<Double, Double> rint = Math::rint;
    public static Function<String, Object> intO = Integer::valueOf;
    public static BiPredicate<String, String> equals = String::equals;
    public static BiFunction<Integer, Integer, Integer> randomInteger = (t, u) ->
        (int) (Math.random() * (u - t)) + t;
    public static Function<Integer, int[]> intArr = int[]::new;
    
    public static Supplier<LocalDate> today = LocalDate::now;
    public static Supplier<LocalTime> time = LocalTime::now;

    public static BiFunction<String, String, File> mkDir = File::new;
    public static BiFunction<File, String, File> mkFile = File::new;
}
