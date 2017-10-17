package com.demo.lazy.instagram.mylazyinstargram.api;


import com.demo.lazy.instagram.mylazyinstargram.UserProfile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 กำหนดว่าจะเชื่อมต่อ API อย่างไร
 */

public interface LazyInstagramAPI {
    String BASE = "https://us-central1-retrofit-course.cloudfunctions.net";

    @GET("/getProfile")
    Call<UserProfile> getProfile(@Query("user") String userName);


}

