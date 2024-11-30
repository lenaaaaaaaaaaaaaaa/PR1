package ru.mirea.lesson11;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.domain.models.Movie;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

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

        Log.d(MainActivity.class.getSimpleName(), "MainActivity created");
        viewModel = new ViewModelProvider(
                this,
                new ViewModelFactory(this)
        ).get(MainViewModel.class);

        EditText editText = findViewById(R.id.editTextText);
        TextView textView = findViewById(R.id.textView);

        viewModel.getFavoriteMovie().observe(this, textView::setText);

        findViewById(R.id.buttonSaveMovie).setOnClickListener(view ->
            viewModel.setText(new Movie(2, editText.getText().toString()))
        );
        findViewById(R.id.buttonGetMovie).setOnClickListener(view ->
                viewModel.getText()
        );
    }
}