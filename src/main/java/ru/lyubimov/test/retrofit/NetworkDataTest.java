package ru.lyubimov.test.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.lyubimov.test.retrofit.api.CoinGeckoApi;
import ru.lyubimov.test.retrofit.dto.CoinGeckoDTO;

import java.util.ArrayList;
import java.util.List;

public class NetworkDataTest {

    private static CoinGeckoApi coinGeckoService = new Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi.class);



    public static void main(String[] args) {
        Call<List<CoinGeckoDTO>> call = coinGeckoService.getCryptoCurrencies(500, null);
        System.out.println(call.request().toString());
        call.enqueue(new Callback<List<CoinGeckoDTO>>() {
            public void onResponse(Call<List<CoinGeckoDTO>> call, Response<List<CoinGeckoDTO>> response) {
                List<CoinGeckoDTO> list = response.body();
                System.out.println((list.size()));
                System.out.println(list.get(0).getImage().getSmall());
            }
            public void onFailure(Call<List<CoinGeckoDTO>> call, Throwable throwable) {

            }
        });
    }
}
