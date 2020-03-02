package com.zomatoapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.zomatoapplication.R;
import com.zomatoapplication.databinding.ItemListDataBinding;
import com.zomatoapplication.service.model.Restaurant;
import com.zomatoapplication.utils.Utility;
import com.zomatoapplication.view.callback.DataClickCallback;

import java.util.List;
import java.util.Objects;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    List<Restaurant> mDataList;

    @Nullable
    private final DataClickCallback dataClickCallback;

    public DataAdapter(@Nullable DataClickCallback dataClickCallback) {
        this.dataClickCallback = dataClickCallback;
    }

    public void setDataList(final List<Restaurant> dataList) {
        if (this.mDataList == null) {
            this.mDataList = dataList;
            notifyItemRangeInserted(0, dataList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return dataList.size();
                }

                @Override
                public int getNewListSize() {
                    return dataList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return Objects.equals(dataList.get(oldItemPosition).getRestaurant().getName(), dataList.get(newItemPosition).getRestaurant().getName());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Restaurant dataItem = dataList.get(newItemPosition);
                    Restaurant old = dataList.get(oldItemPosition);
                    return Objects.equals(dataItem.getRestaurant().getName(), old.getRestaurant().getName()) && Objects.equals(dataItem.getRestaurant().getCuisines(), old.getRestaurant().getCuisines());
                }
            });
            this.mDataList = dataList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListDataBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list_data,
                        parent, false);

        binding.setCallback(dataClickCallback);
        return new DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.binding.setData(mDataList.get(position));
        holder.binding.executePendingBindings();
        //holder.binding.getRoot().setOnClickListener(view -> Utility.showToast(holder.binding.getRoot().getContext(),"Clicked!!"));
    }

    public List<Restaurant> getDataList()  {
        return mDataList;
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {

        final ItemListDataBinding binding;

        public DataViewHolder(ItemListDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
