package com.chaoliu.mock.core;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author chentong
 * 模拟call方法 不会走真正Okhttp流程
 * @param <T>
 */
final class MockerCall<T> implements Call<T> {

    private T data;

    public MockerCall(T data){
        this.data = data;
    }

    @Override
    public Response<T> execute() throws IOException {
        return Response.success( data );
    }

    @Override
    public void enqueue(Callback<T> callback) {
        callback.onResponse( null, Response.success( data ));
    }

    @Override
    public boolean isExecuted() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public Call<T> clone() {
        return this;
    }

    @Override
    public Request request() {
        return null;
    }
}
