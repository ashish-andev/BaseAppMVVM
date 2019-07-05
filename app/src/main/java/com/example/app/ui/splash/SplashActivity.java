package com.example.app.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.example.app.BR;
import com.example.app.R;
import com.example.app.databinding.ActivitySplashBinding;
import com.example.app.ui.base.BaseBindingActivity;
import com.example.app.ui.dashboard.DashboardActivity;


public class SplashActivity extends BaseBindingActivity<ActivitySplashBinding,
        SplashViewModel> implements SplashNavigator {

    private SplashViewModel mViewModel;
    private ActivitySplashBinding mBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mViewModel = new SplashViewModel();
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
        mViewModel.checkSession();
    }


    @Override
    public void onSession() {
        startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
    }

    @Override
    public void onNoSession() {
        startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
    }
}
