package ru.mirea.bodydiary.controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.bluelinelabs.conductor.Controller;

import java.util.function.Supplier;

import ru.mirea.bodydiary.R;
import ru.mirea.bodydiary.viewmodels.MenuViewModel;
import ru.mirea.di.ViewModelFactory;

public class MenuController extends Controller {

    private MenuViewModel viewModel;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedViewState) {
        View view = inflater.inflate(R.layout.menu_controller, container, false);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) getActivity(), new ViewModelFactory()).get(MenuViewModel.class);
        initAuthButtons(view);
        initGeneralButtons(view);
        return view;

    }

    private void initGeneralButtons(View view) {
        LinearLayout layout = view.findViewById(R.id.menuContainer);
        addButton(layout, "Полезная информация", () -> navigateTo(UsefulInfoController::new));
        addButton(layout, "Обратная связь", () -> navigateTo(FeedbackController::new));
        addButton(layout, "Контакты", () -> navigateTo(ContactsController::new));
        addButton(layout, "Котики", () -> navigateTo(CatsController::new));
    }

    private void initAuthButtons(View view) {
        LinearLayout layout = view.findViewById(R.id.menuContainer);
        viewModel.getAuthStatus().observe((LifecycleOwner) getActivity(), status -> {
            if (status) {
                addButton(layout, "Внести параметры тела", () -> navigateTo(AddParamsController::new));
                addButton(layout, "Посмотреть динамику", () -> navigateTo(DynamicController::new));
                addButton(layout, "Текущий статус", () -> navigateTo(StatusController::new));
            }
        });
    }

    private void addButton(ViewGroup layout, String text, Runnable onClick) {
        TextView button = new TextView(layout.getContext());
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        button.setText(text);
        button.setTextColor(layout.getContext().getColor(R.color.black));
        button.setOnClickListener(v -> onClick.run());

        int marginInPixels = (int) (16 * layout.getContext().getResources().getDisplayMetrics().density);
        params.setMargins(marginInPixels, marginInPixels, marginInPixels, marginInPixels);

        button.setTextSize(20f);

        button.setLayoutParams(params);
        layout.addView(button);
    }

    private void navigateTo(Supplier<Controller> screen) {
        viewModel.navigateTo(screen);
    }
}
