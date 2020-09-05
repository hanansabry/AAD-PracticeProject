package com.android.aadpracticeproject.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionClient {

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(SubmissionApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }
}
