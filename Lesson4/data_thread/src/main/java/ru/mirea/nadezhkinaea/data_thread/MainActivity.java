package ru.mirea.nadezhkinaea.data_thread;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

import ru.mirea.nadezhkinaea.data_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Runnable RUN_1 = new Runnable() {
            @Override
            public void run() {
                binding.tvInfo.setText("RUN_1");
            }
        };

        final Runnable RUN_2 = new Runnable() {
            @Override
            public void run() {
                binding.tvInfo.setText("RUN_2");
            }
        };

        final Runnable RUN_3 = new Runnable() {
            @Override
            public void run() {
                binding.tvInfo.setText("RUN_3");
            }
        };

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(RUN_1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.tvInfo.postDelayed(RUN_3, 2000);
                    binding.tvInfo.post(RUN_2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}