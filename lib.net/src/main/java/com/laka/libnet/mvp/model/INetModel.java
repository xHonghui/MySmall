package com.laka.libnet.mvp.model;


import com.laka.libnet.rx.callback.ResponseCallBack;
import com.trello.rxlifecycle2.LifecycleProvider;

import io.reactivex.Observable;

/**
 * @Author:summer
 * @Date:2019/7/19
 * @Description:针对网络数据层进行最基本的封装接口
 * @CallSuper:注解，标注后子类重写该方法必须调用父类的实现
 */
public interface INetModel<R> extends LifecycleProvider<R> {
    /**
     * 普通网络请求方法
     */
    <T> void doBaseRequest(Observable<T> observable, ResponseCallBack<T> callBack);

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}