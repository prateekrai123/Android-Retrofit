package com.indiatechlabs.retrofitpostdemo.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCall {

    private static Retrofit retrofit;

    public static Retrofit postAPost(){
        if(retrofit == null){

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
