package ru.mirea.bodydiary;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bluelinelabs.conductor.RouterTransaction;

import ru.mirea.bodydiary.controllers.HomeController;
import ru.mirea.bodydiary.viewmodels.MainViewModel;
import ru.mirea.di.DependenciesProvider;
import ru.mirea.di.ViewModelFactory;

public class MainActivity extends AppCompatActivity {


    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = findViewById(R.id.fragment_container);
        DependenciesProvider.getInstance(this)
                .createRouter(this, container, savedInstanceState)
                .setRoot(RouterTransaction.with(new HomeController()));

        viewModel = new ViewModelProvider(this, new ViewModelFactory()).get(MainViewModel.class);


        findViewById(R.id.profile_button).setOnClickListener(view -> viewModel.handleProfile());

        findViewById(R.id.menu_button).setOnClickListener(view -> viewModel.handleMenu());
    }
}