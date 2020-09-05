package com.android.aadpracticeproject.domain.viewmodels.factory;

import com.android.aadpracticeproject.domain.repositories.LeaderBoardRepository;
import com.android.aadpracticeproject.domain.viewmodels.LeaderBoardViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LeaderBoardViewModelFactory implements ViewModelProvider.Factory {

    LeaderBoardRepository repository;

    public LeaderBoardViewModelFactory(LeaderBoardRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LeaderBoardViewModel(repository);
    }
}
