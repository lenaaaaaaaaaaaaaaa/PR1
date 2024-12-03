package ru.mirea.data.repository;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ru.mirea.domain.repository.AuthRepository;
import ru.mirea.domain.utils.AuthCallback;

public class AuthRepositoryImpl implements AuthRepository {
    private final FirebaseAuth firebase;

    public AuthRepositoryImpl(FirebaseAuth firebaseAuth) {
        firebase = firebaseAuth;
    }

    @Override
    public void signInWithEmail(String email, String password, AuthCallback callback) {
        firebase.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()) {
                                callback.onSuccess();
                            } else {
                                callback.onFailure();
                            }
                        }
                );
        ;
    }

    @Override
    public void signUpWithEmail(String email, String password, AuthCallback callback) {
        firebase.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()) {
                                callback.onSuccess();
                            } else {
                                callback.onFailure();
                            }
                        }
                );
    }

    @Override
    public void logOut() {
        firebase.signOut();
    }

    @Override
    public Boolean isThereAUser() {
        return firebase.getCurrentUser() != null;
    }

}
