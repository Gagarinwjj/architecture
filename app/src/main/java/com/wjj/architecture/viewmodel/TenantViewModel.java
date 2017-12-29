package com.wjj.architecture.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.wjj.architecture.entity.Tenant;

/**
 * 租户
 * Created by wjj on 2017/12/28 20:36.
 */

public class TenantViewModel extends ViewModel {
    private String tenantId;
    private LiveData<Tenant> tenant;

    public LiveData<Tenant> getTenant() {
        return tenant;
    }

    public void setTenant(LiveData<Tenant> tenant) {
        this.tenant = tenant;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
