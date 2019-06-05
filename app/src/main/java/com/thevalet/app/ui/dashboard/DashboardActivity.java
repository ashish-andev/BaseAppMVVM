package com.thevalet.app.ui.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.thevalet.app.BR;
import com.thevalet.app.R;
import com.thevalet.app.databinding.ActivityDashboardBinding;
import com.thevalet.app.ui.base.BaseBindingActivity;
import com.thevalet.app.ui.dashboard.complementary.ComplementaryFragment;
import com.thevalet.app.ui.dashboard.forms.FormsFragment;
import com.thevalet.app.ui.dashboard.information.InformationFragment;

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
        adapter.addFragment(new FormsFragment(), getString(R.string.forms));
        adapter.addFragment(new ComplementaryFragment(), getString(R.string.complementary));
        adapter.addFragment(new InformationFragment(), getString(R.string.information));
        mBinding.viewPager.setAdapter(adapter);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);

        mBinding.tabLayout.getTabAt(0).setIcon(R.drawable.ic_forms);
        mBinding.tabLayout.getTabAt(1).setIcon(R.drawable.ic_complementary);
        mBinding.tabLayout.getTabAt(2).setIcon(R.drawable.ic_information);

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
