package ru.mirea.domain.usecases;

import ru.mirea.domain.repository.AuthRepository;
import ru.mirea.domain.utils.AuthCallback;

public class SignInUseCase {

    private final AuthRepository authRepository;


    public SignInUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void invoke(String email, String password, AuthCallback callback) {
        authRepository.signInWithEmail(email, password, callback);
    }
}
