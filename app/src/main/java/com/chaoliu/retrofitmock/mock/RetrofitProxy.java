package com.chaoliu.retrofitmock.mock;

import android.support.annotation.Nullable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * retrofit代理
 */
public class RetrofitProxy {

    public static <T> T create(final Class<T> service) {
        ClassLoader classLoader = service.getClassLoader();

        InvocationHandler invocationHandler = new InvocationHandler() {
            private final Object[] emptyArgs = new Object[0];

            @Override
            public Object invoke(Object proxy, Method method, @Nullable Object[] args)
                    throws Throwable {

                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke( this, args );
                }

//              return loadServiceMethod(method).invoke(args != null ? args : emptyArgs);
                return null;
            }
        };

        return (T) Proxy.newProxyInstance( service.getClassLoader(), new Class<?>[]{service}, invocationHandler );
    }

}
