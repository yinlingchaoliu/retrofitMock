# retrofit-mock
#### 前言
retrofit作为网络核心框架，作为基础库，

针对retrofit有很多定制，并不会有很多机会

显式封装调用，所以开发一款无入侵式mock工具。

支持http mock

支持本地assets mock

http mock适配retrofit2.5.0版本（因retrofit重构，重写了反射） 

##### 1、引用retrofit-mock库

* 1、用法

```
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
```
如上两种用法

enable 是当前接口是否mock的开关

为了便于易用
```
//RetrofitMock 是mock的所有接口的总开关
        RetrofitMock.setEnabled( true ); 
//针对于debugRelease
```

* 2、mock的依赖
```
dependencies{
    debugImplementation 'com.github.yinlingchaoliu:retrofit-mock:1.0.1'
    releaseImplementation 'com.github.yinlingchaoliu:retrofit-mock-no-op:1.0.1'
}
```

```
allprojects {
    repositories {
        maven { url 'https://www.jitpack.io' }
    }
}
```

* 2、引用aop插件
```
//引入插件
buildscript {
    dependencies {
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.4'
    }
}
添加对应依赖
apply plugin: 'android-aspectjx'
```

增加混淆
```
####retrofit-mock
-keep class retrofit2.** {*;}
-keep class com.chaoliu.mock.** {*;}
```

3、特别优化
一般生产发版需求，
1、不需要mock
2、不希望修改代码
3、不希望mock反射降低效率
4、不希望引入不需要的库

可以关闭aop，引入生产库即可

```
//引入生产库
 releaseImplementation 'com.github.yinlingchaoliu:retrofit-mock-no-op:1.0.1'

aspectjx {
    enabled false
}
```

#### 文本代码
https://github.com/yinlingchaoliu/retrofitMock

#### 特别感谢
https://www.jianshu.com/p/ef445d5e9be0
