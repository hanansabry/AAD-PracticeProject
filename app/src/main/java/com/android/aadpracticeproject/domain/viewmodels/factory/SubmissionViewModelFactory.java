package com.android.aadpracticeproject.domain.viewmodels.factory;

import com.android.aadpracticeproject.domain.repositories.SubmissionRepository;
import com.android.aadpracticeproject.domain.viewmodels.SubmitFormViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SubmissionViewModelFactory implements ViewModelProvider.Factory {

    private SubmissionRepository repository;

    public SubmissionViewModelFactory(SubmissionRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SubmitFormViewModel(repository);
    }
}
