package com.caiy.learn.hotfix;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.caiy.learn.hotfix.bean.MainData;
import com.caiy.learn.hotfix.manager.MainManager;
import com.caiy.learn.hotfix.util.MainUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private MainManager mainManager;

    private Button mGenerateFileButton;
    private Button mGetFileButton;
    private Button mDeleteFileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        mGenerateFileButton = findViewById(R.id.btn_generate_file);
        mGenerateFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File patchDir = getPatchDirectory(MainActivity.this);
                if(!patchDir.exists()){
                    patchDir.mkdirs();
                }
//                Log.i(TAG,String.format("patchDir=%s",patchDir.getAbsolutePath()));
                File patchFile = getPatchFile(MainActivity.this,"123");
                writeStringToFile(patchFile,"test123456");
                Log.i(TAG,String.format("patchFile %s created",patchFile.getAbsolutePath()));
            }
        });
        mGetFileButton = findViewById(R.id.btn_get_file);
        mGetFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File patchDir = getPatchDirectory(MainActivity.this);
                if(patchDir.exists()){
                    String[] files = patchDir.list();
                    if(files.length > 0){
                    for(int i=0;i<files.length;i++){
                        Log.i(TAG,String.format("i=%d,file=%s",i,files[i]));
                    }}else{
                        Log.i(TAG,"empty");
                    }

                }
            }
        });
        mDeleteFileButton = findViewById(R.id.btn_delete_file);
        mDeleteFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File patchFile = getPatchFile(MainActivity.this,"123");
                if(patchFile != null && patchFile.isFile()){
                    String filePath = patchFile.getAbsolutePath();
                    boolean success = patchFile.delete();
                    Log.i(TAG, String.format("delete %b,filePath=%s",success,filePath));
                }
            }
        });
    }

    private void writeStringToFile(File patchFile, String content) {
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(patchFile);
            fos.write(content.getBytes());
            fos.flush();
        }catch(Exception e){
            e.printStackTrace();
            Log.e(TAG,"writeStringToFile error",e);
        }finally {
            if(fos != null){
                try {
                    fos.close();
                    fos = null;
                } catch (IOException e) {
                    Log.e(TAG,"fos.close error",e);
                    e.printStackTrace();
                }
            }
        }
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

    /**
     * 获取patch文件保存路径
     *
     * @param context
     * @return
     */
    public static File getPatchFile(Context context, String patchId) {
        File patchFile = new File(getPatchDirectory(context), patchId + ".apk");
        return patchFile;
    }

    /**
     * patch所在文件夹
     * @param context
     * @return
     */
    public static File getPatchDirectory(Context context){
        return context.getDir("patch",Context.MODE_PRIVATE);
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
