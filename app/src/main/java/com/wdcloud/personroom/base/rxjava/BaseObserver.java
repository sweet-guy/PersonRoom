package com.wdcloud.personroom.base.rxjava;

import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Info:
 * Created by Umbrella.
 * CreateTime: 2020/4/14 14:19
 */
public class BaseObserver<T> implements Observer<T> {
    //绑定
    @Override
    public void onSubscribe(Disposable d) {

    }
    //返回数据
    @Override
    public void onNext(T t) {

    }
    //错误
    @Override
    public void onError(Throwable e) {

    }
    //完成
    @Override
    public void onComplete() {

    }
}
