package com.himanshurawat.retrofitdemo.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//Todo 3 Make Pojo Class
public class Post {


    @SerializedName("userId")
    private int userID;
    private int id;
    private String title;
    private String body;


    public Post(int userID, int id, String title, String body) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}


