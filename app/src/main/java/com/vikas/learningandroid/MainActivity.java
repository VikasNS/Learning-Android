package com.vikas.learningandroid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //customAdapter customAdapter = new customAdapter(getApplicationContext());
        //LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        //recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(customAdapter);


        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                generateDataList(response.body());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Something WEent wrong outisde 1",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<RetroPhoto> photoList) {
        Toast.makeText(getApplicationContext(),photoList.toString(),Toast.LENGTH_LONG).show();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        customAdapter c = new customAdapter(photoList,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(c);
    }
}
