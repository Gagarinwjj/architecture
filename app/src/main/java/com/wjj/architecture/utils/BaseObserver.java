package com.wjj.architecture.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.wjj.architecture.BuildConfig;
import com.wjj.architecture.MyApplication;

import io.reactivex.observers.DisposableObserver;

/**
 * Subscriber的处理封装
 * Created by wjj on 2017/4/7 16:25.
 */

public abstract class BaseObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {
        onNextDo(t);
    }

    @Override
    public void onError(Throwable t) {
        if (Constants.RESPONSE.RE_LOGIN.equalsIgnoreCase(t.getMessage())) {//特殊异常处理
        } else {//普通异常处理
            if (BuildConfig.DEBUG) {
                Toast.makeText(MyApplication.getApplication(), t.getMessage(), Toast
                        .LENGTH_SHORT).show();
                LogUtils.e("ApiError", t.getMessage());
            } /*else {
                String apiErrorMsg = getApiErrorMsg(t);
                if (!TextUtils.isEmpty(apiErrorMsg)) {
                    Toast.makeText(UIUtils.getContext(), apiErrorMsg, Toast.LENGTH_SHORT).show();
                }
            }*/
        }
    }

    public String getApiErrorMsg(Throwable t) {
        String msg = t.getMessage();
        if (!TextUtils.isEmpty(msg) && msg.startsWith(Constants.RESPONSE.API_ERROR)) {
            return msg.substring(Constants.RESPONSE.API_ERROR.length(), msg.length());
        }
        return null;
    }

    @Override
    public void onComplete() {

    }

    public abstract void onNextDo(T t);
}
