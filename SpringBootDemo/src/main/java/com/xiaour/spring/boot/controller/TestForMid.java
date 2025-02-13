package com.xiaour.spring.boot.controller;

import java.util.function.Function;

/**
 * @author rtw
 * @since 2024/12/20
 */
public class TestForMid {
    public static void main(String[] args) {
        // 定义一个Function
        Function<Instance,Integer> function = instanceDto->instanceDto.doing(new String("test"));

        // 找到具体的扩展点实例
        Instance instance = new Instance();

        // 执行，找到的扩展点作为入参
        function.apply(instance);
    }
}
