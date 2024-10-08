package ru.mirea.nadezhkinaea.bodydiary.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.nadezhkinaea.bodydiary.R;
import ru.mirea.nadezhkinaea.bodydiary.domain.models.Parametrs;
import ru.mirea.nadezhkinaea.bodydiary.domain.usecases.parametrs.GetMyParametrsUseCase;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textViewWord);
        findViewById(R.id.buttonGetWord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Parametrs p = new GetMyParametrsUseCase().execute();
                textView.setText(String.format(p.getName()));
            }
        });

    }
}