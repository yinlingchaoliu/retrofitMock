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

//    @MOCK(value = "https://www.baidu.com", enable = true)
    @MOCK("appversion/update.json")
    @GET(Urls.UPDATE_INTERFACENAME)
    Observable<BaseDataBean<IsUpdateBean>> getUpdateInfo();

}