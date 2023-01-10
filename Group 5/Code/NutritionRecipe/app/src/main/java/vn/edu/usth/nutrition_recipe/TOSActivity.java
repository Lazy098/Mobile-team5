package vn.edu.usth.nutrition_recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class TOSActivity extends AppCompatActivity {

    private CheckBox checkbox_agree;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_t_o_s);

        checkbox_agree = findViewById(R.id.checkbox_agree);
        boolean isChecked = checkbox_agree.isChecked();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isNotifyTurnedOn = sharedPreferences.getBoolean("notification", true);

        checkbox_agree.setChecked(isNotifyTurnedOn);

        checkbox_agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    // it is checked
                    // notifi...turn on
                    sharedPreferences.edit().putBoolean("notification",true).apply();
                } else {
                    // if it is not Checked
                    // notifi...turn off
                    sharedPreferences.edit().putBoolean("notification",false).apply();
                }
            }
        });

        View FAQS_btn = findViewById(R.id.arrow_term_of_service);
        FAQS_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TOSActivity.this, HelpsActivity.class));
            }
        });
    }
}