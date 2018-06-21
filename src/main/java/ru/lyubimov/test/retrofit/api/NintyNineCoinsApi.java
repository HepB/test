package ru.lyubimov.test.retrofit.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.lyubimov.test.retrofit.dto.nintyninecoins.NintyCoinsDTO;

public interface NintyNineCoinsApi {

    @GET("/v1/marketcap/ticker")
    Call<NintyCoinsDTO> getCryptoCurrencies();
}
