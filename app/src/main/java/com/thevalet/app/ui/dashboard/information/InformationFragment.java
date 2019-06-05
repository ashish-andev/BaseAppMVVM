package com.thevalet.app.ui.dashboard.information;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.thevalet.app.BR;
import com.thevalet.app.R;
import com.thevalet.app.databinding.FragmentInformationBinding;
import com.thevalet.app.ui.base.BaseFragment;


public class InformationFragment extends BaseFragment<FragmentInformationBinding,
        InformationViewModel> implements InformationNavigator {
    public InformationFragment() {
    }

    private InformationViewModel mViewModel;
    private FragmentInformationBinding mBinding;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_information;
    }

    @Override
    public InformationViewModel getViewModel() {
        return mViewModel;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mViewModel = new InformationViewModel();
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
    }

}
