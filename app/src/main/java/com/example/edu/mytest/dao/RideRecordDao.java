package com.example.edu.mytest.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RIDE_RECORD".
*/
public class RideRecordDao extends AbstractDao<RideRecord, Long> {

    public static final String TABLENAME = "RIDE_RECORD";

    /**
     * Properties of entity RideRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Bike_id = new Property(1, Integer.class, "bike_id", false, "BIKE_ID");
        public final static Property Start_at = new Property(2, java.util.Date.class, "start_at", false, "START_AT");
        public final static Property End_at = new Property(3, java.util.Date.class, "end_at", false, "END_AT");
        public final static Property Is_pay = new Property(4, Boolean.class, "is_pay", false, "IS_PAY");
        public final static Property Money = new Property(5, Integer.class, "money", false, "MONEY");
    }


    public RideRecordDao(DaoConfig config) {
        super(config);
    }
    
    public RideRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RIDE_RECORD\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"BIKE_ID\" INTEGER," + // 1: bike_id
                "\"START_AT\" INTEGER," + // 2: start_at
                "\"END_AT\" INTEGER," + // 3: end_at
                "\"IS_PAY\" INTEGER," + // 4: is_pay
                "\"MONEY\" INTEGER);"); // 5: money
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RIDE_RECORD\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RideRecord entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer bike_id = entity.getBike_id();
        if (bike_id != null) {
            stmt.bindLong(2, bike_id);
        }
 
        java.util.Date start_at = entity.getStart_at();
        if (start_at != null) {
            stmt.bindLong(3, start_at.getTime());
        }
 
        java.util.Date end_at = entity.getEnd_at();
        if (end_at != null) {
            stmt.bindLong(4, end_at.getTime());
        }
 
        Boolean is_pay = entity.getIs_pay();
        if (is_pay != null) {
            stmt.bindLong(5, is_pay ? 1L: 0L);
        }
 
        Integer money = entity.getMoney();
        if (money != null) {
            stmt.bindLong(6, money);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RideRecord entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer bike_id = entity.getBike_id();
        if (bike_id != null) {
            stmt.bindLong(2, bike_id);
        }
 
        java.util.Date start_at = entity.getStart_at();
        if (start_at != null) {
            stmt.bindLong(3, start_at.getTime());
        }
 
        java.util.Date end_at = entity.getEnd_at();
        if (end_at != null) {
            stmt.bindLong(4, end_at.getTime());
        }
 
        Boolean is_pay = entity.getIs_pay();
        if (is_pay != null) {
            stmt.bindLong(5, is_pay ? 1L: 0L);
        }
 
        Integer money = entity.getMoney();
        if (money != null) {
            stmt.bindLong(6, money);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public RideRecord readEntity(Cursor cursor, int offset) {
        RideRecord entity = new RideRecord( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // bike_id
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // start_at
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // end_at
            cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0, // is_pay
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5) // money
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RideRecord entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBike_id(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setStart_at(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setEnd_at(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setIs_pay(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
        entity.setMoney(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RideRecord entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RideRecord entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RideRecord entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
