package com.indiatechlabs.retrofitgetdemo.api;

import com.indiatechlabs.retrofitgetdemo.model.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiGet {

    @GET("/photos")
    Call<List<MainModel>> getAllPhotos();

}
