package ru.mirea.recyclerviewapp_hw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoricalEventRecyclerViewAdapter extends RecyclerView.Adapter<HistoricalEventRecyclerViewAdapter.EventViewHolder> {
    private List<HistoricalEvent> events;

    public HistoricalEventRecyclerViewAdapter(List<HistoricalEvent> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item_view, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        HistoricalEvent event = events.get(position);
        holder.getEventNameView().setText(event.getEventName());
        holder.getDescriptionView().setText(event.getDescription());
        holder.getEventImageView().setImageResource(event.getImageResId());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        private ImageView eventImageView;
        private TextView eventNameView;
        private TextView descriptionView;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventImageView = itemView.findViewById(R.id.imageView);
            eventNameView = itemView.findViewById(R.id.textViewEventName);
            descriptionView = itemView.findViewById(R.id.textViewDescription);
        }

        public ImageView getEventImageView() {
            return eventImageView;
        }

        public TextView getEventNameView() {
            return eventNameView;
        }

        public TextView getDescriptionView() {
            return descriptionView;
        }
    }
}
