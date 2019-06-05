package com.thevalet.app.utils;

import android.widget.Toast;
import com.thevalet.app.AppController;


public final class Utils {

    private Utils() {
        // This class is not publicly instantiable


    }

    public static void showToast(String message) {
        try {
            Toast.makeText(AppController.getInstance(), message, Toast.LENGTH_LONG).show();
        } catch (Throwable ignored) {
        }
    }

}
