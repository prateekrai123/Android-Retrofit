package com.indiatechlabs.retrofitgetdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.indiatechlabs.retrofitgetdemo.api.ApiGet;
import com.indiatechlabs.retrofitgetdemo.model.MainModel;
import com.indiatechlabs.retrofitgetdemo.network.ApiCall;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiGet service = ApiCall.getRetrofitInstance().create(ApiGet.class);
        Call<List<MainModel>> call = service.getAllPhotos();

        call.enqueue(new Callback<List<MainModel>>() {

            @Override
            public void onResponse(Call<List<MainModel>> call, Response<List<MainModel>> response) {
                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setAdapter(new RecyclerAdapter(context, response.body()));
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void onFailure(Call<List<MainModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Service Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}