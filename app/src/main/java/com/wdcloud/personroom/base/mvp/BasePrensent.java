package com.wdcloud.personroom.base.mvp;

import org.reactivestreams.Subscriber;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Info:
 * Created by Umbrella.
 * CreateTime: 2020/4/13 14:07
 */
public class BasePrensent<T extends BaseView> implements IBasePrensent<T>{
    private T mvpView;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    public void attachView(T mvpView) {
        this.mvpView = mvpView;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        mvpView=null;
        onUnsubscribe();
    }
    /**
     * 判断 view是否为空
     *
     * @return
     */
    public boolean isAttachView() {
        return mvpView != null;
    }

    /**
     * 返回目标view
     *
     * @return
     */
    public T getMvpView() {
        return mvpView;
    }

    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttach() {
        if (!isAttachView()) {
            throw new MvpViewNotAttachedException();
        }
    }
    public Map<String, Object> getMapParameter() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }
    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (compositeDisposable != null && compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
    //添加
    public <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
        Disposable subscribe = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<? super T>) subscriber);
        compositeDisposable.add(subscribe);
    }
    /**
     * 添加注册
     */
    public void addSubScription(Disposable disposable)
    {
        compositeDisposable.add(disposable);
    }
    /**
     * 自定义异常
     */
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("请求数据前请先调用 attachView(MvpView) 方法与View建立连接");
        }
    }
}
