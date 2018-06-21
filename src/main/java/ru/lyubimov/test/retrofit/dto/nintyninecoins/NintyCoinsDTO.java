package ru.lyubimov.test.retrofit.dto.nintyninecoins;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NintyCoinsDTO {

    @Expose
    @SerializedName("result")
    private List<Result> result;
    @Expose
    @SerializedName("status")
    private String status;

    public List<Result> getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }
}
