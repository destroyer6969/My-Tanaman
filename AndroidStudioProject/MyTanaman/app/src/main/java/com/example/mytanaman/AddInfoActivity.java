package com.example.mytanaman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddInfoActivity extends AppCompatActivity {
    String tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        final Bundle extras = getIntent().getExtras();
        final String url = extras.getString("url");
        final EditText namaSayurText = (EditText)findViewById(R.id.namaSayurText);
        final EditText suhuAtasText = (EditText)findViewById(R.id.suhuAtasText);
        final EditText suhuBawahText = (EditText)findViewById(R.id.suhuBawahText);
        final EditText cahayaAtasText = (EditText)findViewById(R.id.cahayaAtasText);
        final EditText cahayaBawahText = (EditText)findViewById(R.id.cahayaBawahText);
        final EditText kelembabanAtasText = (EditText)findViewById(R.id.kelembabanAtasText);
        final EditText kelembabanBawahText = (EditText)findViewById(R.id.kelembabanBawahText);
        final EditText lamaCahayaText = (EditText)findViewById(R.id.lamaCahayaText);
        final Button submit = (Button)findViewById((R.id.infoSubmitBtn));
        final CalendarView tglTanamDate = (CalendarView) findViewById(R.id.tglTanamDate);
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = formatter.format(date);
        tglTanamDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                tanggal = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(dayOfMonth);
            }
        });
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);
                Call<InfoTanamanStr> call = service.setInfoTanaman(namaSayurText.getText().toString(), suhuAtasText.getText().toString(), suhuBawahText.getText().toString(),
                        cahayaAtasText.getText().toString(), cahayaBawahText.getText().toString(), kelembabanAtasText.getText().toString(), kelembabanBawahText.getText().toString(),
                        lamaCahayaText.getText().toString(), tanggal);
                call.enqueue(new Callback<InfoTanamanStr>() {
                    @Override
                    public void onResponse(Call<InfoTanamanStr> call, Response<InfoTanamanStr> response) {
                        if(response.isSuccessful()) Toast.makeText(AddInfoActivity.this, "Info telah ditambahkan", Toast.LENGTH_SHORT).show();
                        Log.d("result", response.body().getInfo());
                    }
                    @Override
                    public void onFailure(Call<InfoTanamanStr> call, Throwable t) {
                        Log.d("error", "onFailure: "+t.getMessage());
                    }
                });

                finish();
            }
        });
    }
}
