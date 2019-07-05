package com.example.app.ui.base;


import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseBindingActivity<T extends ViewDataBinding, V extends BaseViewModel>
        extends BaseCompatActivity implements BaseFragment.Callback {

    private T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();


    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }


    private void performDataBinding() {
        try {
            mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
            this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
            mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
            mViewDataBinding.executePendingBindings();
        } catch (Throwable ignored) {
        }
    }

    @Override
    protected void onDestroy() {
        try {
            if (getViewModel() != null) {
                getViewModel().destroy();
            }
        } catch (Throwable ignored) {

        }
        super.onDestroy();
    }
}

