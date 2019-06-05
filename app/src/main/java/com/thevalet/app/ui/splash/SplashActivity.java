package com.thevalet.app.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.thevalet.app.BR;
import com.thevalet.app.R;
import com.thevalet.app.databinding.ActivitySplashBinding;
import com.thevalet.app.ui.base.BaseBindingActivity;
import com.thevalet.app.ui.dashboard.DashboardActivity;


public class SplashActivity extends BaseBindingActivity<ActivitySplashBinding,
        SplashViewModel> implements SplashNavigator {

    private SplashViewModel mViewModel;
    private ActivitySplashBinding mBinding;
    private LocationAdapter adapter;

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
        setUpRecyclerView();
        mViewModel.getLocations();
    }

    private void setUpRecyclerView() {
        adapter = new LocationAdapter(SplashActivity.this);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(SplashActivity.this));
        mBinding.recyclerView.setAdapter(adapter);
    }


    @Override
    public void onSubmit() {
        Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
        intent.putExtra("location", adapter.getSelectedLocation().name);
        startActivity(intent);
    }
}
