package com.wjj.architecture.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.wjj.architecture.entity.Tenant;
import com.wjj.architecture.repository.DataRepository;

import java.util.List;

/**
 * 租户列表
 * Created by wjj on 2017/12/29 16:09.
 */

public class TenantListViewModel extends ViewModel {
    private final MediatorLiveData<List<Tenant>> mObservableTenantList;

    public TenantListViewModel() {
        mObservableTenantList = new MediatorLiveData<>();
        mObservableTenantList.setValue(null);
        //从数据库中拿数据
        LiveData<List<Tenant>> tenantList = DataRepository.getInstance().getTenantList();
        mObservableTenantList.addSource(tenantList, new Observer<List<Tenant>>() {
            @Override
            public void onChanged(@Nullable List<Tenant> tenants) {
                mObservableTenantList.setValue(tenants);
            }
        });
    }

    public LiveData<List<Tenant>> getTenantList() {
        return mObservableTenantList;
    }
}
