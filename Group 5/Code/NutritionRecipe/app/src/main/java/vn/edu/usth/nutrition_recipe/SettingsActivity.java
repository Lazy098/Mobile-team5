package vn.edu.usth.nutrition_recipe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//DAY LA FRAME 9
public class SettingsActivity extends AppCompatActivity {
    private Button delete_btn;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        View backbtn = findViewById(R.id.arrow_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, MenuChoiceActivity.class));
            }
        });

        View about_us_btn = findViewById(R.id.aboutus);
        about_us_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, AboutUsActivity.class));
            }
        });

        View comtact_btn = findViewById(R.id.contact);
        comtact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, ContactActivity.class));
            }
        });

        View feed_back_btn = findViewById(R.id.feedback);
        feed_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, FeedbackActivity.class));
            }
        });

        View credits_btn = findViewById(R.id.credits);
        credits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, CreditActivity.class));
            }
        });

        delete_btn = (Button) findViewById(R.id.delete_account);
        builder = new AlertDialog.Builder(this);
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Delete User?")
                        .setMessage("Do you really want to delete your account?\n\nNote: You can not undo this action!")
                        .setPositiveButton(Html.fromHtml("<font color='#FF453A'>Confirm</font>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SettingsActivity.this, DeleteChoiceActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
            }
        });
    }
}