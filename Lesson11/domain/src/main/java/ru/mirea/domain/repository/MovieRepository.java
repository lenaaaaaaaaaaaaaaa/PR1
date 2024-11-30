package ru.mirea.domain.repository;


import ru.mirea.domain.models.Movie;

public interface MovieRepository {
    boolean saveMovie(Movie movie);
    Movie getMovie();
}