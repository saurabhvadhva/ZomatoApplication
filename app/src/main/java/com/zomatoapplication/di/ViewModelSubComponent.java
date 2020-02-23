package com.zomatoapplication.di;

import com.zomatoapplication.viewmodel.DataViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    DataViewModel projectListViewModel();
}
