package com.example.app.ui.dashboard.tab2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.data.model.DummyModel;
import com.example.app.databinding.ItemListBinding;
import com.example.app.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;


public class DummyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<DummyModel> itemList = new ArrayList<>();

    DummyAdapter() {
    }

    public void clearItems() {
        itemList.clear();
    }

    public void addItems(List<DummyModel> medicines) {
        this.itemList.addAll(medicines);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyViewHolder extends BaseViewHolder implements View.OnClickListener {

        private final ItemListBinding mBinding;

        MyViewHolder(ItemListBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
            mBinding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onBind(int position) {
            DummyModel compTypesOption = itemList.get(position);
            mBinding.setCompTypesOption(compTypesOption);
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
        }
    }
}

