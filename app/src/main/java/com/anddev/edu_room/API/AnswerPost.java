package com.anddev.edu_room.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AnswerPost {


    @FormUrlEncoded
    @POST("discussionWall/answer")
    Call<AnswerResponse> saveAnswer(@Header("Authorization") String accessToken, @Query("userId") int userId, @Field("postId") int postId, @Field("text") String text ,@Field("image") String image);

}
