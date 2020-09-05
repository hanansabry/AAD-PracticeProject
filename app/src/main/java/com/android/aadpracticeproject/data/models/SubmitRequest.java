package com.android.aadpracticeproject.data.models;

import com.google.gson.annotations.SerializedName;

public class SubmitRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String projectUrl;

    public SubmitRequest(String firstName, String lastName, String email, String projectUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.projectUrl = projectUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }
}
