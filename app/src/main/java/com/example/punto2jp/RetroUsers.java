package com.example.punto2jp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetroUsers {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("username")
    @Expose
    private String username;

    public RetroUsers(String name, String username) {
        this.name = name;
        this.username = username;
        }

    public String getUser() {
        return name;
    }

    public void setUser(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}