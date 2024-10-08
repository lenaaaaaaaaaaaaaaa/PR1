package ru.mirea.nadezhkinaea.lesson9.presentation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ru.mirea.nadezhkinaea.lesson9.R;
import ru.mirea.nadezhkinaea.lesson9.data.repository.MovieRepositoryImpl;
import ru.mirea.nadezhkinaea.lesson9.domain.models.Movie;
import ru.mirea.nadezhkinaea.lesson9.domain.repository.MovieRepository;
import ru.mirea.nadezhkinaea.lesson9.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.nadezhkinaea.lesson9.domain.usecases.SaveFilmToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editText = findViewById(R.id.editTextText);
        TextView textView = findViewById(R.id.textView);
        MovieRepository movieRepository = new MovieRepositoryImpl(getBaseContext());

        findViewById(R.id.buttonSaveMovie).setOnClickListener(view -> {
            Boolean result = new SaveFilmToFavoriteUseCase(movieRepository)
                    .execute(new Movie(2, editText.getText().toString()));
            textView.setText(String.format("Save result %s", result));
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(view -> {
            Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
            textView.setText(String.format("Save result %s", movie.getName()));
        });
    }

}