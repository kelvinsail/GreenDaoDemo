package com.yifan.greendaodemo;

import android.app.Application;

import com.yifan.greendaodemo.database.DataBaseManager;

/**
 * Created by yifan on 2016/7/19.
 */
public class DaoApplication extends Application {

    /**
     * 全局单例模式
     */
    private static DaoApplication mInstance;

    /**
     * 是否为开发调试状态
     */
    public static final boolean DEBUG = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        //初始化数据库管理
        DataBaseManager.getInstance().init();
    }

    public static DaoApplication getInstance() {
        return mInstance;
    }
}
