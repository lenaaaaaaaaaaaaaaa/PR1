package ru.mirea.bodydiary.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.data.repository.CatRepository;
import ru.mirea.domain.model.Cat;

public class CatViewModel extends ViewModel {

    private final CatRepository repository;

    public CatViewModel(CatRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<Cat>> getCats() {
        return repository.getAllCats();
    }
}
