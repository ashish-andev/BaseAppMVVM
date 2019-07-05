package com.example.app.data;


import com.example.app.AppController;
import com.example.app.data.local.db.AppDbHelper;

public class AppDataManager {

    private final AppDbHelper appDbHelper;
    private static AppDataManager appDataManager;

    private AppDataManager() {
        appDbHelper = AppDbHelper.getInstance(AppController.getInstance().getApplicationContext());
    }

    public static AppDataManager getInstance() {
        if (appDataManager == null) {
            appDataManager = new AppDataManager();
        }
        return appDataManager;
    }

}
