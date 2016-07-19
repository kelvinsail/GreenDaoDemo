package com.yifan.greendaodemo.database;

import com.yifan.greendaodemo.DaoApplication;
import com.yifan.greendaodemo.gen.DaoMaster;
import com.yifan.greendaodemo.gen.DaoSession;
import com.yifan.greendaodemo.gen.ProjectsDao;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * DataBase数据库管理工具实例（ GreenDAO ）
 * <p/>
 * Created by yifan on 2016/7/19.
 */
public class DataBaseManager {

    private DaoMaster.DevOpenHelper mDevOpenHelper;

    private DaoMaster mDaoMaster;

    private DaoSession mDaoSession;

    private DataBaseManager() {
        setDebug(true);
        mDevOpenHelper = new DaoMaster.DevOpenHelper(DaoApplication.getInstance(), "dao_db", null);
        mDaoMaster = new DaoMaster(mDevOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
    }

    public static DataBaseManager getInstance() {
        return ManagerInstance.mInstance;
    }

    private static class ManagerInstance {

        public static DataBaseManager mInstance = new DataBaseManager();

    }

    public ProjectsDao getProjectsDao() {
        return mDaoSession.getProjectsDao();
    }

    public void setDebug(boolean debug) {
        QueryBuilder.LOG_SQL = debug;
        QueryBuilder.LOG_VALUES = debug;
    }

}
