package vn.edu.usth.nutrition_recipe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//DAY LA FRAME 13
public class FeedbackActivity extends AppCompatActivity {

    Button feedback_noti_button;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        View back_btn = findViewById(R.id.arrow_feedback);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FeedbackActivity.this, SettingsActivity.class));
            }
        });

        feedback_noti_button = findViewById(R.id.upload_feedback);
        builder = new AlertDialog.Builder(this);

        feedback_noti_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Feedback Notification")
                        .setMessage("Bro ơi, cảm ơn bro đã feedback lại cho ae!")
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .show();
            }
        });
    }
}