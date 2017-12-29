package com.wjj.architecture;

import android.app.Application;

/**
 * application
 * Created by wjj on 2017/12/29 16:49.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    public static MyApplication getApplication() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

}
