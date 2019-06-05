package com.thevalet.app;

import android.app.Application;

public class AppController extends Application {


    private static AppController mInstance;

    public static AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
