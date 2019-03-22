package com.chaoliu.retrofitmock.mock;

import android.util.Log;

public class SayHelloService implements HelloInterface {
    @Override
    public void sayHello() {
        Log.e( "hello", "say" );
    }

    public <T> T create(final Class<T> service) {
        Log.e( "hello", "create" );
        return null;
    }
}
