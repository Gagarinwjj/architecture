package com.wjj.architecture.utils;


import android.text.TextUtils;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.wjj.architecture.BuildConfig;
import com.wjj.architecture.MyApplication;
import com.wjj.architecture.entity.Wrapper;
import com.wjj.architecture.entity.WrapperFun;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 服务器接口帮助类
 */
public class ServiceHelper {

    private static ServiceHelper mInstance;
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    private static HashMap<String, Retrofit> retrofitHashMap;//动态Retrofit缓存

    private ServiceHelper() {
        int cacheSize = 40 * 1024 * 1024; // 40 MiB
        File file = new File(MyApplication.getApplication().getCacheDir(), "responseCache");
        Cache responseCache = new Cache(file, cacheSize);

        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("deviceType", "1")//1代表android，2代表ios
                        .build();
                return chain.proceed(newRequest);
            }
        };


        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(new LoggingInterceptor.Builder()
                        .loggable(BuildConfig.DEBUG)
                        .setLevel(Level.BASIC)
                        .log(Platform.INFO)
                        .request("RetrofitRequest")
                        .response("RetrofitResponse")
                        .addHeader("RetrofitHeader", BuildConfig.VERSION_NAME)
                        .build())
                .addNetworkInterceptor(new StethoInterceptor())
                .cache(responseCache)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        okHttpClient = builder.build();
        retrofit = new Retrofit.Builder().client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.URL.BASE_URL)
                .build();
        retrofitHashMap = new HashMap<>(4);
    }


    public static ServiceHelper getInstance() {
        if (mInstance == null) {
            synchronized (ServiceHelper.class) {
                if (mInstance == null) {
                    mInstance = new ServiceHelper();
                }
            }
        }
        return mInstance;
    }

    /**
     * 根据泛型返回服务BaseUrl实例
     *
     * @param service 服务类
     * @param <T>     服务泛型
     * @return 服务实例
     */
    public <T> T getService(Class<T> service) {
        return retrofit.create(service);
    }

    /**
     * 根据泛型返回dynamicBaseUrl实例
     *
     * @param dynamicBaseUrl 动态根域名
     * @param service        服务类
     * @param <T>            服务泛型
     * @return 服务实例
     */
    public <T> T getService(String dynamicBaseUrl, Class<T> service) {
        String key = MD5.hexDigest(dynamicBaseUrl);
        Retrofit retrofit = retrofitHashMap.get(key);
        if (retrofit == null) {//新建并缓存
            retrofit = new Retrofit.Builder().client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(dynamicBaseUrl)
                    .build();
            retrofitHashMap.put(key, retrofit);
        }
        return retrofit.create(service);
    }


    public <T> void makeObjectRequest(Observable<T> observable, BaseObserver<T>
            observer) {
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable)
                            throws Exception {

                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }


    public <T> void makeRequest(Observable<Wrapper<T>> observable, BaseObserver<T>
            observer) {
        observable//可以结合compose封装
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable)
                            throws Exception {

                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程
                .observeOn(AndroidSchedulers.mainThread())
                .map(new WrapperFun<T>())
                .subscribeWith(observer);
    }


    /**
     * @return object解析为model实体
     */
    public <T> T getModelFromObj(Object object, Class<T> clazz) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(object);
        if (!TextUtils.isEmpty(jsonStr) && !"{}".equals(jsonStr)) {
            try {
                return gson.fromJson(jsonStr, clazz);
            } catch (JsonSyntaxException e) {
                return null;
            }
        }
        return null;
    }

}
