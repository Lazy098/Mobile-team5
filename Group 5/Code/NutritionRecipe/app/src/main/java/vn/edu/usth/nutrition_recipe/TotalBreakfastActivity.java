package vn.edu.usth.nutrition_recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//DAY LA FRAME 10
public class TotalBreakfastActivity extends AppCompatActivity {
    MenuBuilder menuBuilder;
    Button menu_show;
    Button Save;
    EditText text_energy, text_fat, text_carbohydrate, text_protein, text_vitamin;
    String st_1, st_2, st_3, st_4, st_5;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_breakfast);

        Save = (Button) findViewById(R.id.save_total_breakfast);
        text_energy = (EditText) findViewById(R.id.edittext_energy_breakfast);
        text_fat = (EditText) findViewById(R.id.edittext_fat_breakfast);
        text_carbohydrate = (EditText) findViewById(R.id.edittext_carbohydrate_breakfast);
        text_protein = (EditText) findViewById(R.id.edittext_protein_breakfast);
        text_vitamin = (EditText) findViewById(R.id.edittext_vitamin_breakfast);

        // to Retrieve the Data from Sharepreferences

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String st1 = pref.getString("st1breakfast", "");
        text_energy.setText(st1);
        String st2 = pref.getString("st2breakfast", "");
        text_fat.setText(st2);
        String st3 = pref.getString("st3breakfast", "");
        text_carbohydrate.setText(st3);
        String st4 = pref.getString("st4breakfast", "");
        text_protein.setText(st4);
        String st5 = pref.getString("st5breakfast", "");
        text_vitamin.setText(st5);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st_1 = text_energy.getText().toString();
                st_2 = text_fat.getText().toString();
                st_3 = text_carbohydrate.getText().toString();
                st_4 = text_protein.getText().toString();
                st_5 = text_vitamin.getText().toString();

                // To save the data
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(TotalBreakfastActivity.this);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("st1breakfast", st_1);
                editor.putString("st2breakfast", st_2);
                editor.putString("st3breakfast", st_3);
                editor.putString("st4breakfast", st_4);
                editor.putString("st5breakfast", st_5);
                editor.apply();
                Toast.makeText(TotalBreakfastActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_in_total, menuBuilder);
        menu_show = (Button) findViewById(R.id.menu_in_total);

        menu_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuPopupHelper optionMenu = new MenuPopupHelper(TotalBreakfastActivity.this, menuBuilder, view);
                optionMenu.setForceShowIcon(true);

                menuBuilder.setCallback(new MenuBuilder.Callback() {
                    @Override
                    public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item1_in_total:
                                startActivity(new Intent(TotalBreakfastActivity.this, BreakfastListActivity.class));
                                return true;
                            case R.id.item2_in_total:
                                startActivity(new Intent(TotalBreakfastActivity.this, CalculatorBreakfastActivity.class));
                                return true;
                            case R.id.item3_in_total:
                                startActivity(new Intent(TotalBreakfastActivity.this, BreakfastActivity.class));
                                return true;
                            default:
                                return false;
                        }
                    }

                    @Override
                    public void onMenuModeChange(@NonNull MenuBuilder menu) {

                    }
                });

                optionMenu.show();
            }
        });

        View btn = findViewById(R.id.arrow_total_breakfast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TotalBreakfastActivity.this, MainPageActivity.class));

            }
        });

    }
}