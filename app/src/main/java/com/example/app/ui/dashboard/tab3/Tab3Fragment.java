package com.example.app.ui.dashboard.tab3;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.BR;
import com.example.app.R;
import com.example.app.databinding.FragmentTab3Binding;
import com.example.app.ui.base.BaseFragment;


public class Tab3Fragment extends BaseFragment<FragmentTab3Binding,
        Tab3ViewModel> implements Tab3Navigator {
    public Tab3Fragment() {
    }

    private Tab3ViewModel mViewModel;
    private FragmentTab3Binding mBinding;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tab3;
    }

    @Override
    public Tab3ViewModel getViewModel() {
        return mViewModel;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mViewModel = new Tab3ViewModel();
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
    }

}
