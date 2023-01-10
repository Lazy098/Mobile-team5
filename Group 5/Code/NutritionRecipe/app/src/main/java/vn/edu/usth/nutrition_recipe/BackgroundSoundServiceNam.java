package vn.edu.usth.nutrition_recipe;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BackgroundSoundServiceNam extends Service {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this,R.raw.nam);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            Toast.makeText(this, "Now Playing: Song of Nam", Toast.LENGTH_SHORT).show();
        }else{
            mediaPlayer.pause();
            Toast.makeText(this, "Paused: Song of Nam", Toast.LENGTH_SHORT).show();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Toast.makeText(this, "Stopped Playing: Song of Nam", Toast.LENGTH_SHORT).show();
        mediaPlayer.release();
        mediaPlayer = MediaPlayer.create(this, R.raw.nam);
    }
}
