package vn.edu.usth.nutrition_recipe;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
//DAY LA FRAME 1
public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Inflate the layout for this fragment
//        FrameLayout view = new FrameLayout(getContext());
//
//        view.setBackgroundColor(Color.BLUE);
//
//        TextView tv = new TextView(getContext());
//
//        tv.setText("Nutrition - Recipe");
//        tv.setTextColor(Color.WHITE);

        return inflater.inflate(R.layout.fragment_login, container, false);
    }


}