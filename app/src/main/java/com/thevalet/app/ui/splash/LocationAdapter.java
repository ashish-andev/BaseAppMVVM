package com.thevalet.app.ui.splash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thevalet.app.data.model.LocationOption;
import com.thevalet.app.databinding.ItemListBinding;
import com.thevalet.app.databinding.ItemLocationBinding;
import com.thevalet.app.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;


public class LocationAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<LocationOption> itemList = new ArrayList<>();
    private Context context;
    private int selPosition;

    LocationAdapter(Context context) {
        this.context = context;
    }

    public void clearItems() {
        itemList.clear();
    }

    public void addItems(List<LocationOption> medicines) {
        this.itemList.addAll(medicines);
        notifyDataSetChanged();
    }

    public LocationOption getSelectedLocation() {
        return itemList.get(selPosition);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLocationBinding binding = ItemLocationBinding
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

        private final ItemLocationBinding mBinding;

        MyViewHolder(ItemLocationBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
            mBinding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onBind(int position) {
            LocationOption locationOption = itemList.get(position);
            mBinding.setLocationOption(locationOption);
            if (position == selPosition) {
                mBinding.ivChecked.setVisibility(View.VISIBLE);
            } else {
                mBinding.ivChecked.setVisibility(View.GONE);
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

