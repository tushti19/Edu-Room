package com.anddev.edu_room.API;

import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("refresh")
    private String refresh;
    @SerializedName("access")
    private String access;


    public Token(String refresh, String access) {
        this.refresh = refresh;
        this.access = access;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
