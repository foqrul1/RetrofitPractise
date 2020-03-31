package com.example.retrofitpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL= "http://services.hanselandpetal.com/";
    TextView tv1;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv);
        imageView = findViewById(R.id.iv);
        button = findViewById(R.id.btnmain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimePicker.class);
                startActivity(intent);
            }
        });
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final FlowerResponse flowerResponse = retrofit.create(FlowerResponse.class);
        flowerResponse.flowerservice().enqueue(new Callback<List<FlowerService>>() {
            @Override
            public void onResponse(Call<List<FlowerService>> call, Response<List<FlowerService>> response) {
                Toast.makeText(MainActivity.this, "response code"+response.code(), Toast.LENGTH_SHORT).show();
                Log.d("testing ","response code: "+response.code());
                if(response.isSuccessful()){
                    List<FlowerService> list = response.body();
                    FlowerService flowerService = list.get(1);
                    String photo = flowerService.getPhoto();
                    tv1.setText(flowerService.getName());
                    Picasso.get().load(BASE_URL+"photos/"+photo).into(imageView);
                }else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FlowerService>> call, Throwable t) {

            }
        });

    }
}
