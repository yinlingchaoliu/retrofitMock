package com.chaoliu.retrofitmock.mock;

import com.chaoliu.mock.annotation.MOCK;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 *
 *
 */
public interface Api {

    @MOCK(value = "https://www.baidu.com", enable = true)
//    @MOCK("appversion/update.json")
    @GET(Urls.UPDATE_INTERFACENAME)
    Observable<BaseDataBean<IsUpdateBean>> getUpdateInfo();
}