package com.chaoliu.retrofitmock.mock;

import com.chaoliu.mock.annotation.MOCK;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * MOCK 有两种写法
 * mock http地址
 * mock 本地json数据
 */
public interface Api {

    @MOCK(value = "appversion/update.json",enable = true)
    @GET(Urls.UPDATE_INTERFACENAME)
    Observable<BaseDataBean<IsUpdateBean>> getUpdateInfo();

    @MOCK(value = "https://www.baidu.com", enable = false)
    @GET(Urls.UPDATE_INTERFACENAME)
    Observable<BaseDataBean<IsUpdateBean>> getUpdateInfo2();
}