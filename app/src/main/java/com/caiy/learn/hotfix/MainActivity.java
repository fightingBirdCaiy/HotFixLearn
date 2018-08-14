package com.caiy.learn.hotfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.caiy.learn.hotfix.bean.MainData;
import com.caiy.learn.hotfix.manager.MainManager;
import com.caiy.learn.hotfix.util.MainUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private MainManager mainManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData(){
        mainManager = new MainManager(this);
        mainManager.init();
        MainData mainData = new MainData();
        mainData.setUrl("hotfix://mainData");
        mainData.setMd5("nothing");
        mainManager.initWithMainData(mainData,"mainDataMessage");
        int screenWidth = MainUtil.getScreenWidth(this);
        Log.i(TAG,String.format("screenWidth=%d",screenWidth));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
