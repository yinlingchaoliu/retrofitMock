package com.chaoliu.mock.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Proxy;

import retrofit2.Retrofit;

/**
 * RetrofitMock AOP注解实现
 *
 * @author chentong
 * @date 2019/3/22
 */
@Aspect
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

    @Around("execution(* retrofit2.Retrofit.create(..))")
    public Object aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {

//        Log.e( TAG, "我终于hook了retrofit" );

        if (!isEnabled()) {
            return joinPoint.proceed();//执行原方法
        }

        Object[] parameterValues = joinPoint.getArgs();

        Retrofit retrofit = (Retrofit) joinPoint.getThis();

        Class service = (Class) parameterValues[0];

        Object api = joinPoint.proceed();

        return Proxy.newProxyInstance( service.getClassLoader(), new Class<?>[]{service}, new MockerHandler( retrofit, api ) );
    }
}

//        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
//        Class<?> cls = codeSignature.getDeclaringType();
//        String methodName = codeSignature.getName();
//        String[] parameterNames = codeSignature.getParameterNames();
