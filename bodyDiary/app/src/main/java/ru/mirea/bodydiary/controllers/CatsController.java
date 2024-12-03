package ru.mirea.bodydiary.controllers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluelinelabs.conductor.Controller;

import ru.mirea.bodydiary.R;
import ru.mirea.bodydiary.adapters.CatAdapter;
import ru.mirea.bodydiary.viewmodels.CatViewModel;
import ru.mirea.di.ViewModelFactory;

public class CatsController extends Controller {

    private CatViewModel viewModel;
    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedViewState) {
        View view = inflater.inflate(R.layout.cats_controller, container, false);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) getActivity(), new ViewModelFactory()).get(CatViewModel.class);

        RecyclerView recycler = view.findViewById(R.id.cats_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(container.getContext()));

        viewModel.getCats().observe((LifecycleOwner) getActivity(), cats -> {
            if (cats != null) {
                CatAdapter adapter = new CatAdapter();
                adapter.setCats(cats);
                Log.d("Adapter", "!!!!");
                recycler.setAdapter(adapter);
            }
        });
        return view;
    }
}
