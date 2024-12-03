package ru.mirea.data.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import ru.mirea.domain.model.Cat;

public interface CatRepository {

    LiveData<List<Cat>> getAllCats();
}
