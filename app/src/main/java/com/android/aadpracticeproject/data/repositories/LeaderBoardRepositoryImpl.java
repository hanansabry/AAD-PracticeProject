package com.android.aadpracticeproject.data.repositories;

import android.util.Log;

import com.android.aadpracticeproject.data.models.Learner;
import com.android.aadpracticeproject.data.network.LeaderBoardApi;
import com.android.aadpracticeproject.data.network.LeaderBoardClient;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardRepositoryImpl implements com.android.aadpracticeproject.domain.repositories.LeaderBoardRepository {

    LeaderBoardApi api = LeaderBoardClient.getClient().create(LeaderBoardApi.class);

    @Override
    public void retrieveLearningLeaders(MutableLiveData<List<Learner>> learnersLiveData) {
        Call<List<Learner>> call = api.retrieveLearningLeaders();
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                if (response.isSuccessful()) {
                    learnersLiveData.postValue(response.body());
                    Log.d("Successful Response", "First Learner Name = " + response.body().get(0).getName());
                } else {
                    Log.d("Error Response", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {
                Log.d("Error Response", t.getMessage());
            }
        });
    }

    @Override
    public void retrieveSkillIqLeaders(MutableLiveData<List<Learner>> learnersLiveData) {
        Call<List<Learner>> call = api.retrieveSkillIqLeaders();
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                if (response.isSuccessful()) {
                    learnersLiveData.postValue(response.body());
                    Log.d("Successful Response", "First Learner Name = " + response.body().get(0).getName());
                } else {
                    Log.d("Error Response", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {
                Log.d("Error Response", t.getMessage());
            }
        });
    }
}
