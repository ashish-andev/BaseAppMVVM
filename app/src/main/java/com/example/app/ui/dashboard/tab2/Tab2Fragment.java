package com.example.app.ui.dashboard.tab2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.app.BR;
import com.example.app.R;
import com.example.app.databinding.FragmentTab2Binding;
import com.example.app.ui.base.BaseFragment;


public class Tab2Fragment extends BaseFragment<FragmentTab2Binding,
        Tab2ViewModel> implements Tab2Navigator {
    public Tab2Fragment() {
    }

    private Tab2ViewModel mViewModel;
    private FragmentTab2Binding mBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tab2;
    }

    @Override
    public Tab2ViewModel getViewModel() {
        return mViewModel;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mViewModel = new Tab2ViewModel();
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
        setUpRecyclerView();
        mViewModel.getRepositories();
    }

    private void setUpRecyclerView() {
        RepoAdapter adapter = new RepoAdapter();
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerView.setAdapter(adapter);
    }

}
