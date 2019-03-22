package com.chaoliu.retrofitmock.mock;

import android.content.Context;

import com.google.gson.Gson;
import com.readystatesoftware.chuck.ChuckInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtil {

    public static Retrofit getRetrofit(Context context){

        OkHttpClient client=  new OkHttpClient.Builder()
                .addInterceptor( new ChuckInterceptor( context ) )
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl( UrlConstants.BASE_URL)
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create( new Gson()))
                .client(client)
                .build();

        return retrofit;
    }
}
