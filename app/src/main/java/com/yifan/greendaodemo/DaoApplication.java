package com.yifan.greendaodemo;

import android.app.Application;

import com.yifan.greendaodemo.database.DataBaseManager;

/**
 * Created by yifan on 2016/7/19.
 */
public class DaoApplication extends Application {

    public static DaoApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        DataBaseManager.getInstance();
    }

    public static DaoApplication getInstance() {
        return mInstance;
    }
}
