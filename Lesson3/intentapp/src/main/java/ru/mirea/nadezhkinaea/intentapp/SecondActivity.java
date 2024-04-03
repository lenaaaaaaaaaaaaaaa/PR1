package ru.mirea.nadezhkinaea.intentapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.textView);

        if (getIntent().getExtras() != null) {
            textView.setText("КВАДРАТ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ 256,\n а текущее время " + getIntent().getStringExtra("date"));
        }
    }
}
