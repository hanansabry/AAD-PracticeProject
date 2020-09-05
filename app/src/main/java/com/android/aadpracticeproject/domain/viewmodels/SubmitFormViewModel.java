package com.android.aadpracticeproject.domain.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;

import com.android.aadpracticeproject.data.models.SubmitRequest;
import com.android.aadpracticeproject.domain.repositories.SubmissionRepository;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubmitFormViewModel extends ViewModel {

    public ObservableForm observableForm = new ObservableForm();
    public MutableLiveData<String> emailError = new MutableLiveData<>();
    public MutableLiveData<String> firstNameError = new MutableLiveData<>();
    public MutableLiveData<String> lastNameError = new MutableLiveData<>();
    public MutableLiveData<String> projectUrlError = new MutableLiveData<>();

    public MutableLiveData<Integer> response = new MutableLiveData<>();
    private SubmissionRepository repository;

    public SubmitFormViewModel(SubmissionRepository repository) {
        this.repository = repository;
    }

    public void postSubmitRequest(SubmitRequest submitRequest) {
        repository.postSubmissionData(submitRequest, response);
    }

    public void onSubmitClicked() {
        boolean isValid = true;
        if (TextUtils.isEmpty(observableForm.getFirstName())) {
            firstNameError.postValue("Field is required");
            isValid = false;
        } else {
            firstNameError.postValue(null);
        }

        if (TextUtils.isEmpty(observableForm.getLastName())) {
            lastNameError.postValue("Field is required");
            isValid = false;
        } else {
            lastNameError.postValue(null);
        }

        if (TextUtils.isEmpty(observableForm.getProjectUrl())) {
            isValid = false;
            projectUrlError.postValue("Field is required");
        } else {
            projectUrlError.postValue(null);
        }

        if (TextUtils.isEmpty(observableForm.getEmail())) {
            emailError.postValue("Field is required");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(observableForm.getEmail()).matches()) {
            emailError.postValue("Invalid e-mail address");
            isValid = false;
        } else {
            emailError.postValue(null);
        }

        if (isValid) {
            SubmitRequest submitRequest = new SubmitRequest(
                    observableForm.getFirstName(),
                    observableForm.getLastName(),
                    observableForm.getEmail(),
                    observableForm.getProjectUrl());
            postSubmitRequest(submitRequest);
        }

    }

}
