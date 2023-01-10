package vn.edu.usth.nutrition_recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

//DAY LA FRAME 19->20
public class DebugLogsActivity extends AppCompatActivity {
    private CheckBox checkbox_debug_logs;
    private Button btn_clear_logs;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug_logs);

        checkbox_debug_logs = findViewById(R.id.checkbox_debug_logs);
        btn_clear_logs = findViewById(R.id.btn_clear_logs);

        boolean isChecked = checkbox_debug_logs.isChecked();
        updateButtonVisibility(isChecked);

        checkbox_debug_logs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                updateButtonVisibility(compoundButton.isChecked());
            }
        });

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isNotifyTurnedOn = sharedPreferences.getBoolean("notification", true);

        checkbox_debug_logs.setChecked(isNotifyTurnedOn);

        checkbox_debug_logs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    // it is checked
                    // notifi...turn on
                    sharedPreferences.edit().putBoolean("notification",true).apply();
                    btn_clear_logs.setVisibility(View.VISIBLE);
                } else {
                    // if it is not Checked
                    // notifi...turn off
                    sharedPreferences.edit().putBoolean("notification",false).apply();
                    btn_clear_logs.setVisibility(View.INVISIBLE);
                }
            }
        });

        View FAQS_btn = findViewById(R.id.arrow_debug_logs);
        FAQS_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DebugLogsActivity.this, HelpsActivity.class));
            }
        });
    }

    private void updateButtonVisibility(boolean isChecked) {
        if (isChecked){
            btn_clear_logs.setVisibility(View.VISIBLE);
        } else {
            btn_clear_logs.setVisibility(View.INVISIBLE);
        }
    }
}