package com.indiatechlabs.retrofitpostdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.indiatechlabs.retrofitpostdemo.API.ApiCall;
import com.indiatechlabs.retrofitpostdemo.Model.MainModel;
import com.indiatechlabs.retrofitpostdemo.Network.PostRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText userId;
    private EditText title;
    private EditText body;
    private Button submit;
    private RelativeLayout progressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = findViewById(R.id.etUserId);
        title = findViewById(R.id.etTitle);
        body = findViewById(R.id.etBody);
        submit = findViewById(R.id.btnSubmit);
        progressLayout = findViewById(R.id.progressLayout);

        int usrId = 1;
        if(!userId.getText().toString().equals("")){
            usrId = Integer.parseInt(userId.getText().toString());
        }

        int finalUsrId = usrId;
        submit.setOnClickListener(v -> {
            progressLayout.setVisibility(View.VISIBLE);
            PostRequest service = ApiCall.postAPost().create(PostRequest.class);
            final Call<MainModel> call = service.postThePost(finalUsrId, title.getText().toString(), body.getText().toString());

            call.enqueue(new Callback<MainModel>() {
                @Override
                public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                    progressLayout.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Posted Successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<MainModel> call, Throwable t) {
                    progressLayout.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Not posted successfully "+t, Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}