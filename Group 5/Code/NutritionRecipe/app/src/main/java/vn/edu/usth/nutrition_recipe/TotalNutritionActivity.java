//package vn.edu.usth.nutrition_recipe;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.viewpager.widget.ViewPager;
//// Đây là khung frame 17 //
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//import com.google.android.material.tabs.TabLayout;
//
//
//public class TotalNutritionActivity extends AppCompatActivity {
//
//    private TabLayout tabLayout;
//    private ViewPager viewPager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_total_nutrition);
//
//
//
//        View back_btn = findViewById(R.id.arrow_total_nutritions);
//        back_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(TotalNutritionActivity.this, MenuChoiceActivity.class));
//            }
//        });
//
//        tabLayout = findViewById(R.id.tablayout);
//        viewPager = findViewById(R.id.viewpager);
//        tabLayout.setupWithViewPager(viewPager);
//        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        vpAdapter.addFragment(new TotalGramsActivity(), "Total Grams");
//        vpAdapter.addFragment(new TotalCaloriesActivity(), "Total Calories");
//        viewPager.setAdapter(vpAdapter);
//
//    }
//}