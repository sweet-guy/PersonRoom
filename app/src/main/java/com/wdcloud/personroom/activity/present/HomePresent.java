package com.wdcloud.personroom.activity.present;

import android.util.Log;

import com.wdcloud.personroom.activity.model.HomeModel;
import com.wdcloud.personroom.activity.view.view.HomeView;
import com.wdcloud.personroom.base.mvp.BasePrensent;
import com.wdcloud.personroom.base.rxjava.BaseObserver;
import com.wdcloud.personroom.server.RxSchedulerHepler;
import com.wdcloud.personroom.server.api.ApiUrl;
import com.wdcloud.personroom.server.apiserver.ApiServer;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static com.wdcloud.personroom.server.interceptor.HttpFactor.getApiService;

/**
 * Info:
 * Created by Umbrella.
 * CreateTime: 2020/4/13 14:30
 */
public class HomePresent extends BasePrensent<HomeView> implements HomeModel {
    private HomeView homeView;
    @Override
    public void initData() {
        homeView = getMvpView();
    }
    @Override
    public void getUser(String userName, String PassWord) {
        ApiServer apiService = getApiService(ApiUrl.BaseUrl);
        //方法一:
        apiService.getAllBooks().compose(RxSchedulerHepler.<String>io_main()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                addSubScription(d);
            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        //方法二： 自定义Baseobserver
//        apiService.getAllBooks().compose((RxSchedulerHepler.<String>io_main()))
//                .subscribe(new BaseObserver<String>(){
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        super.onSubscribe(d);
//                        addSubScription(d);
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        super.onNext(s);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//
//                    }
//                });
        homeView.HomeSuccess("");
    }

    @Override
    public void SubmitFile(LinkedHashMap<String, String> filemap) {
        Map<String,RequestBody> submitMap = new HashMap<>();
        for (String fileName : filemap.keySet()) {
            String filePath = filemap.get(fileName);
            File file = new File(filePath);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            submitMap.put("file\"; filename=\""+fileName,requestBody);
        }

    }
}
