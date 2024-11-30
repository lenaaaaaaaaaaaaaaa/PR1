package ru.mirea.scrollviewapp;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

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

        BigInteger currentValue = BigInteger.ONE;
        BigInteger ratio = BigInteger.valueOf(2);

        LinearLayout wrapper = findViewById(R.id.wrapper);
        for (int i = 0; i < 100; i++) {
            View view = getLayoutInflater().inflate(R.layout.item, null, false);
            TextView text = view.findViewById(R.id.textView);
            text.setText(String.format("%d) %d", i + 1, currentValue));
            currentValue = currentValue.multiply(ratio);
            wrapper.addView(view);
        }
    }
}