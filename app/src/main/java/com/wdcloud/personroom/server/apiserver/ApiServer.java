package com.wdcloud.personroom.server.apiserver;


import com.wdcloud.personroom.server.api.ApiUrl;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/**
 * Created by Umbrella on 2018/12/5.
 */

public interface ApiServer {
//普通请求
    @GET(ApiUrl.getAllBooks)
    Observable<String> getAllBooks();
//    上传文件
//    @Multipart
//    @POST(ApiUrl.submitAccessory)
//    Observable<SubmitAccessory> submitAccessory(@PartMap Map<String, RequestBody> params);

}
