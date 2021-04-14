package com.anddev.edu_room.API;


import com.google.gson.annotations.SerializedName;

public class LoginResponse {


    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("ResponseMessage")
    private String ResponseMessage;
    @SerializedName("Comments")
    private String Comments;
    @SerializedName("Result")
    private Result Result;

    public LoginResponse(int responseCode, String responseMessage, String comments, com.anddev.edu_room.API.Result result) {
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

    public com.anddev.edu_room.API.Result getResult() {
        return Result;
    }

    public void setResult(com.anddev.edu_room.API.Result result) {
        Result = result;
    }
}
