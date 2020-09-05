package com.android.aadpracticeproject.domain.viewmodels;

import com.android.aadpracticeproject.data.models.Learner;
import com.android.aadpracticeproject.data.repositories.LeaderBoardRepositoryImpl;
import com.android.aadpracticeproject.domain.repositories.LeaderBoardRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LeaderBoardViewModel extends ViewModel {

    public MutableLiveData<List<Learner>> learningLeadersLearners = new MutableLiveData<>();
    public MutableLiveData<List<Learner>> skillIqLearners = new MutableLiveData<>();
    public LeaderBoardRepository repository;

    public LeaderBoardViewModel(LeaderBoardRepository repository) {
        this.repository = repository;
    }

    public void getLearningLeaders() {
        repository.retrieveLearningLeaders(learningLeadersLearners);
    }

    public void getSkillIqLeaders() {
        repository.retrieveSkillIqLeaders(skillIqLearners);
    }
}
