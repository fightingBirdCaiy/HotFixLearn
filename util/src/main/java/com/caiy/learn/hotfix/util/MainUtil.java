package com.caiy.learn.hotfix.util;

import android.content.Context;

/**
 * Created by caiyong on 2018/8/14.
 */

public class MainUtil {

    public static int getDate(long time) {
        return (int)time;
    }

    public static String getDateTime(long time) {
        return time + "";
    }

    public static int getScreenWidth(Context context) {
        return 1920;
    }

    public static int getScreenHeight(Context context) {
        return 1080;
    }
}
