package com.demo.lazy.instagram.mylazyinstargram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.lazy.instagram.mylazyinstargram.adapter.PostAdapter;
import com.demo.lazy.instagram.mylazyinstargram.api.LazyInstargramAPI;
import com.demo.lazy.instagram.mylazyinstargram.api.UserProfile;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUserProfile("android");
        PostAdapter postAdapter = new PostAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(postAdapter);

    }

    //บอกว่าทำการเชื่อมต่ออย่างไร
    private void getUserProfile(String userName){
        OkHttpClient client = new OkHttpClient
                .Builder()
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LazyInstargramAPI.BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //เชื่อมต่อแล้ว
        LazyInstargramAPI lazyInstargramAPI = retrofit.create(LazyInstargramAPI.class);

        Call<UserProfile> call = lazyInstargramAPI.getProfile(userName);
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if(response.isSuccessful()){
                    UserProfile userProfile = response.body();
                    TextView nameText = (TextView) findViewById(R.id.textame);
                    nameText.setText("@"+userProfile.getUser());

                    ImageView imageView = (ImageView) findViewById(R.id.imageView);
                    Glide.with(MainActivity.this).load(userProfile.getUrlProfile()).into(imageView);

                    TextView bioText = (TextView) findViewById(R.id.bio);
                    bioText.setText(userProfile.getBio());

                }
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
    }
}
