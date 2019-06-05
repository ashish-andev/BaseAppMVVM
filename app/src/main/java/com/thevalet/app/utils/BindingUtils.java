package com.thevalet.app.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.thevalet.app.data.model.CompTypesOption;
import com.thevalet.app.data.model.LocationOption;
import com.thevalet.app.ui.dashboard.complementary.TypesAdapter;
import com.thevalet.app.ui.splash.LocationAdapter;

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

    @BindingAdapter("locationAdapter")
    public static void locationAdapter(RecyclerView recyclerView, List<LocationOption> list) {
        LocationAdapter adapter = (LocationAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(list);
        }
    }

    @BindingAdapter("compTypesAdapter")
    public static void compTypesAdapter(RecyclerView recyclerView, List<CompTypesOption> list) {
        TypesAdapter adapter = (TypesAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(list);
        }
    }
}
