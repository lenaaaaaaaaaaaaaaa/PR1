package ru.mirea.bodydiary.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.bodydiary.R;
import ru.mirea.domain.model.Cat;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private final List<Cat> cats = new ArrayList<>();

    public void setCats(List<Cat> newCats) {
        cats.clear();
        cats.addAll(newCats);
        //notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cats_item, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = cats.get(position);
        Picasso.get()
                .load(cat.getImageUrl())
                .into(holder.catImage);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    static class CatViewHolder extends RecyclerView.ViewHolder {
        final ImageView catImage;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            catImage = itemView.findViewById(R.id.cat_image);
        }
    }
}
