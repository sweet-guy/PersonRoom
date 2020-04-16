package com.wdcloud.personroom.base.mvp;

/**
 * Info:
 * Created by Umbrella.
 * CreateTime: 2020/4/13 16:44
 */
public interface IBasePrensent<T extends BaseView>  {

    /**
     * presenter和对应的view绑定
     *
     * @param mvpView 目标view
     */
    void attachView(T mvpView);

    /**
     * presenter与view解绑
     */
    void detachView();
}
