package com.anddev.edu_room.API;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("userId")
    private int userId;
    @SerializedName("token")
    private Token token;

    public Result(int userId, Token token) {
        this.userId = userId;
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
