package vn.edu.usth.nutrition_recipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SnackViewAdapter extends RecyclerView.Adapter<SnackViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList foodname_id, calo_id, fat_id, carbohydrate_id, protein_id, vitamin_id;

    public SnackViewAdapter(Context context, ArrayList foodname_id, ArrayList calo_id, ArrayList fat_id, ArrayList carbohydrate_id, ArrayList protein_id, ArrayList vitamin_id) {
        this.context = context;
        this.foodname_id = foodname_id;
        this.calo_id = calo_id;
        this.fat_id = fat_id;
        this.carbohydrate_id = carbohydrate_id;
        this.protein_id = protein_id;
        this.vitamin_id = vitamin_id;
    }

    @NonNull
    @Override
    public SnackViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.snackentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SnackViewAdapter.MyViewHolder holder, int position) {
        holder.foodname_id.setText(String.valueOf(foodname_id.get(position)));
        holder.calo_id.setText(String.valueOf(calo_id.get(position)));
        holder.fat_id.setText(String.valueOf(fat_id.get(position)));
        holder.carbohydrate_id.setText(String.valueOf(carbohydrate_id.get(position)));
        holder.protein_id.setText(String.valueOf(protein_id.get(position)));
        holder.vitamin_id.setText(String.valueOf(vitamin_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return foodname_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView foodname_id, calo_id, fat_id, carbohydrate_id, protein_id, vitamin_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodname_id = itemView.findViewById(R.id.text_snack_foodname);
            calo_id = itemView.findViewById(R.id.text_snack_calo);
            fat_id = itemView.findViewById(R.id.snack_text_fat_gram);
            carbohydrate_id = itemView.findViewById(R.id.snack_text_carbohydrate_gram);
            protein_id = itemView.findViewById(R.id.snack_text_protein_gram);
            vitamin_id = itemView.findViewById(R.id.snack_text_vitamin_gram);
        }
    }
}
