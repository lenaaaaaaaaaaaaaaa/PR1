package ru.mirea.bodydiary.viewmodels;

import androidx.lifecycle.ViewModel;

import ru.mirea.domain.repository.AuthRepository;
import ru.mirea.domain.repository.UserRepository;

public class ProfileViewModel extends ViewModel {

    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    public ProfileViewModel(AuthRepository authRepository, UserRepository userRepository) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
    }

    public void logOut() {
        authRepository.logOut();
        userRepository.logOut();
    }

    public String getName() {
        return userRepository.getCurrentUser().getName();
    }
}
