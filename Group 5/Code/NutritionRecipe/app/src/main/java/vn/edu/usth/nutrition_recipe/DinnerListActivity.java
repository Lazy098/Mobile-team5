package vn.edu.usth.nutrition_recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DinnerListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Integer> calo, fat, carbohydrate, protein, vitamin;
    ArrayList<String> foodname;
    DinnerViewAdapter adapter;
    Button menu_show;
    MenuBuilder menuBuilder;

    @SuppressLint({"MissingInflatedId", "RestrictedApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_list);

        View back_btn = findViewById(R.id.arrow_list_dinner);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DinnerListActivity.this, MainPageActivity.class));
            }
        });

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.the_menu, menuBuilder);
        menu_show = (Button) findViewById(R.id.add_more_food_dinner);

        menu_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuPopupHelper optionMenu = new MenuPopupHelper(DinnerListActivity.this, menuBuilder, view);
                optionMenu.setForceShowIcon(true);

                menuBuilder.setCallback(new MenuBuilder.Callback() {
                    @Override
                    public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item1:
                                Intent intent1 = new Intent(DinnerListActivity.this, TotalDinnerActivity.class);
                                startActivity(intent1);
                                return true;
                            case R.id.item2:
                                deleteBreakfast();
                                Intent intent = new Intent(DinnerListActivity.this, MainPageActivity.class);
                                startActivity(intent);
                                Toast.makeText(DinnerListActivity.this, "Delete Food Successfully", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item3:
                                startActivity(new Intent(DinnerListActivity.this, DinnerActivity.class));
                                return true;
                            case R.id.item4:
                                startActivity(new Intent(DinnerListActivity.this, CalculatorDinnerActivity.class));
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


        loadData();

        recyclerView = findViewById(R.id.view_dinner);

        adapter = new DinnerViewAdapter(this, foodname, calo, fat, carbohydrate, protein, vitamin);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        Food food1 = (Food) bundle.get("data1dinner");
        Food food2 = (Food) bundle.get("data2dinner");
        Food food3 = (Food) bundle.get("data3dinner");
        Food food4 = (Food) bundle.get("data4dinner");
        Food food5 = (Food) bundle.get("data5dinner");
        Food food6 = (Food) bundle.get("data6dinner");

        foodname.add(food1.getmName());

        calo.add(food2.getmCalo());

        fat.add(food3.getmFat());

        carbohydrate.add(food4.getmCarbohydrate());

        protein.add(food5.getmProtein());

        vitamin.add(food6.getmVitamin());

        saveData();

    }

    private void deleteBreakfast() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences dinner", MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences dinner", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json1 = gson.toJson(foodname);
        String json2 = gson.toJson(calo);
        String json3 = gson.toJson(fat);
        String json4 = gson.toJson(carbohydrate);
        String json5 = gson.toJson(protein);
        String json6 = gson.toJson(vitamin);
        editor.putString("task list 1 dinner", json1);
        editor.putString("task list 2 dinner", json2);
        editor.putString("task list 3 dinner", json3);
        editor.putString("task list 4 dinner", json4);
        editor.putString("task list 5 dinner", json5);
        editor.putString("task list 6 dinner", json6);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences dinner", MODE_PRIVATE);
        Gson gson = new Gson();
        String json1 = sharedPreferences.getString("task list 1 dinner", null);
        String json2 = sharedPreferences.getString("task list 2 dinner", null);
        String json3 = sharedPreferences.getString("task list 3 dinner", null);
        String json4 = sharedPreferences.getString("task list 4 dinner", null);
        String json5 = sharedPreferences.getString("task list 5 dinner", null);
        String json6 = sharedPreferences.getString("task list 6 dinner", null);
        Type type1 = new TypeToken<ArrayList<String>>() {
        }.getType();
        Type type2 = new TypeToken<ArrayList<String>>() {
        }.getType();
        Type type3 = new TypeToken<ArrayList<String>>() {
        }.getType();
        Type type4 = new TypeToken<ArrayList<String>>() {
        }.getType();
        Type type5 = new TypeToken<ArrayList<String>>() {
        }.getType();
        Type type6 = new TypeToken<ArrayList<String>>() {
        }.getType();
        foodname = gson.fromJson(json1, type1);
        calo = gson.fromJson(json2, type2);
        fat = gson.fromJson(json3, type3);
        carbohydrate = gson.fromJson(json4, type4);
        protein = gson.fromJson(json5, type5);
        vitamin = gson.fromJson(json6, type6);

        if (foodname == null) {
            foodname = new ArrayList<>();
        }

        if (calo == null) {
            calo = new ArrayList<>();
        }

        if (fat == null) {
            fat = new ArrayList<>();
        }

        if (carbohydrate == null) {
            carbohydrate = new ArrayList<>();
        }

        if (protein == null) {
            protein = new ArrayList<>();
        }

        if (vitamin == null) {
            vitamin = new ArrayList<>();
        }

    }
}
