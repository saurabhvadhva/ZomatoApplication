package com.zomatoapplication.view.adapter;

import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.zomatoapplication.R;
import com.squareup.picasso.Picasso;

public class CustomBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(AppCompatImageView view, String url) {
        Picasso.get().load(url).placeholder(R.mipmap.ic_launcher).fit().into(view);
    }
}