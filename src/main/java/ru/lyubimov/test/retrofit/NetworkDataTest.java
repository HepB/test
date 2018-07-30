package ru.lyubimov.test.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.lyubimov.test.retrofit.api.CoinGeckoApi;
import ru.lyubimov.test.retrofit.api.NintyNineCoinsApi;
import ru.lyubimov.test.retrofit.dto.coingecko.CoinGeckoDTO;
import ru.lyubimov.test.retrofit.dto.nintyninecoins.NintyCoinsDTO;
import ru.lyubimov.test.retrofit.dto.nintyninecoins.Result;

import java.util.List;

public class NetworkDataTest {

    public static void main(String[] args) {
        //testCoinGeckoService();
        test99CoinsService();
    }

    private static void testCoinGeckoService() {
        String logMessage = "Coingecko api return: ";

        CoinGeckoApi coinGeckoService = new Retrofit.Builder()
                .baseUrl("https://api.coingecko.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinGeckoApi.class);

        Call<List<CoinGeckoDTO>> call = coinGeckoService.getCryptoCurrencies(500, null);
        System.out.println(call.request().toString());
        call.enqueue(new Callback<List<CoinGeckoDTO>>() {
            public void onResponse(Call<List<CoinGeckoDTO>> call, Response<List<CoinGeckoDTO>> response) {
                List<CoinGeckoDTO> list = response.body();
                System.out.println(logMessage + (list.size()));
                System.out.println(list.size());
            }
            public void onFailure(Call<List<CoinGeckoDTO>> call, Throwable throwable) {

            }
        });
    }

    private static void test99CoinsService() {
        String logMessage = "99 api return: ";

        NintyNineCoinsApi nintyNineCoinsService = new Retrofit.Builder()
                .baseUrl("https://api.99cryptocoin.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NintyNineCoinsApi.class);

        Call<NintyCoinsDTO> call = nintyNineCoinsService.getCryptoCurrencies();
        System.out.println(call.request().toString());
        call.enqueue(new Callback<NintyCoinsDTO>() {
            @Override
            public void onResponse(Call<NintyCoinsDTO> call, Response<NintyCoinsDTO> response) {
                List<Result> list = response.body().getResult();
                //System.out.println(response.body().getResult());
                System.out.println(logMessage + (list.size()));
                System.out.println(list.get(0).getPriceUsd());
            }

            @Override
            public void onFailure(Call<NintyCoinsDTO> call, Throwable throwable) {

            }
        });
    }
}
