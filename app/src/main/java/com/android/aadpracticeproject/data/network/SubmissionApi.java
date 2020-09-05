package com.android.aadpracticeproject.data.network;

import com.android.aadpracticeproject.data.models.BaseResponse;
import com.android.aadpracticeproject.data.models.SubmitRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SubmissionApi {

    public static final String BASE_URL = "https://docs.google.com/forms/d/e/";
    public static final String FORM_ID = "1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";

    @POST(FORM_ID)
    @FormUrlEncoded
    Call<Void> postSubmission(@Field("entry.1877115667") String firstName,
                              @Field("entry.2006916086") String lastName,
                              @Field("entry.1824927963") String email,
                              @Field("entry.284483984") String projectUrl);
}
