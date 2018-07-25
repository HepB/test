package ru.lyubimov.test.retrofit.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.lyubimov.test.retrofit.dto.coingecko.CoinGeckoDTO;

import java.util.List;

public interface CoinGeckoApi {

    @GET("api/v3/coins/")
    Call<List<CoinGeckoDTO>> getCryptoCurrencies(@Query("per_page") Integer num, @Query("page") Integer page);
}
