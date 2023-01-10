package vn.edu.usth.nutrition_recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//DAY LA FRAME 18
public class HelpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helps);

        View back_btn = findViewById(R.id.arrow_helps);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HelpsActivity.this, MenuChoiceActivity.class));
            }
        });

        View debug_logs_btn = findViewById(R.id.btn_debug_logs);
        debug_logs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HelpsActivity.this, DebugLogsActivity.class));
            }
        });

        View FAQS_btn = findViewById(R.id.btn_faq_s);
        FAQS_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HelpsActivity.this, FAQSActivity.class));
            }
        });

        View term_of_service_btn = findViewById(R.id.btn_term_of_service);
        term_of_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HelpsActivity.this, TOSActivity.class));
            }
        });
    }
}