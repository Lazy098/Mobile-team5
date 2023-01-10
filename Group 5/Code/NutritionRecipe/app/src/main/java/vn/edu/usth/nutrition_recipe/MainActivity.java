package vn.edu.usth.nutrition_recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//ACTIVITY DAU APP
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t.start();

        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {

            }
        };

        Bundle bundle = new Bundle();
        bundle.putString("server_response", "some json here");
        Message msg = new Message();
        msg.setData(bundle);
        handler.sendMessage(msg);


        final MediaPlayer dragon = MediaPlayer.create(this,R.raw.snoringsound);
        Button press_dragon_tight = (Button) this.findViewById(R.id.signUp);

        final MediaPlayer siu = MediaPlayer.create(this,R.raw.siu);
        Button press_siu = (Button) this.findViewById(R.id.login);

        press_siu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siu.start();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });


        press_dragon_tight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dragon.start();
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

        Log.i("Activity Lifecycle", "onCreate");

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity Lifecycle", "onResume");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity Lifecycle", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity Lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity Lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity Lifecycle", "onDestroy");
    }
}