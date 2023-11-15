package com.example.caradd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {
     Context context;
    ArrayList<Car> carList;
    private FirebaseServices fbs;

    public CarAdapter(Context context, ArrayList<Car> carList) {
        this.context = context;
        this.carList = carList;
        this.fbs = FirebaseServices.getInstance();
    }
    @NonNull
    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.rest_item,parent,false);
        return  new CarAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder holder, int position) {
        Car rest = carList.get(position);
        holder.tvModel.setText(rest.getModel());
        holder.tvYear.setText(rest.getYear());
        holder.tvPrice.setText(rest.getPrice());

    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvModel,tvPrice,tvYear;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tvModel=itemView.findViewById(R.id.tvModelRestItem);
            tvPrice=itemView.findViewById(R.id.tvPriceRestItem);
            tvYear=itemView.findViewById(R.id.tvYearRestItem);
        }
    }
}
