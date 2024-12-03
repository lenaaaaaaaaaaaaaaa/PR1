package ru.mirea.bodydiary.controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.bluelinelabs.conductor.Controller;

import ru.mirea.bodydiary.R;
import ru.mirea.bodydiary.viewmodels.ProfileViewModel;
import ru.mirea.di.ViewModelFactory;

public class ProfileController extends Controller {
    private ProfileViewModel viewModel;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedViewState) {
        View view = inflater.inflate(R.layout.profile_controller, container, false);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) getActivity(), new ViewModelFactory()).get(ProfileViewModel.class);

        Button logOut = view.findViewById(R.id.logout_button);
        logOut.setOnClickListener(v -> {
            viewModel.logOut();
            getRouter().popCurrentController();
        });

        TextView name = view.findViewById(R.id.name);
        name.setText(viewModel.getName());

        return view;
    }

    @Override
    public boolean handleBack() {
        return getRouter().popToRoot();
    }
}
