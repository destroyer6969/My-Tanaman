package com.example.mytanaman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_status);
        final Bundle extras = getIntent().getExtras();
        final String url = extras.getString("url");
        final EditText namaText = (EditText)findViewById(R.id.namaText);
        final API service = RetrofitClientInstance.getRetrofitInstance(url).create(API.class);

        Button checkBtn = (Button)findViewById(R.id.checkBtn);
        checkBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Call<StatusTanaman> call = service.getStatusTanaman(namaText.getText().toString());
                call.enqueue(new Callback<StatusTanaman>() {
                    @Override
                    public void onResponse(Call<StatusTanaman> call, Response<StatusTanaman> response) {
                        if(response.body().getNama()==null) Toast.makeText(CheckStatusActivity.this, "Nama tidak ditemukan", Toast.LENGTH_SHORT).show();
                        else if(response.body().getCahaya()==null || response.body().getSuhu()==null || response.body().getKelembaban()==null) Toast.makeText(CheckStatusActivity.this, "Database tidak lengkap", Toast.LENGTH_SHORT).show();
                        else{
                            Intent intent = new Intent(CheckStatusActivity.this, ShowStatusActivity.class);
                            intent.putExtra("nama", response.body().getNama());
                            intent.putExtra("suhu", Double.toString(response.body().getSuhu()));
                            intent.putExtra("cahaya", Double.toString(response.body().getCahaya()));
                            intent.putExtra("kelembaban", Double.toString(response.body().getKelembaban()));
                            intent.putExtra("sudah_disinari", Double.toString(response.body().getSudah_disinari()));
                            intent.putExtra("relay1", response.body().getRelay1());
                            intent.putExtra("relay2", response.body().getRelay2());
                            intent.putExtra("relay3", response.body().getRelay3());
                            intent.putExtra("relay4", response.body().getRelay4());
                            intent.putExtra("relay5", response.body().getRelay5());
                            intent.putExtra("relay6", response.body().getRelay6());
                            intent.putExtra("relay7", response.body().getRelay7());
                            intent.putExtra("relay8", response.body().getRelay8());
                            intent.putExtra("url", url);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<StatusTanaman> call, Throwable t) {
                        Log.d("fail", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
    }
}
