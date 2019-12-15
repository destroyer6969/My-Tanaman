package com.example.mytanaman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        final Bundle extras = getIntent().getExtras();
        final String url = extras.getString("url");
        API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
        Call<InfoTanamanStr> call = service.getNotif();
        call.enqueue(new Callback<InfoTanamanStr>() {
            @Override
            public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                TextView notifTextView = (TextView)findViewById(R.id.notifTextView);
                notifTextView.setText("\n"+response.body().getInfo());
            }

            @Override
            public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                Log.d("error", "onFailure: "+t.getMessage());
            }
        });
    }
}
