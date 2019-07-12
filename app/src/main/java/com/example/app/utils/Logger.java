package com.example.app.utils;

import android.util.Log;

import com.example.app.BuildConfig;


public class Logger {

    public static void log(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, message);
        }
    }

    public static void i(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message);
        }
    }
}
