package com.android.aadpracticeproject.domain.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;

import com.android.aadpracticeproject.data.models.SubmitRequest;
import com.android.aadpracticeproject.domain.repositories.SubmissionRepository;
import com.android.aadpracticeproject.domain.viewmodels.utils.Event;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubmitFormViewModel extends ViewModel {

    private ObservableForm observableForm = new ObservableForm();
    private MutableLiveData<String> emailError = new MutableLiveData<>();
    private MutableLiveData<String> firstNameError = new MutableLiveData<>();
    private MutableLiveData<String> lastNameError = new MutableLiveData<>();
    private MutableLiveData<String> projectUrlError = new MutableLiveData<>();

    private MutableLiveData<Integer> response = new MutableLiveData<>();
    private MutableLiveData<Event<Boolean>> isValidObserver = new MutableLiveData<>();
    private SubmissionRepository repository;

    public SubmitFormViewModel(SubmissionRepository repository) {
        this.repository = repository;
    }

    public void postSubmitRequest(SubmitRequest submitRequest) {
        repository.postSubmissionData(submitRequest, response);
    }

    public void validateData() {
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
        } else if (!URLUtil.isValidUrl(observableForm.getProjectUrl())) {
            projectUrlError.postValue("Invalid url");
            isValid = false;
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
            isValidObserver.setValue(new Event<>(true));
        }
    }

    public void onSubmitClicked() {
        SubmitRequest submitRequest = new SubmitRequest(
                observableForm.getFirstName(),
                observableForm.getLastName(),
                observableForm.getEmail(),
                observableForm.getProjectUrl());
        postSubmitRequest(submitRequest);
    }

    public MutableLiveData<Integer> getResponse() {
        return response;
    }

    public LiveData<Event<Boolean>> getIsValidObserver() {
        return isValidObserver;
    }

    public ObservableForm getObservableForm() {
        return observableForm;
    }

    public MutableLiveData<String> getEmailError() {
        return emailError;
    }

    public MutableLiveData<String> getFirstNameError() {
        return firstNameError;
    }

    public MutableLiveData<String> getLastNameError() {
        return lastNameError;
    }

    public MutableLiveData<String> getProjectUrlError() {
        return projectUrlError;
    }
}
