package ru.mirea.domain.usecases;


import ru.mirea.domain.models.Movie;
import ru.mirea.domain.repository.MovieRepository;

public class SaveFilmToFavoriteUseCase {

    private final MovieRepository movieRepository;

    public SaveFilmToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie) {
        return movieRepository.saveMovie(movie);
    }

}
