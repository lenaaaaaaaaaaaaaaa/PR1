package ru.mirea.data.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mirea.domain.model.Cat;

public interface CatApiService {
    @GET("v1/images/search")
    Call<List<Cat>> getCats(@Query("limit") int limit);
}
