package ru.lyubimov.test.retrofit.dto.coingecko;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicInterestStats {
    @Expose
    @SerializedName("bing_matches")
    private int bingMatches;
    @Expose
    @SerializedName("alexa_rank")
    private int alexaRank;

    public int getBingMatches() {
        return bingMatches;
    }

    public void setBingMatches(int bingMatches) {
        this.bingMatches = bingMatches;
    }

    public int getAlexaRank() {
        return alexaRank;
    }

    public void setAlexaRank(int alexaRank) {
        this.alexaRank = alexaRank;
    }
}
