package com.anddev.edu_room.API;

import com.google.gson.annotations.SerializedName;

public class AnswerResponse {


    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("ResponseMessage")
    private String ResponseMessage;
    @SerializedName("Comments")
    private String Comments;
    @SerializedName("Result")
    private String Result;

    public AnswerResponse(int responseCode, String responseMessage, String comments, String result) {
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

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}
