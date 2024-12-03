package ru.mirea.bodydiary.controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bluelinelabs.conductor.Controller;

import ru.mirea.bodydiary.R;

public class ContactsController extends Controller {
    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedViewState) {
        return inflater.inflate(R.layout.contacts_controller, container, false);
    }


    @Override
    public boolean handleBack() {
        getRouter().popCurrentController();
        return true;
    }
}
