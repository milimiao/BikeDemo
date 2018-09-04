package com.example.edu.mytest.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.edu.mytest.dao.RideRecord;

import com.example.edu.mytest.dao.RideRecordDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig rideRecordDaoConfig;

    private final RideRecordDao rideRecordDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        rideRecordDaoConfig = daoConfigMap.get(RideRecordDao.class).clone();
        rideRecordDaoConfig.initIdentityScope(type);

        rideRecordDao = new RideRecordDao(rideRecordDaoConfig, this);

        registerDao(RideRecord.class, rideRecordDao);
    }
    
    public void clear() {
        rideRecordDaoConfig.clearIdentityScope();
    }

    public RideRecordDao getRideRecordDao() {
        return rideRecordDao;
    }

}
