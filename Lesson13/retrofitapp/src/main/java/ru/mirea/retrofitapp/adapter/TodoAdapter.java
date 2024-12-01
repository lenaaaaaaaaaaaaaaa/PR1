package ru.mirea.retrofitapp.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.function.BiConsumer;

import ru.mirea.retrofitapp.R;
import ru.mirea.retrofitapp.model.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> todos;
    private BiConsumer<Todo, Boolean> onTodoUpdate;

    public TodoAdapter(List<Todo> todos, BiConsumer<Todo, Boolean> onTodoUpdate) {
        this.todos = todos;
        this.onTodoUpdate = onTodoUpdate;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.textViewTitle.setText(todo.getTitle());
        holder.checkBoxCompleted.setChecked(todo.getCompleted());

        holder.checkBoxCompleted.setOnCheckedChangeListener((buttonView, isChecked) -> {
            todo.setCompleted(isChecked);
            if (onTodoUpdate != null) {
                onTodoUpdate.accept(todo, isChecked);
            }
        });

        String catUrl = "https://cataas.com/cat/says/" + todo.getTitle();

        Picasso.get()
                .load(catUrl)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        CheckBox checkBoxCompleted;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            checkBoxCompleted = itemView.findViewById(R.id.checkBoxCompleted);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
