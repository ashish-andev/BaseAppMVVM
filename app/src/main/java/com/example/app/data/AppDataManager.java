package com.example.app.data;


import com.example.app.AppController;
import com.example.app.data.local.db.AppDbHelper;
import com.example.app.data.local.prefs.AppPreferencesHelper;
import com.example.app.data.model.Repository;
import com.example.app.data.remote.ApiClient;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;

public class AppDataManager {

    private final AppDbHelper appDbHelper;
    private final AppPreferencesHelper appPrefHelper;
    private static AppDataManager appDataManager;

    private AppDataManager() {
        appDbHelper = AppDbHelper.getInstance(AppController.getInstance().getApplicationContext());
        appPrefHelper = AppPreferencesHelper.getInstance(AppController.getInstance().getApplicationContext());
    }

    public static AppDataManager getInstance() {
        if (appDataManager == null) {
            appDataManager = new AppDataManager();
        }
        return appDataManager;
    }

    public Single<List<Repository>> getRepositories() {
        return ApiClient.getApiService().getRepositories();
    }
}
