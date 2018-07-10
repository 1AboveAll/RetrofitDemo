
package com.himanshurawat.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.himanshurawat.retrofitdemo.networking.RetrofitInterface;
import com.himanshurawat.retrofitdemo.pojo.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayList<String> titleArrayList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.activity_main_list_view);
        titleArrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,titleArrayList);
        listView.setAdapter(adapter);


        //Todo 4 Use Singleton Pattern since it's a Heavy Task
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        retrofitInterface.getAllPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        updateList(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("Error",t.getMessage()+"");
            }
        });


    }

    private void updateList(List<Post> posts) {
        titleArrayList.clear();
        for(Post item : posts){
            titleArrayList.add(item.getTitle());
        }
        adapter.notifyDataSetChanged();
    }
}
