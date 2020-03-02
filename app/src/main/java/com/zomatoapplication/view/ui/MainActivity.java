package com.zomatoapplication.view.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.zomatoapplication.R;
import com.zomatoapplication.service.model.Restaurant;
import com.zomatoapplication.service.model.RestaurantItem;
import com.zomatoapplication.utils.Constants;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            DataListFragment fragment = new DataListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, DataListFragment.TAG).commit();
        }
    }

    /**
     * Shows the detail fragment
     */
    public void show(RestaurantItem restaurantItem) {
        DetailFragment detailFragment = DetailFragment.forRestaurant(restaurantItem.getUrl());

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(Constants.DETAIL)
                .replace(R.id.fragment_container,
                        detailFragment, null).commit();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
