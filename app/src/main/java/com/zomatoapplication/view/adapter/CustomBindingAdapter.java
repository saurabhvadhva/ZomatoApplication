package com.zomatoapplication.view.adapter;

import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Request;
import com.zomatoapplication.R;
import com.squareup.picasso.Picasso;

public class CustomBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(AppCompatImageView view, String url) {
            Picasso.get().load(url)
                    .networkPolicy(NetworkPolicy.OFFLINE).placeholder(R.mipmap.ic_launcher).fit().into(view);
        }
}