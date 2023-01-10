package vn.edu.usth.nutrition_recipe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.nutrition_recipe.my_interface.IClickItemUserListener;
import vn.edu.usth.nutrition_recipe.my_interface.IClickItemUserListener2;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> list;
    private IClickItemUserListener iClickItemUserListener;
    private IClickItemUserListener2 iClickItemUserListener2;

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView currentFoodName,
                btn_album,
                currentCalo,
                currentFat,
                currentCarbohydrate,
                currentProtein,
                currentVitamin,
                addItem;


        public FoodViewHolder(View itemView) {
            super(itemView);
            currentFoodName = (TextView) itemView.findViewById(R.id.selected_food_name);
            currentCalo = (TextView) itemView.findViewById(R.id.selected_food_amount);
            currentFat = (TextView) itemView.findViewById(R.id.selected_food_amount_fat);
            currentCarbohydrate = (TextView) itemView.findViewById(R.id.selected_food_amount_carbohydrate);
            currentProtein = (TextView) itemView.findViewById(R.id.selected_food_amount_protein);
            currentVitamin = (TextView) itemView.findViewById(R.id.selected_food_amount_vitamin);
            addItem = (TextView) itemView.findViewById(R.id.add_item);
            btn_album = (TextView) itemView.findViewById(R.id.food_album);
        }
    }

    public FoodAdapter(List<Food> myOrders, IClickItemUserListener listener, IClickItemUserListener2 listener2) {
        this.list = myOrders;
        this.iClickItemUserListener = listener;
        this.iClickItemUserListener2 = listener2;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_food_adapter, parent, false);
        FoodViewHolder fvh = new FoodViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        final Food currentFood = list.get(position);
        holder.currentFoodName.setText(currentFood.getmName());
        holder.currentCalo.setText(currentFood.getmCalo() + " Calo, ");
        holder.currentFat.setText(currentFood.getmFat() + " g Fat, ");
        holder.currentCarbohydrate.setText(currentFood.getmCarbohydrate() + " g Carbohydrate, ");
        holder.currentProtein.setText(currentFood.getmProtein() + " g Protein, ");
        holder.currentVitamin.setText(currentFood.getmVitamin() + " g Vitamin");

        holder.btn_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemUserListener2.onClickItemUser2(currentFood);
            }
        });

        holder.addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemUserListener.onClickItemUser(currentFood);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(ArrayList<Food> filteredList) {
        list = filteredList;
        notifyDataSetChanged();
    }
}