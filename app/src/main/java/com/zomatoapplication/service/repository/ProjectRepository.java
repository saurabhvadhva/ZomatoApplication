package com.zomatoapplication.service.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zomatoapplication.service.model.DataResponse;
import com.zomatoapplication.utils.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ProjectRepository {
    private ApiService apiService;

    @Inject
    public ProjectRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public LiveData<DataResponse> getData() {
        final MutableLiveData<DataResponse> data = new MutableLiveData<>();

        apiService.getData("","","").enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                Log.d(Constants.RESPONSE,response.body().toString());
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
