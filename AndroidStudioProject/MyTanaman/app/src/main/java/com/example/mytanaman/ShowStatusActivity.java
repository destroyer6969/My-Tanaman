package com.example.mytanaman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_status);
        final Bundle extras = getIntent().getExtras();
        final String url = extras.getString("url");
        TextView namaTextView = (TextView) findViewById(R.id.namaTextView);
        namaTextView.setText(extras.getString("nama"));
        final String nama = extras.getString("nama");
        TextView suhuTextView = (TextView)findViewById(R.id.suhuTextView);
        suhuTextView.setText(extras.getString("suhu"));
        TextView cahayaTextView = (TextView)findViewById(R.id.cahayaTextView);
        cahayaTextView.setText(extras.getString("cahaya"));
        TextView kelembabanTextView = (TextView)findViewById(R.id.kelembabanTextView);
        kelembabanTextView.setText(extras.getString("kelembaban"));
        TextView lamaCahaya = (TextView)findViewById(R.id.lamaCahayaTextView);
        lamaCahaya.setText(extras.getString("sudah_disinari"));
        ImageButton btn1 = (ImageButton)findViewById(R.id.relay1Btn);
        if(extras.getInt("relay1")==1) btn1.setBackgroundResource(R.drawable.on);
        else btn1.setBackgroundResource(R.drawable.off);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int val = 1;
                if(extras.getInt("relay1")==1) val = 0;
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setRelayState(nama, "relay1", val);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        Toast.makeText(ShowStatusActivity.this, "Sending command to relay 1", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
        ImageButton btn2 = (ImageButton)findViewById(R.id.relay2Btn);
        if(extras.getInt("relay2")==1) btn2.setBackgroundResource(R.drawable.on);
        else btn2.setBackgroundResource(R.drawable.off);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int val = 1;
                if(extras.getInt("relay2")==1) val = 0;
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setRelayState(nama, "relay2", val);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        Toast.makeText(ShowStatusActivity.this, "Sending command to relay 2", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
        ImageButton btn3 = (ImageButton)findViewById(R.id.relay3Btn);
        if(extras.getInt("relay3")==1) btn3.setBackgroundResource(R.drawable.on);
        else btn3.setBackgroundResource(R.drawable.off);
        btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int val = 1;
                if(extras.getInt("relay3")==1) val = 0;
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setRelayState(nama, "relay3", val);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        Toast.makeText(ShowStatusActivity.this, "Sending command to relay 3", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
        ImageButton btn4 = (ImageButton)findViewById(R.id.relay4Btn);
        if(extras.getInt("relay4")==1) btn4.setBackgroundResource(R.drawable.on);
        else btn4.setBackgroundResource(R.drawable.off);
        btn4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int val = 1;
                if(extras.getInt("relay4")==1) val = 0;
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setRelayState(nama,"relay4", val);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        Toast.makeText(ShowStatusActivity.this, "Sending command to relay 4", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
        ImageButton btn5 = (ImageButton)findViewById(R.id.relay5Btn);
        if(extras.getInt("relay5")==1) btn5.setBackgroundResource(R.drawable.on);
        else btn5.setBackgroundResource(R.drawable.off);
        btn5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int val = 1;
                if(extras.getInt("relay5")==1) val = 0;
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setRelayState(nama,"relay5", val);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        Toast.makeText(ShowStatusActivity.this, "Sending command to relay 5", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
        ImageButton btn6 = (ImageButton)findViewById(R.id.relay6Btn);
        if(extras.getInt("relay6")==1) btn6.setBackgroundResource(R.drawable.on);
        else btn6.setBackgroundResource(R.drawable.off);
        btn6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int val = 1;
                if(extras.getInt("relay6")==1) val = 0;
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setRelayState(nama,"relay6", val);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        Toast.makeText(ShowStatusActivity.this, "Sending command to relay 6", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
        ImageButton btn7 = (ImageButton)findViewById(R.id.relay7Btn);
        if(extras.getInt("relay7")==1) btn7.setBackgroundResource(R.drawable.on);
        else btn7.setBackgroundResource(R.drawable.off);
        btn7.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int val = 1;
                if(extras.getInt("relay7")==1) val = 0;
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setRelayState(nama,"relay7", val);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        Toast.makeText(ShowStatusActivity.this, "Sending command to relay 7", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
        ImageButton btn8 = (ImageButton)findViewById(R.id.relay8Btn);
        if(extras.getInt("relay8")==1) btn8.setBackgroundResource(R.drawable.on);
        else btn8.setBackgroundResource(R.drawable.off);
        btn8.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int val = 1;
                if(extras.getInt("relay8")==1) val = 0;
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setRelayState(nama,"relay8", val);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        Toast.makeText(ShowStatusActivity.this, "Sending command to relay 8", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
    }
}
