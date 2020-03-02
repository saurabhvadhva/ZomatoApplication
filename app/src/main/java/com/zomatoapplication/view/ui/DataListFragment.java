package com.zomatoapplication.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.zomatoapplication.R;
import com.zomatoapplication.databinding.FragmentDataListBinding;
import com.zomatoapplication.di.Injectable;
import com.zomatoapplication.service.model.RestaurantItem;
import com.zomatoapplication.utils.AppStatus;
import com.zomatoapplication.utils.Utility;
import com.zomatoapplication.view.adapter.DataAdapter;
import com.zomatoapplication.view.callback.DataClickCallback;
import com.zomatoapplication.viewmodel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class DataListFragment extends Fragment implements Injectable {
    public static final String TAG = "DataListFragment";
    private DataAdapter dataAdapter;
    private FragmentDataListBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_list, container, false);
        dataAdapter = new DataAdapter(dataClickCallback);
        binding.dataRv.setAdapter(dataAdapter);
        binding.swipeLayout.setRefreshing(true);

        return (View) binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final DataViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(DataViewModel.class);
        observeViewModel(viewModel);
        binding.swipeLayout.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        binding.swipeLayout.setOnRefreshListener(() -> {
            observeViewModel(viewModel);
        });
    }

    private void observeViewModel(DataViewModel viewModel) {
        if (AppStatus.getInstance().isOnline(getActivity())) {
            // Update the list when the data changes

            viewModel.getDataListObservable().observe(this, dataResponse -> {
                if (dataResponse != null) {
                    binding.swipeLayout.setRefreshing(false);
                    dataAdapter.setDataList(dataResponse.getRestaurants());
                }
            });
        } else {
            binding.swipeLayout.setRefreshing(false);
            Utility.showToast(getActivity(), getString(R.string.no_internet_connection));

        }
    }

    private final DataClickCallback dataClickCallback = restaurantItem -> {

        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            ((MainActivity) getActivity()).show(restaurantItem);
    }
};
}
