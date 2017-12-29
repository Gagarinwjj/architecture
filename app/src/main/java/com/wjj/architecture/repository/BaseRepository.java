package com.wjj.architecture.repository;

import com.wjj.architecture.db.AppDatabase;
import com.wjj.architecture.utils.ServiceHelper;
import com.wjj.architecture.webapi.TenantApi;

/**
 * 数据仓库基类
 * Created by wjj on 2017/12/29 16:39.
 */

public class BaseRepository {
    private static AppDatabase baseAppDatabase = AppDatabase.getInstance();
    private static TenantApi baseTenantApi = ServiceHelper.getInstance().getService(TenantApi
            .class);
}
