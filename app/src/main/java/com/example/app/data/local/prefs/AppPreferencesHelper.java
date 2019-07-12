package com.example.app.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferencesHelper {
    private static final String PREF_NAME = "valet_pref";

    private static final String PREF_KEY_EMAIL = "email";
    private static AppPreferencesHelper appPrefHelper;
    private final SharedPreferences mPrefs;

    private AppPreferencesHelper(Context context) {
        mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static AppPreferencesHelper getInstance(Context context) {
        if (appPrefHelper == null) {
            appPrefHelper = new AppPreferencesHelper(context);
        }
        return appPrefHelper;
    }


    public String getEmail() {
        return mPrefs.getString(PREF_KEY_EMAIL, null);
    }


    public void setEmail(String email) {
        mPrefs.edit().putString(PREF_KEY_EMAIL, email).apply();
    }

}