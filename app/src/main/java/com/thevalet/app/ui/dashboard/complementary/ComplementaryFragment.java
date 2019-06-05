package com.thevalet.app.ui.dashboard.complementary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.thevalet.app.BR;
import com.thevalet.app.R;
import com.thevalet.app.databinding.FragmentComplementaryBinding;
import com.thevalet.app.ui.base.BaseFragment;


public class ComplementaryFragment extends BaseFragment<FragmentComplementaryBinding,
        ComplementaryViewModel> implements ComplementaryNavigator {
    public ComplementaryFragment() {
    }

    private ComplementaryViewModel mViewModel;
    private FragmentComplementaryBinding mBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_complementary;
    }

    @Override
    public ComplementaryViewModel getViewModel() {
        return mViewModel;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mViewModel = new ComplementaryViewModel();
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
        setUpRecyclerView();
        mViewModel.getTypes();
    }

    private void setUpRecyclerView() {
        TypesAdapter adapter = new TypesAdapter(getContext());
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerView.setAdapter(adapter);
    }

}
