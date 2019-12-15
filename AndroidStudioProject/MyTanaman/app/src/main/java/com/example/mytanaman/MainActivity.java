package com.example.mytanaman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText urlText = (EditText)findViewById(R.id.urlText);

        Button infoBtn = (Button)findViewById(R.id.infoBtn);
        infoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String url = "http://"+urlText.getText().toString();
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
        Button statusBtn = (Button)findViewById(R.id.statusBtn);
        statusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String url = "http://"+urlText.getText().toString();
                Intent intent = new Intent(MainActivity.this, CheckStatusActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
        Button notifBtn = (Button)findViewById((R.id.notifBtn));
        notifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://"+urlText.getText().toString();
                Intent intent = new Intent(MainActivity.this, NotifActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
