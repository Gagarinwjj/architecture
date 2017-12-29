package com.wjj.architecture.webapi;

import com.wjj.architecture.entity.Tenant;
import com.wjj.architecture.entity.Wrapper;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 租户网络接口
 * Created by wjj on 2017/12/29 10:59.
 */

public interface TenantApi {
    //租户列表
    @GET("v3/tenantList")
    Observable<Wrapper<List<Tenant>>> getTenant(
            @Query("tenantId") String tenantId);
}
