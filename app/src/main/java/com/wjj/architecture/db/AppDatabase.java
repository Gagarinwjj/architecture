package com.wjj.architecture.db;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.wjj.architecture.MyApplication;
import com.wjj.architecture.db.dao.TenantDao;

/**
 * App的全局数据库
 * Created by wjj on 2017/12/29 11:16.
 */

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase mInstance;
    private static String DATABASE_NAME = "basic-db";
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance() {
        if (mInstance == null) {
            synchronized (AppDatabase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(
                            MyApplication.getApplication(),
                            AppDatabase.class, DATABASE_NAME)
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    //模拟数据初始化
                                }
                            }).build();
                    if (MyApplication.getApplication().getDatabasePath(DATABASE_NAME).exists()) {
                        mInstance.setDatabaseCreated();
                    }
                }
            }

        }
        return mInstance;
    }

    public MutableLiveData<Boolean> isDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    private void setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true);
    }

    public abstract TenantDao tenantDao();
}
