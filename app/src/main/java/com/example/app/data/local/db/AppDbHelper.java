package com.example.app.data.local.db;

import android.content.Context;

public class AppDbHelper {

    private static AppDbHelper appDbHelper;


    private AppDbHelper(Context context) {
        /*this.mAppDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "med_ecom")
                .fallbackToDestructiveMigration()
                .build();*/
    }

    public static AppDbHelper getInstance(Context context) {
        if (appDbHelper == null) {
            appDbHelper = new AppDbHelper(context);
        }
        return appDbHelper;
    }
    
}
