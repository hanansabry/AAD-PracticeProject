package com.android.aadpracticeproject.domain.repositories;

import com.android.aadpracticeproject.data.models.SubmitRequest;

import androidx.lifecycle.MutableLiveData;

public interface SubmissionRepository {

    void postSubmissionData(SubmitRequest submitRequest, MutableLiveData<Integer> response);
}
