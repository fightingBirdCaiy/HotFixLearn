package com.caiy.learn.hotfix.manager;

import android.content.Context;
import android.util.Log;

import com.caiy.learn.hotfix.bean.MainData;

/**
 * Created by caiyong on 2018/8/13.
 */

public class MainManager {

    private static final String TAG = "MainManager";

    private Context mContext;

    public MainManager(Context context){
        mContext = context;
    }

    public void init(){
        Log.i(TAG,"init");
    }

    public void initWithMainData(MainData mainData){
        Log.i(TAG,"init:" + mainData);
    }
}
