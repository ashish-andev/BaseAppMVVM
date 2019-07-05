package com.example.app.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.app.BR;
import com.example.app.R;
import com.example.app.databinding.ActivityDashboardBinding;
import com.example.app.ui.base.BaseBindingActivity;
import com.example.app.ui.dashboard.tab2.Tab2Fragment;
import com.example.app.ui.dashboard.tab1.Tab1Fragment;
import com.example.app.ui.dashboard.tab3.Tab3Fragment;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends BaseBindingActivity<ActivityDashboardBinding,
        DashboardViewModel> implements DashboardNavigator {

    private DashboardViewModel mViewModel;
    private ActivityDashboardBinding mBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @Override
    public DashboardViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mViewModel = new DashboardViewModel();
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        mViewModel.setNavigator(this);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), getString(R.string.tab1));
        adapter.addFragment(new Tab2Fragment(), getString(R.string.tab2));
        adapter.addFragment(new Tab3Fragment(), getString(R.string.tab3));
        mBinding.viewPager.setAdapter(adapter);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);

    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}
