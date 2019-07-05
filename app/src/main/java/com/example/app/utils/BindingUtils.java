package com.example.app.utils;

import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.data.model.DummyModel;
import com.example.app.ui.dashboard.tab2.DummyAdapter;

import java.util.List;


public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }


    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter("imageDrawable")
    public static void setImageDrawable(ImageView imageView, @DrawableRes int id) {
        Glide.with(imageView.getContext()).load(id).into(imageView);
    }

    @BindingAdapter("dummyAdapter")
    public static void dummyAdapter(RecyclerView recyclerView, List<DummyModel> list) {
        DummyAdapter adapter = (DummyAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(list);
        }
    }
}
