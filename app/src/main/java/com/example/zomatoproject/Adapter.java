package com.example.zomatoproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<BestRatedResturant> bestRatedResturants;

    public Adapter(List<BestRatedResturant> bestRatedResturants) {
        this.bestRatedResturants = bestRatedResturants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(bestRatedResturants.get(0).getRestaurant());
    }

    @Override
    public int getItemCount() {
        return bestRatedResturants.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cityName, resturantName, locality, address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.id_city);
            resturantName = itemView.findViewById(R.id.id_name);
            locality = itemView.findViewById(R.id.id_locality);
            address = itemView.findViewById(R.id.id_address);
        }

        public void bindData(Restaurant restaurant) {
            cityName.setText(restaurant.getRestaurantLocation().getCity());
            resturantName.setText(restaurant.getRestaurantName());
            locality.setText(restaurant.getRestaurantLocation().getLocality());
            address.setText(restaurant.getRestaurantLocation().getAddress());

        }
    }
}
