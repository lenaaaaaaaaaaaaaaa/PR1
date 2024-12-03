package ru.mirea.domain.repository;

import ru.mirea.domain.model.User;

public interface UserRepository {

    boolean saveUser(User user);
    User getCurrentUser();

    void logOut();
}
