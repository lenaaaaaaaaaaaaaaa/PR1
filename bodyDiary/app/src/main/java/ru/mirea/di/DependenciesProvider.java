package ru.mirea.di;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.google.firebase.auth.FirebaseAuth;

import ru.mirea.data.repository.AuthRepositoryImpl;
import ru.mirea.data.repository.RetrofitCatRepository;
import ru.mirea.data.repository.RoomCatRepository;
import ru.mirea.data.repository.UserRepositoryImpl;
import ru.mirea.domain.repository.AuthRepository;
import ru.mirea.domain.repository.UserRepository;
import ru.mirea.domain.usecases.SignInUseCase;
import ru.mirea.domain.usecases.SignUpUseCase;

public class DependenciesProvider {

    private static final String SHARED_PREFS_NAME = "shared_prefs_name";
    private static DependenciesProvider instance;

    private final FirebaseAuth firebaseAuth;
    private final AuthRepository authRepository;
    private Router router;

    private final SignInUseCase signInUseCase;
    private final SignUpUseCase signUpUseCase;
    private final RoomCatRepository roomCatRepository;

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    private final SharedPreferences sharedPreferences;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    private final UserRepository userRepository;

    public RetrofitCatRepository getRetrofitCatRepository() {
        return retrofitCatRepository;
    }

    private final RetrofitCatRepository retrofitCatRepository;

    private DependenciesProvider(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        firebaseAuth = FirebaseAuth.getInstance();
        authRepository = new AuthRepositoryImpl(firebaseAuth);
        signInUseCase = new SignInUseCase(authRepository);
        signUpUseCase = new SignUpUseCase(authRepository);
        userRepository = new UserRepositoryImpl(sharedPreferences);
        roomCatRepository = new RoomCatRepository(context);
        retrofitCatRepository = new RetrofitCatRepository();
    }

    public static DependenciesProvider getInstance(Context context) {
        if (instance == null && context != null) {
            instance = new DependenciesProvider(context);
        }
        return instance;
    }

    public AuthRepository getAuthRepository() {
        return authRepository;
    }

    public Router createRouter(Activity app, ViewGroup container, Bundle savedInstanceState) {
        if (router == null) {
            router = Conductor.attachRouter(app, container, savedInstanceState);
        }
        return router;
    }

    public Router getRouter() {
        return router;
    }

    public SignInUseCase getSignInUseCase() {
        return signInUseCase;
    }

    public SignUpUseCase getSignUpUseCase() {
        return signUpUseCase;
    }

    public RoomCatRepository getRoomCatRepository() {
        return roomCatRepository;
    }
}
