package ru.lyubimov.test.retrofit.dto.nintyninecoins;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @Expose
    @SerializedName("last_updated")
    private String lastUpdated;
    @Expose
    @SerializedName("total_supply")
    private String totalSupply;
    @Expose
    @SerializedName("available_supply")
    private String availableSupply;
    @Expose
    @SerializedName("ranking_market_cap")
    private String rankingMarketCap;
    @Expose
    @SerializedName("ranking_volume")
    private String rankingVolume;
    @Expose
    @SerializedName("percent_change_7d")
    private String percentChange7d;
    @Expose
    @SerializedName("percent_change_btc_24h")
    private String percentChangeBtc24h;
    @Expose
    @SerializedName("percent_change_24h")
    private String percentChange24h;
    @Expose
    @SerializedName("percent_change_1h")
    private String percentChange1h;
    @Expose
    @SerializedName("market_cap_usd")
    private String marketCapUsd;
    @Expose
    @SerializedName("volume_usd_24h")
    private String volumeUsd24h;
    @Expose
    @SerializedName("price_btc")
    private String priceBtc;
    @Expose
    @SerializedName("price_usd")
    private String priceUsd;
    @Expose
    @SerializedName("symbol")
    private String symbol;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private String id;

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public String getRankingMarketCap() {
        return rankingMarketCap;
    }

    public String getRankingVolume() {
        return rankingVolume;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public String getPercentChangeBtc24h() {
        return percentChangeBtc24h;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public String getVolumeUsd24h() {
        return volumeUsd24h;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
