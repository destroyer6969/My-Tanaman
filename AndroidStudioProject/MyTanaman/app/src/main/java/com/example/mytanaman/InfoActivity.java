package com.example.mytanaman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        final Bundle extras = getIntent().getExtras();
        final String url = extras.getString("url");
        API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
        Call<InfoTanamanStr> call = service.getInfoTanamanStr();
        call.enqueue(new Callback<InfoTanamanStr>() {
            @Override
            public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                TextView infoTextView = (TextView)findViewById(R.id.infoTextView);
                infoTextView.setText("\n"+response.body().getInfo());
            }

            @Override
            public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                Log.d("error", "onFailure: "+t.getMessage());
            }
        });

        Button addInfoBtn = (Button)findViewById(R.id.addInfoBtn);
        addInfoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(InfoActivity.this, AddInfoActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
                finish();
            }
        });
        Button delInfoBtn = (Button)findViewById(R.id.delInfoBtn);
        delInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText namaDelText = (EditText)findViewById(R.id.namaDelText);
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<ResponseBody> call = service.delInfoTanaman(namaDelText.getText().toString(), "del");
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) Toast.makeText(InfoActivity.this, "Info telah dihapus", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
                finish();
            }
        });
    }
}
