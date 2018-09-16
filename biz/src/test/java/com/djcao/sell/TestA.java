package com.djcao.sell;

import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Maps;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/12
 */
public class TestA {
    public static void main(String[] args) {
        Random seed = new Random(47);
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        IntStream.generate(() -> (int)(System.nanoTime()%100)).limit(10).forEach(System.out::println);
        Map<String ,String > map = Maps.newHashMap();
        map.put("1","2");
        map.put("3","4");
        //System.out.println(JSON.toJSONString(objects));
    }
}
