package com.caiy.learn.hotfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.caiy.learn.hotfix.manager.MainManager;

public class MainActivity extends AppCompatActivity {

    private MainManager mainManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData(){
        mainManager = new MainManager(this);
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