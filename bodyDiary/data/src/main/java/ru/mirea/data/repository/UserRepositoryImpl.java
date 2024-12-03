package ru.mirea.data.repository;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ru.mirea.domain.model.Params;
import ru.mirea.domain.model.User;
import ru.mirea.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private static final String KEY_NAME = "user_name";
    private static final String KEY_PARAMS = "user_params";
    private final SharedPreferences sharedPreferences;

    public UserRepositoryImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public boolean saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, user.getName());

        String params = user.getParams().stream()
                .map(Params::toString)
                .collect(Collectors.joining(";"));
        editor.putString(KEY_PARAMS, params);
        editor.apply();

        return true;
    }

    @Override
    public User getCurrentUser() {
        String name = sharedPreferences.getString(KEY_NAME, "");

        List<Params> params = new ArrayList<>();
        String paramsString = sharedPreferences.getString(KEY_PARAMS, "");
        if (!paramsString.isEmpty())
            params = Arrays.stream(paramsString.split(";"))
                    .map(Params::parseFromString)
                    .collect(Collectors.toList());

        return new User(name, params);
    }

    @Override
    public void logOut() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_NAME);
        editor.remove(KEY_PARAMS);
        editor.apply();
    }
}
