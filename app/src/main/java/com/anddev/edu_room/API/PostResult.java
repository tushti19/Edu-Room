package com.anddev.edu_room.API;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostResult {

    @SerializedName("count")
    private int count;
    @SerializedName("data")
    private Data[] data;

    public PostResult(int count, Data[] data) {
        this.count = count;
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
