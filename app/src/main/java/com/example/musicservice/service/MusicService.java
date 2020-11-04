package com.example.musicservice.service;

import android.Manifest;
import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.musicservice.MainActivity;

import java.io.File;
import java.io.IOException;
import java.security.Provider;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer=new MediaPlayer();




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("————————","onBind");
        return null;
    }


    @Override
    public void onCreate() {
        Log.i("————————","onCreate");
        //地址问题，这个检测的会是手机里的，不是电脑的
        File file=new File("J:\\KwDownload\\song\\周杰伦-告白气球.flac");
        try {

            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            Log.i("————————","mediaPlayer.IOException");
            e.printStackTrace();
        }
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("————————","onStartCommand");



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("————————","onDestroy");
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }
}
