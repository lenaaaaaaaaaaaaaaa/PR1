package ru.mirea.recyclerviewapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryRecyclerViewAdapter extends RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder> {
    private List<Country> countries;
    private Context context;

    public CountryRecyclerViewAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        context = parent.getContext();
        View recyclerViewItem =
                LayoutInflater.from(context).inflate(R.layout.country_item_view, parent, false);
        return new CountryViewHolder(recyclerViewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = this.countries.get(position);
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(country.getFlagName(), "drawable", pkgName);
        holder.getFlagView().setImageResource(resID);
        holder.getCountryNameView().setText(country.getCountryName());
        holder.getPopulationView().setText("Population: " + country.getPopulation());
    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
        private ImageView flagView;
        private TextView countryNameView;
        private TextView populationView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.flagView = itemView.findViewById(R.id.imageView);
            this.countryNameView = itemView.findViewById(R.id.textViewCountryName);
            this.populationView = itemView.findViewById(R.id.textViewPopulation);
        }
        public ImageView getFlagView() {
            return flagView;
        }
        public TextView getCountryNameView() {
            return countryNameView;
        }
        public TextView getPopulationView() {
            return populationView;
        }
    }
}
