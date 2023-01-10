package vn.edu.usth.nutrition_recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BackgroundMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_music);

        View backfrommusicbtn = findViewById(R.id.arrow_background_music);
        backfrommusicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BackgroundMusicActivity.this, MenuChoiceActivity.class));
            }
        });
    }

    public void PlaySound1(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundService.class);
        startService(intent);
    }

    public void StopSound1(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundService.class);
        stopService(intent);
    }

    public void PlaySound2(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundService2.class);
        startService(intent);
    }

    public void StopSound2(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundService2.class);
        stopService(intent);
    }

    public void PlaySoundNam(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceNam.class);
        startService(intent);
    }

    public void StopSoundNam(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceNam.class);
        stopService(intent);
    }

    public void PlaySoundNghia(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceNghia.class);
        startService(intent);
    }

    public void StopSoundNghia(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceNghia.class);
        stopService(intent);
    }

    public void PlaySoundSon(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceSon.class);
        startService(intent);
    }

    public void StopSoundSon(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceSon.class);
        stopService(intent);
    }

    public void PlaySoundTrung(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceTrung.class);
        startService(intent);
    }

    public void StopSoundTrung(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceTrung.class);
        stopService(intent);
    }

    public void PlaySoundHuy(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceHuy.class);
        startService(intent);
    }

    public void StopSoundHuy(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceHuy.class);
        stopService(intent);
    }

    public void PlaySoundVinh(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceVinh.class);
        startService(intent);
    }

    public void StopSoundVinh(View view){
        Intent intent = new Intent(BackgroundMusicActivity.this, BackgroundSoundServiceVinh.class);
        stopService(intent);
    }
}