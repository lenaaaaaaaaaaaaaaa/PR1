package ru.mirea.retrofitapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mirea.retrofitapp.adapter.TodoAdapter;
import ru.mirea.retrofitapp.model.Todo;
import ru.mirea.retrofitapp.network.ApiService;
import ru.mirea.retrofitapp.network.RetrofitClient;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        fetchTodos();
    }

    private void fetchTodos() {
        Call<List<Todo>> call = apiService.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Todo> todos = response.body();
                    todoAdapter = new TodoAdapter(todos,(todo, isChecked) -> {
                        apiService.updateTodo(todo.getId(), todo);
                    } );
                    recyclerView.setAdapter(todoAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}