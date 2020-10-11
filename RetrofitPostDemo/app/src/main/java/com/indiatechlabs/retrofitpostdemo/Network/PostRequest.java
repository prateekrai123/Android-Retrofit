package com.indiatechlabs.retrofitpostdemo.Network;

import com.indiatechlabs.retrofitpostdemo.Model.MainModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostRequest {

    @FormUrlEncoded
    @POST("/posts")
    Call<MainModel> postThePost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body
    );

}
