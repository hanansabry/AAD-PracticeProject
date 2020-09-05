package com.android.aadpracticeproject.data.repositories;

import android.util.Log;

import com.android.aadpracticeproject.data.models.BaseResponse;
import com.android.aadpracticeproject.data.models.SubmitRequest;
import com.android.aadpracticeproject.data.network.SubmissionApi;
import com.android.aadpracticeproject.data.network.SubmissionClient;

import java.util.Objects;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionRepositoryImpl implements com.android.aadpracticeproject.domain.repositories.SubmissionRepository, Callback<Void> {

    private SubmissionApi api = SubmissionClient.getClient().create(SubmissionApi.class);
    private MutableLiveData<Integer> responseLiveData = new MutableLiveData<>();

    @Override
    public void postSubmissionData(SubmitRequest submitRequest, MutableLiveData<Integer> responseLiveData) {
        this.responseLiveData = responseLiveData;
        Call<Void> call = api.postSubmission(submitRequest.getFirstName(), submitRequest.getLastName(), submitRequest.getEmail(), submitRequest.getProjectUrl());
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {
        if (response.isSuccessful()) {
            responseLiveData.postValue(1);
        } else {
            responseLiveData.postValue(0);
            Log.d("Failed", response.message());
        }
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        responseLiveData.postValue(0);
        Log.d("Failure post", Objects.requireNonNull(t.getMessage()));
    }
}
