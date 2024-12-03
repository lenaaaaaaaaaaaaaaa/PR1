package ru.mirea.bodydiary.controllers;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.bluelinelabs.conductor.Controller;

import ru.mirea.bodydiary.R;
import ru.mirea.bodydiary.viewmodels.LoginViewModel;
import ru.mirea.di.ViewModelFactory;

public class LoginController extends Controller {

    private LoginViewModel viewModel;
    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedViewState) {
        View view = inflater.inflate(R.layout.login_controller, container, false);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) getActivity(), new ViewModelFactory()).get(LoginViewModel.class);
        setUpSignIn(view);
        setUpSignUp(view);
        setUpObservers();
        return view;
    }

    private void setUpObservers() {
        viewModel.getLoginStatus().observe((LifecycleOwner) getActivity(), status -> {
            if (status) {
                viewModel.navigateToProfile();
            }
        });
    }

    private void setUpSignIn(View view) {
        EditText emailField = view.findViewById(R.id.emailEditText);
        EditText passwordEditText = view.findViewById(R.id.passwordEditText);
        Button loginButton = view.findViewById(R.id.loginButton);

        emailField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                /* does nothing */
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.getEmail().setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                /* does nothing */
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                /* does nothing */
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.getPassword().setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                /* does nothing */
            }
        });

        loginButton.setOnClickListener(v -> viewModel.signIn());
    }

    private void setUpSignUp(View view) {
        EditText emailField = view.findViewById(R.id.registerEmailEditText);
        EditText passwordEditText = view.findViewById(R.id.registerPasswordEditText);
        EditText nameEditText = view.findViewById(R.id.registerNameEditText);
        Button loginButton = view.findViewById(R.id.signUpButton);

        emailField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                /* does nothing */
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.getEmail().setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                /* does nothing */
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                /* does nothing */
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.getPassword().setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                /* does nothing */
            }
        });

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                /* does nothing */
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.getName().setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                /* does nothing */
            }
        });

        loginButton.setOnClickListener(v -> viewModel.signUp());
    }
}
