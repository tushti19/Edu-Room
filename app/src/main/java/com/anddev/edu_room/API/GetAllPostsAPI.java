package com.anddev.edu_room.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetAllPostsAPI {



    @GET("discussionWall/post")
    Call<PostResponse> getAllPosts(@Query("userId") int userId, @Header("Authorization") String accessToken);

}
