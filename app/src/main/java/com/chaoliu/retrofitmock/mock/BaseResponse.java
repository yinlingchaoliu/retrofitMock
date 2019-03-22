package com.chaoliu.retrofitmock.mock;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    public static final int RESPONSE_SUCCESS_CODE = 200;

    public int code;
    public String msg;
    public T data;

    //判断业务是否成功
    public boolean isSuccessful(){
        return code == RESPONSE_SUCCESS_CODE;
    }

}
