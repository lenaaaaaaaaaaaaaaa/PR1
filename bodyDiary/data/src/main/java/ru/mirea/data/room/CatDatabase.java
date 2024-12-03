package ru.mirea.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.mirea.data.room.entity.CatEntity;

@Database(entities = {CatEntity.class}, version = 2, exportSchema = false)
public abstract class CatDatabase extends RoomDatabase {

    private static volatile CatDatabase INSTANCE;

    public abstract CatDao catDao();

    public static CatDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CatDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), CatDatabase.class, "cat_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
