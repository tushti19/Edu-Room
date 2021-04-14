package com.anddev.edu_room.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> createUser(@Field("email") String Email, @Field("password") String Pass);
}
