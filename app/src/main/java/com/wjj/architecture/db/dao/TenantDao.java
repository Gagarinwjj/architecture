package com.wjj.architecture.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.wjj.architecture.entity.Tenant;

import java.util.List;

/**
 * TenantDao
 * Created by wjj on 2017/12/29 17:22.
 */
@Dao
public interface TenantDao {
    @Query("select * from Tenant")
    LiveData<List<Tenant>> loadAllTenants();
}
