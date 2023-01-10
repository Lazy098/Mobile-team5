package vn.edu.usth.nutrition_recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import vn.edu.usth.nutrition_recipe.my_interface.IClickItemUserListener;
import vn.edu.usth.nutrition_recipe.my_interface.IClickItemUserListener2;


//DAY LA FRAME 6
public class DinnerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Food> orders;
    RecyclerView.LayoutManager layoutManager;
    FoodAdapter foodAdapter;
    MenuBuilder menuBuilder;
    Button menu_show;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_in_addfood, menuBuilder);
        menu_show = (Button) findViewById(R.id.menu_in_addfood);

        menu_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuPopupHelper optionMenu = new MenuPopupHelper(DinnerActivity.this, menuBuilder, view);
                optionMenu.setForceShowIcon(true);

                menuBuilder.setCallback(new MenuBuilder.Callback() {
                    @Override
                    public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item1_in_addfood:
                                startActivity(new Intent(DinnerActivity.this, TotalDinnerActivity.class));
                                return true;
                            case R.id.item2_in_addfood:
                                startActivity(new Intent(DinnerActivity.this, DinnerListActivity.class));
                                return true;
                            case R.id.item3_in_addfood:
                                startActivity(new Intent(DinnerActivity.this, CalculatorDinnerActivity.class));
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

        createExampleList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.search_dinner);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        View bt = findViewById(R.id.arrow_dinner_addfood);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DinnerActivity.this, MainPageActivity.class));
            }
        });
    }

    private void filter(String text) {
        ArrayList<Food> filteredList = new ArrayList<>();

        for (Food item : orders) {
            if (item.getmName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        foodAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        orders = new ArrayList<>();
        orders.add(new Food("10 g Rice", 30, 1, 5, 1, 3));
        orders.add(new Food("15 g Beans", 40, 3, 3, 2, 7));
        orders.add(new Food("12 g Bread", 35, 1, 6, 1, 4));
        orders.add(new Food("14 g Meat", 50, 2, 1, 8, 3));
        orders.add(new Food("20 g Salad", 32, 1, 6, 1, 12));
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.list_item);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        foodAdapter = new FoodAdapter(orders, new IClickItemUserListener() {
            @Override
            public void onClickItemUser(Food currentItem) {
                onClickGoToDetail(currentItem);
            }
        }, new IClickItemUserListener2() {
            @Override
            public void onClickItemUser2(Food currentItem) {
                onClickGoToDetail2(currentItem);
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(foodAdapter);
    }

    private void onClickGoToDetail(Food currentItem) {

        Intent intent = new Intent(DinnerActivity.this, DinnerListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data1dinner", currentItem);
        bundle.putSerializable("data2dinner", currentItem);
        bundle.putSerializable("data3dinner", currentItem);
        bundle.putSerializable("data4dinner", currentItem);
        bundle.putSerializable("data5dinner", currentItem);
        bundle.putSerializable("data6dinner", currentItem);
        intent.putExtras(bundle);
        startActivity(intent);
        Toast.makeText(this,"New Food Added", Toast.LENGTH_SHORT).show();
    }

    private void onClickGoToDetail2(Food currentItem) {
        startActivity(new Intent(DinnerActivity.this, AlbumDinnerActivity.class));
    }
}