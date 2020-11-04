package com.example.musicservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.musicservice.service.MusicService;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       intent=new Intent(MainActivity.this, MusicService.class);


    }
    public void startservice(View v){
      startService(intent);
    }
    public void stopservice(View v){
       stopService(intent);
    }
}