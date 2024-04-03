package ru.mirea.nadezhkinaea.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view){
        EditText editText = findViewById(R.id.editTextText);
        int count = editText.length();
        Toast.makeText(getApplicationContext(),"СТУДЕНТ № 16 ГРУППА БСБО-10-21 Количество символов - " + count, Toast.LENGTH_SHORT).show();
    }
}