package com.gary.garyrpc.example;

/**
 * @Classname CalcServiceImpl
 * @Description
 * @Date 2023/2/26 9:24 PM
 * @Author Gary An
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
