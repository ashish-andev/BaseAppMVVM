package com.example.app.ui.dashboard.tab1;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.BR;
import com.example.app.R;
import com.example.app.databinding.FragmentTab1Binding;
import com.example.app.ui.base.BaseFragment;


public class Tab1Fragment extends BaseFragment<FragmentTab1Binding,
        Tab1ViewModel> implements Tab1Navigator {
    public Tab1Fragment() {
    }

    private Tab1ViewModel mViewModel;
    private FragmentTab1Binding mBinding;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tab1;
    }

    @Override
    public Tab1ViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mViewModel = new Tab1ViewModel();
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
    }

}
