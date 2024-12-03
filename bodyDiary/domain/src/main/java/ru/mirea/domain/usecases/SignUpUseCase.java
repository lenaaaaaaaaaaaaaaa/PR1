package ru.mirea.domain.usecases;

import ru.mirea.domain.repository.AuthRepository;
import ru.mirea.domain.utils.AuthCallback;

public class SignUpUseCase {

    private final AuthRepository authRepository;

    public SignUpUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void invoke(String email, String password, String name, AuthCallback callback) {
        authRepository.signUpWithEmail(email, password, callback);
    }
}
