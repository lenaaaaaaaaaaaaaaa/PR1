package ru.mirea.bodydiary.viewmodels;

import androidx.lifecycle.ViewModel;

import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

import ru.mirea.bodydiary.controllers.LoginController;
import ru.mirea.bodydiary.controllers.MenuController;
import ru.mirea.bodydiary.controllers.ProfileController;
import ru.mirea.domain.repository.AuthRepository;

public class MainViewModel extends ViewModel {

    private final AuthRepository authRepository;
    private final Router router;

    public MainViewModel(AuthRepository authRepository, Router router) {
        this.authRepository = authRepository;
        this.router = router;
    }

    public void handleProfile() {
        if (authRepository.isThereAUser()) {
            router.pushController(RouterTransaction.with(new ProfileController()));
        } else {
            router.pushController(RouterTransaction.with(new LoginController()));
        }
    }

    public void handleMenu() {
        router.pushController(RouterTransaction.with(new MenuController()));
    }
}
