package com.android.aadpracticeproject.domain.repositories;

import com.android.aadpracticeproject.data.models.Learner;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public interface LeaderBoardRepository {

    void retrieveLearningLeaders(MutableLiveData<List<Learner>> learnersLiveData);

    void retrieveSkillIqLeaders(MutableLiveData<List<Learner>> learnersLiveData);
}
