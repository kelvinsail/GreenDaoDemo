package com.yifan.greendaodemo.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.yifan.greendaodemo.entity.Projects;

import com.yifan.greendaodemo.gen.ProjectsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig projectsDaoConfig;

    private final ProjectsDao projectsDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        projectsDaoConfig = daoConfigMap.get(ProjectsDao.class).clone();
        projectsDaoConfig.initIdentityScope(type);

        projectsDao = new ProjectsDao(projectsDaoConfig, this);

        registerDao(Projects.class, projectsDao);
    }
    
    public void clear() {
        projectsDaoConfig.getIdentityScope().clear();
    }

    public ProjectsDao getProjectsDao() {
        return projectsDao;
    }

}