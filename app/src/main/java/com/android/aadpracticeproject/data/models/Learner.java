package com.android.aadpracticeproject.data.models;

import com.google.gson.annotations.SerializedName;

public class Learner {

    public enum LearnerType {Leader, SkillIq};

    private String name;
    @SerializedName(value = "hours",alternate = "score")
    private int value;
    private String country;
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
