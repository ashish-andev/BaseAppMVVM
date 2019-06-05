package com.thevalet.app.ui.dashboard.forms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.thevalet.app.BR;
import com.thevalet.app.R;
import com.thevalet.app.databinding.FragmentFormsBinding;
import com.thevalet.app.ui.base.BaseFragment;


public class FormsFragment extends BaseFragment<FragmentFormsBinding,
        FormsViewModel> implements FormsNavigator {
    public FormsFragment() {
    }

    private FormsViewModel mViewModel;
    private FragmentFormsBinding mBinding;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_forms;
    }

    @Override
    public FormsViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mViewModel = new FormsViewModel();
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
    }

}
