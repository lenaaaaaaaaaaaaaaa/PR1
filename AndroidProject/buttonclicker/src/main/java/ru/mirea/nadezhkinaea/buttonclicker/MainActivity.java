package ru.mirea.nadezhkinaea.buttonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
        private TextView tvOut;
        private Button btnWhoAmI;
        private Button btnItsNotMe;
        private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItsNotMe = findViewById(R.id.btnItsNotMe);
        checkBox = findViewById(R.id.checkBox);

        btnWhoAmI.setOnClickListener(view -> {
            tvOut.setText("Мой номер по списку №16");
            checkBox.setChecked(true);
        });
    }
    public void onBtnItsNotMeClick(View view) {
        Toast.makeText(this, "Это не я!", Toast.LENGTH_SHORT).show();
        checkBox.setChecked(false);

    }
}