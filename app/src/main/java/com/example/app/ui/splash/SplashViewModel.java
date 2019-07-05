package com.example.app.ui.splash;

import com.example.app.ui.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    void checkSession() {
        getNavigator().onSession();
    }

}
