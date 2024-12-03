package ru.mirea.data.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mirea.data.api.CatApiService;
import ru.mirea.data.api.RetrofitClient;
import ru.mirea.domain.model.Cat;

public class RetrofitCatRepository implements CatRepository {

    private final CatApiService apiService;
    private MutableLiveData<List<Cat>> cats = new MutableLiveData<>();

    public RetrofitCatRepository() {
        this.apiService = RetrofitClient.getInstance().create(CatApiService.class);
        fetchCats();
    }
    private void fetchCats() {
        apiService.getCats(10).enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cats.postValue(response.body());
                } else {
                    Log.d("AAAA","Error fetching cats: " + response.errorBody());
                    cats.postValue(Collections.emptyList());
                }
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {
                Log.d("AAAA","Failed to fetch cats: " + t.getMessage());
                cats.postValue(Collections.emptyList());
            }
        });
    }

    @Override
    public LiveData<List<Cat>> getAllCats() {
        return cats;
    }
}
