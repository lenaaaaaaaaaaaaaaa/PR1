package ru.mirea.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import ru.mirea.data.room.CatDao;
import ru.mirea.data.room.CatDatabase;
import ru.mirea.data.room.entity.CatEntity;
import ru.mirea.domain.model.Cat;

public class RoomCatRepository implements CatRepository {

    private final CatDao catDao;
    private final ExecutorService executorService;
    MutableLiveData<List<Cat>> catsLiveData = new MutableLiveData<>();


    public RoomCatRepository(Context context) {
        CatDatabase database = CatDatabase.getDatabase(context);
        catDao = database.catDao();
        executorService = Executors.newSingleThreadExecutor();
        populateMockedCats();
    }

    private void populateMockedCats() {
        executorService.execute(() -> {
            List<CatEntity> mockedCats = Arrays.asList(
                    new CatEntity(0, "https://cataas.com/cat/says/Hello"),
                    new CatEntity(1, "https://cataas.com/cat/says/Cute"),
                    new CatEntity(2, "https://cataas.com/cat/says/Cat"),
                    new CatEntity(3, "https://cataas.com/cat/says/Cats are Cool"),
                    new CatEntity(4, "https://cataas.com/cat/says/Relax"),
                    new CatEntity(5, "https://cataas.com/cat/says/Take it easy")
            );

            executorService.execute(() -> {
                catDao.deleteAllCats();
                for (CatEntity cat : mockedCats) {
                    catDao.insertCat(cat);
                }
            });
        });
    }

    private Cat mapToDomain(CatEntity entity) {
        return new Cat(entity.getImageUrl());
    }

    @Override
    public LiveData<List<Cat>> getAllCats() {
        executorService.execute(() -> catsLiveData.postValue(
                catDao.getAllCats().stream().map(this::mapToDomain).collect(Collectors.toList()))
        );
        return catsLiveData;
    }
}
