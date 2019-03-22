package com.chaoliu.retrofitmock.mock;

import java.io.Serializable;

/**
 * @author lixuebo
 * @time 2018/1/31.
 */

public class BaseDataBean<T> implements Serializable {

    public static final int RESPONSE_SUCCESS_CODE = 200;
    public int code;
    public String msg;
    public T data;

    //判断业务是否成功
    public boolean isSuccessful(){
        return code == RESPONSE_SUCCESS_CODE;
    }

}
