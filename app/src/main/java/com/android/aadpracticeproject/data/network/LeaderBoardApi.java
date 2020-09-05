package com.android.aadpracticeproject.data.network;

import com.android.aadpracticeproject.data.models.Learner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardApi {

    public static final String BASE_URL = "https://gadsapi.herokuapp.com/api/";
    public static final String LearningLeaders = "hours";
    public static final String Skill_IQ_Leaders = "skilliq";

    @GET(LearningLeaders)
    Call<List<Learner>> retrieveLearningLeaders();

    @GET(Skill_IQ_Leaders)
    Call<List<Learner>> retrieveSkillIqLeaders();
}
