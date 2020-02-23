package com.zomatoapplication.di;

import androidx.lifecycle.ViewModelProvider;

import com.zomatoapplication.service.repository.ApiService;
import com.zomatoapplication.utils.Constants;
import com.zomatoapplication.viewmodel.DataViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {
    @Singleton @Provides
    ApiService provideApiService() {
        return new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new DataViewModelFactory(viewModelSubComponent.build());
    }
}
