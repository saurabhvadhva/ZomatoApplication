package com.zomatoapplication.view.ui;


import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zomatoapplication.R;
import com.zomatoapplication.databinding.FragmentDataListBinding;
import com.zomatoapplication.databinding.FragmentDetailBinding;
import com.zomatoapplication.di.Injectable;
import com.zomatoapplication.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements Injectable {
    public static final String TAG = "DetailFragment";

    private FragmentDetailBinding binding;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        initViews();
        return (View) binding.getRoot();
    }

    private void initViews() {
        WebSettings settings = binding.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        binding.webView.setFitsSystemWindows(true);
        // Set web view client
        binding.webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                binding.progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                binding.progressBar.setVisibility(View.GONE);
            }
        });
        binding.webView.loadUrl(getArguments().getString(Constants.RESTAURANT_URL));
    }


    /**
     * Creates Detail fragment for specific Restaurant id
     */
    public static DetailFragment forRestaurant(String restaurantUrl) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();

        args.putString(Constants.RESTAURANT_URL, restaurantUrl);
        fragment.setArguments(args);

        return fragment;
    }

}
