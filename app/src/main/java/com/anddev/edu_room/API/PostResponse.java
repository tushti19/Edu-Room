package com.anddev.edu_room.API;

import com.google.gson.annotations.SerializedName;

public class PostResponse {

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("ResponseMessage")
    private String ResponseMessage;
    @SerializedName("Comments")
    private String Comments;
    @SerializedName("Result")
    private PostResult Result;

    public PostResponse(int responseCode, String responseMessage, String comments, PostResult result) {
        ResponseCode = responseCode;
        ResponseMessage = responseMessage;
        Comments = comments;
        Result = result;
    }

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        ResponseMessage = responseMessage;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public PostResult getResult() {
        return Result;
    }

    public void setResult(PostResult result) {
        Result = result;
    }

}
