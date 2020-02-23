package com.zomatoapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zomatoapplication.service.model.DataResponse;
import com.zomatoapplication.service.repository.ProjectRepository;

import javax.inject.Inject;

public class DataViewModel extends AndroidViewModel {
    ProjectRepository projectRepository;
    @Inject
    public DataViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        this.projectRepository = projectRepository;
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<DataResponse> getDataListObservable() {
        return projectRepository.getData();
    }
}
