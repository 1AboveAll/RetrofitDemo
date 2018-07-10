package com.himanshurawat.retrofitdemo.networking;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//Todo 5 Use this Class for Singleton Pattern

public class RetrofitClient {

    private static Retrofit INSTANCE;

    public static synchronized Retrofit getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Retrofit
                    .Builder()
                    .baseUrl("http://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return INSTANCE;
    }

}
