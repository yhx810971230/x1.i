package com.fotile.message.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.fotile.message.bean.MemorandumDb;
import com.fotile.message.bean.NotificationDb;

import com.fotile.message.greendao.MemorandumDbDao;
import com.fotile.message.greendao.NotificationDbDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig memorandumDbDaoConfig;
    private final DaoConfig notificationDbDaoConfig;

    private final MemorandumDbDao memorandumDbDao;
    private final NotificationDbDao notificationDbDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        memorandumDbDaoConfig = daoConfigMap.get(MemorandumDbDao.class).clone();
        memorandumDbDaoConfig.initIdentityScope(type);

        notificationDbDaoConfig = daoConfigMap.get(NotificationDbDao.class).clone();
        notificationDbDaoConfig.initIdentityScope(type);

        memorandumDbDao = new MemorandumDbDao(memorandumDbDaoConfig, this);
        notificationDbDao = new NotificationDbDao(notificationDbDaoConfig, this);

        registerDao(MemorandumDb.class, memorandumDbDao);
        registerDao(NotificationDb.class, notificationDbDao);
    }
    
    public void clear() {
        memorandumDbDaoConfig.clearIdentityScope();
        notificationDbDaoConfig.clearIdentityScope();
    }

    public MemorandumDbDao getMemorandumDbDao() {
        return memorandumDbDao;
    }

    public NotificationDbDao getNotificationDbDao() {
        return notificationDbDao;
    }

}
