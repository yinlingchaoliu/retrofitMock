package com.chaoliu.mock.core;

/**
 * RetrofitMock AOP注解实现
 *
 * @author chentong
 * @date 18/3/29
 */
public class RetrofitMock {

    private String TAG = "RetrofitMock";

    /**
     * retrofit mock开关
     */
    private static volatile boolean enabled = true;

    private static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean enabled) {
        RetrofitMock.enabled = enabled;
    }
}