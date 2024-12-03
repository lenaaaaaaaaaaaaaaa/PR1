package ru.mirea.bodydiary.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

import java.util.Collections;

import ru.mirea.bodydiary.controllers.ProfileController;
import ru.mirea.domain.model.User;
import ru.mirea.domain.repository.UserRepository;
import ru.mirea.domain.usecases.SignInUseCase;
import ru.mirea.domain.usecases.SignUpUseCase;
import ru.mirea.domain.utils.AuthCallback;

public class LoginViewModel extends ViewModel {

    private final SignInUseCase signIn;
    private final SignUpUseCase signUp;
    private final Router router;

    private final UserRepository userRepository;
    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<String> name = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loginStatus = new MutableLiveData<>();


    public LoginViewModel(UserRepository userRepository, SignInUseCase signIn, SignUpUseCase signUp, Router router) {
        this.signIn = signIn;
        this.signUp = signUp;
        this.router = router;
        this.userRepository = userRepository;
    }


    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<Boolean> getLoginStatus() {
        return loginStatus;
    }

    public void signIn() {
        signIn.invoke(email.getValue(), password.getValue(), new AuthCallback() {
            @Override
            public void onSuccess() {
                loginStatus.setValue(true);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    public void signUp() {
        signUp.invoke(email.getValue(), password.getValue(), name.getValue(), new AuthCallback() {
            @Override
            public void onSuccess() {
                userRepository.saveUser(new User(name.getValue(), Collections.emptyList()));
                loginStatus.setValue(true);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public void navigateToProfile() {
        router.pushController(RouterTransaction.with(new ProfileController()));
    }
}
