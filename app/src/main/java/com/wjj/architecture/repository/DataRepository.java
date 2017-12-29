package com.wjj.architecture.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.wjj.architecture.db.AppDatabase;
import com.wjj.architecture.entity.Tenant;

import java.util.List;

/**
 * 共享数据的 单例数据仓库
 * Created by wjj on 2017/12/29 11:07.
 */

public class DataRepository {
    private static DataRepository mInstance;
    private AppDatabase mAppDatabase;
    private MediatorLiveData<List<Tenant>> mObservableTenantList;

    private DataRepository() {
        mAppDatabase = AppDatabase.getInstance();
        mObservableTenantList = new MediatorLiveData<>();
        mObservableTenantList.addSource(mAppDatabase.tenantDao().loadAllTenants(), new
                Observer<List<Tenant>>() {
                    @Override
                    public void onChanged(@Nullable List<Tenant> tenants) {
                        if (mAppDatabase.isDatabaseCreated().getValue() != null) {
                            mObservableTenantList.postValue(tenants);
                        }
                    }
                });
    }

    public static DataRepository getInstance() {
        if (mInstance == null) {
            synchronized (DataRepository.class) {
                if (mInstance == null) {
                    mInstance = new DataRepository();
                }
            }
        }
        return mInstance;
    }

    public LiveData<List<Tenant>> getTenantList() {
        return mObservableTenantList;
    }
}
