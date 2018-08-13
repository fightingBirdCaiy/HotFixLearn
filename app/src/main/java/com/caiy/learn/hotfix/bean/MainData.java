package com.caiy.learn.hotfix.bean;

/**
 * Created by caiyong on 2018/8/13.
 */

public class MainData {

    private String url;
    private String md5;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "MainData{" +
                "url='" + url + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
