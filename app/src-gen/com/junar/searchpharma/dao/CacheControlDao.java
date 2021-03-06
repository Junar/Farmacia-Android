package com.junar.searchpharma.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.junar.searchpharma.CacheControl;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * DAO for table CACHE_CONTROL.
 */
public class CacheControlDao extends AbstractDao<CacheControl, Long> {

    public static final String TABLENAME = "CACHE_CONTROL";

    /**
     * Properties of entity CacheControl.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id",
                true, "_id");
        public final static Property LastUpdate = new Property(1,
                java.util.Date.class, "lastUpdate", false, "LAST_UPDATE");
    };

    public CacheControlDao(DaoConfig config) {
        super(config);
    }

    public CacheControlDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'CACHE_CONTROL' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'LAST_UPDATE' INTEGER);"); // 1: lastUpdate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "")
                + "'CACHE_CONTROL'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, CacheControl entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        java.util.Date lastUpdate = entity.getLastUpdate();
        if (lastUpdate != null) {
            stmt.bindLong(2, lastUpdate.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /** @inheritdoc */
    @Override
    public CacheControl readEntity(Cursor cursor, int offset) {
        CacheControl entity = new CacheControl( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : new java.util.Date(
                        cursor.getLong(offset + 1)) // lastUpdate
        );
        return entity;
    }

    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, CacheControl entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor
                .getLong(offset + 0));
        entity.setLastUpdate(cursor.isNull(offset + 1) ? null
                : new java.util.Date(cursor.getLong(offset + 1)));
    }

    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(CacheControl entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /** @inheritdoc */
    @Override
    public Long getKey(CacheControl entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

}
