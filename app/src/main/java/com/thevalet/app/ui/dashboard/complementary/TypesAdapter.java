package com.thevalet.app.ui.dashboard.complementary;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thevalet.app.data.model.CompTypesOption;
import com.thevalet.app.databinding.ItemCompTypesBinding;
import com.thevalet.app.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;


public class TypesAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<CompTypesOption> itemList = new ArrayList<>();
    private Context context;
    private int selPosition;

    TypesAdapter(Context context) {
        this.context = context;
    }

    public void clearItems() {
        itemList.clear();
    }

    public void addItems(List<CompTypesOption> medicines) {
        this.itemList.addAll(medicines);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCompTypesBinding binding = ItemCompTypesBinding
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

        private final ItemCompTypesBinding mBinding;

        MyViewHolder(ItemCompTypesBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
            mBinding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onBind(int position) {
            CompTypesOption compTypesOption = itemList.get(position);
            mBinding.setCompTypesOption(compTypesOption);
            if (position == selPosition) {
                mBinding.tvName.setTextColor(Color.parseColor("#FFFFFF"));
                mBinding.container.setBackgroundColor(Color.parseColor("#515151"));
            } else {
                mBinding.tvName.setTextColor(Color.parseColor("#515151"));
                mBinding.container.setBackgroundColor(Color.parseColor("#F7F7F7"));
            }
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            selPosition = getAdapterPosition();
            notifyDataSetChanged();
        }
    }
}

