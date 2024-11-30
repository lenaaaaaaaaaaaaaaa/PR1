package ru.mirea.data.storage;

import android.content.Context;
import android.content.SharedPreferences;

import  ru.mirea.data.storage.model.Movie;

public class SharedPrefMovieStorage implements MovieStorage {

    private static final String PREFS_NAME = "favorite_movie_prefs";
    private static final String KEY_MOVIE_NAME = "movie_name";
    private static final String KEY_MOVIE_ID = "movie_id";
    private static final String KEY_MOVIE_DATE = "movie_date";
    private final SharedPreferences sharedPreferences;

    public SharedPrefMovieStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
    @Override
    public Movie get() {
        int id = sharedPreferences.getInt(KEY_MOVIE_ID, -1);
        String name = sharedPreferences.getString(KEY_MOVIE_NAME, null);
        String date = sharedPreferences.getString(KEY_MOVIE_DATE, null);

        if (id == -1 || name == null || date == null) {
            return null;
        }

        return new Movie(id, name, date);
    }

    @Override
    public boolean save(Movie movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_MOVIE_ID, movie.getId());
        editor.putString(KEY_MOVIE_NAME, movie.getName());
        editor.putString(KEY_MOVIE_DATE, movie.getLocalDate());
        return editor.commit();
    }
}
