package com.wdcloud.personroom.activity.model;

import com.wdcloud.personroom.base.mvp.BaseModel;

import java.util.LinkedHashMap;

/**
 * Info:
 * Created by Umbrella.
 * CreateTime: 2020/4/13 14:59
 */
public interface HomeModel extends BaseModel {
    void getUser(String userName,String PassWord);
    void SubmitFile(LinkedHashMap<String,String> filemap);
}
