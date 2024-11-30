package ru.mirea.data.repository;

import java.time.LocalDate;

import ru.mirea.data.storage.MovieStorage;
import ru.mirea.data.storage.model.Movie;
import ru.mirea.domain.repository.MovieRepository;


public class MovieRepositoryImpl implements MovieRepository {

    private final MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage storage) {
        movieStorage = storage;
    }

    @Override
    public boolean saveMovie(ru.mirea.domain.models.Movie movie) {
        return movieStorage.save(mapToStorage(movie));
    }

    @Override
    public ru.mirea.domain.models.Movie getMovie() {
        Movie movie = movieStorage.get();
        return mapToDomain(movie);
    }

    private Movie mapToStorage(ru.mirea.domain.models.Movie movie) {
        String name = movie.getName();
        return new Movie(2, name, LocalDate.now().toString());
    }

    private ru.mirea.domain.models.Movie mapToDomain(Movie movie) {
        return new ru.mirea.domain.models.Movie(movie.getId(),movie.getName());
    }
}
