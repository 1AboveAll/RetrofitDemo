package com.himanshurawat.retrofitdemo.networking;


import com.himanshurawat.retrofitdemo.pojo.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("posts/")
    Call<List<Post>>getAllPosts();




}
