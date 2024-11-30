package ru.mirea.data.storage;

import  ru.mirea.data.storage.model.Movie;

public interface MovieStorage {
    Movie get();

    boolean save(Movie movie);
}
