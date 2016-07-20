package com.yifan.greendaodemo.database;

import android.content.Context;

import com.yifan.greendaodemo.DaoApplication;
import com.yifan.greendaodemo.gen.DaoMaster;
import com.yifan.greendaodemo.gen.DaoSession;
import com.yifan.greendaodemo.gen.ProjectsDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

/**
 * DataBase数据库管理工具实例（ GreenDAO ）
 * <p>
 * Created by yifan on 2016/7/19.
 */
public class DataBaseManager {

    public static final String DATABASE_NAME = "dao_db";

    /**
     * 数据库辅助操控实例
     */
    private DaoMaster.OpenHelper mOpenHelper;

    /**
     * SQLHelp以及DAO的管理器实例
     */
    private DaoMaster mDaoMaster;

    /**
     * DAO会话管理实例
     */
    private DaoSession mDaoSession;

    private DataBaseManager() {
        //设置是否可以输出后台数据库日志
        setDebug(true);
        //初始化对象实例
        if (DaoApplication.DEBUG) {
            mOpenHelper = new DaoMaster.DevOpenHelper(DaoApplication.getInstance(), DATABASE_NAME);
        } else {
            mOpenHelper = new GDOpenHelp(DaoApplication.getInstance(), DATABASE_NAME);
        }
        mDaoMaster = new DaoMaster(mOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
    }

    /**
     * 获取数据库管理实例
     *
     * @return
     */
    public static DataBaseManager getInstance() {
        return ManagerInstance.mInstance;
    }

    /**
     * 以内部类实现单例模式
     */
    private static class ManagerInstance {

        public static DataBaseManager mInstance = new DataBaseManager();

    }

    /**
     * 初始化
     */
    public void init() {

    }

    /**
     * 获取Projects表DAO类
     *
     * @return
     */
    public ProjectsDao getProjectsDao() {
        return mDaoSession.getProjectsDao();
    }

    /**
     * 设置是否输出debug日志
     *
     * @param debug
     */
    public void setDebug(boolean debug) {
        QueryBuilder.LOG_SQL = debug;
        QueryBuilder.LOG_VALUES = debug;
    }

    /**
     * 封装数据库OpenHelp，自定义onUpgrade等数据库版本升级函数
     * <p>
     * Created by yifan on 2016/7/20.
     */
    public class GDOpenHelp extends DaoMaster.OpenHelper {

        public GDOpenHelp(Context context, String name) {
            super(context, name);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            super.onUpgrade(db, oldVersion, newVersion);
        }
    }

}
