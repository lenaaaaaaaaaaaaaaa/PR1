package ru.mirea.domain.repository;

import ru.mirea.domain.utils.AuthCallback;

public interface AuthRepository {
    void signInWithEmail(String email, String password, AuthCallback callback);
    void signUpWithEmail(String email, String password, AuthCallback callback);

    void logOut();
    Boolean isThereAUser();

}
