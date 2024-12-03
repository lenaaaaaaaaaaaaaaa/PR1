package ru.mirea.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.mirea.data.room.entity.CatEntity;

@Dao
public interface CatDao {


    @Insert
    void insertCat(CatEntity cat);
    @Query("SELECT * FROM cats")
    List<CatEntity> getAllCats();

    @Query("DELETE FROM cats")
    void deleteAllCats();
}
