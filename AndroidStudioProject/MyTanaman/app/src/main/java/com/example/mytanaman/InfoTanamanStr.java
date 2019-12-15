package com.example.mytanaman;

import com.google.gson.annotations.SerializedName;

public class InfoTanamanStr {
    @SerializedName("info")
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
