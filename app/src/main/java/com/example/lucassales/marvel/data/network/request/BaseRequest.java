package com.example.lucassales.marvel.data.network.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucassales on 28/11/2017.
 */

public class BaseRequest {

    @Expose
    @SerializedName("apikey")
    private String apikey;

    @Expose
    @SerializedName("hash")
    private String hash;

    @Expose
    @SerializedName("ts")
    private long timeStamp;

    public BaseRequest(String apikey, String hash, long timeStamp) {
        this.apikey = apikey;
        this.hash = hash;
        this.timeStamp = timeStamp;
    }
}
