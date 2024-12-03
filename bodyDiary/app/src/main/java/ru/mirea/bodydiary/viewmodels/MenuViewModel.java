package ru.mirea.bodydiary.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

import java.util.function.Supplier;

public class MenuViewModel extends ViewModel {

    private final LoginViewModel loginViewModel;
    private final Router router;

    public MenuViewModel(LoginViewModel loginViewModel, Router router) {
        this.loginViewModel = loginViewModel;
        this.router = router;
    }

    public MutableLiveData<Boolean> getAuthStatus() {
        return loginViewModel.getLoginStatus();
    }

    public void navigateTo(Supplier<Controller> screen) {
        try {
            router.pushController(
                    RouterTransaction.with(screen.get())
            );
        } catch (Exception ignore) {
        }
    }
}
