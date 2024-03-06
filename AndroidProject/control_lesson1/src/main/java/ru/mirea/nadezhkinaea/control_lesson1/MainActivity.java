package ru.mirea.nadezhkinaea.control_lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.mTextView);
        Button button = findViewById(R.id.mButton);
        CheckBox checkBox = findViewById(R.id.mCheckBox);

        textView.setText("Hello MIREA!");
        button.setText("Push ME!");
        checkBox.setText("Check or uncheck me!");
        checkBox.setChecked(true);

        setContentView(R.layout.activity_main);

    }
}