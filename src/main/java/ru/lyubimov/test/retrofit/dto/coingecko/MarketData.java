package ru.lyubimov.test.retrofit.dto.coingecko;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarketData {
    @Expose
    @SerializedName("circulating_supply")
    private String circulatingSupply;
    @Expose
    @SerializedName("volume_change_percentage_24h")
    private String volumeChangePercentage24h;
    @Expose
    @SerializedName("volume_change_24h")
    private String volumeChange24h;
    @Expose
    @SerializedName("market_cap_change_percentage_24h")
    private String marketCapChangePercentage24h;
    @Expose
    @SerializedName("market_cap_change_24h")
    private String marketCapChange24h;
    @Expose
    @SerializedName("price_change_percentage_24h")
    private String priceChangePercentage24h;
    @Expose
    @SerializedName("price_change_24h")
    private String priceChange24h;
    @Expose
    @SerializedName("low")
    private Low low;
    @Expose
    @SerializedName("high")
    private High high;
    @Expose
    @SerializedName("total_volume")
    private TotalVolume totalVolume;
    @Expose
    @SerializedName("market_cap")
    private MarketCap marketCap;
    @Expose
    @SerializedName("current_price")
    private CurrentPrice currentPrice;

    public String getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(String circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public String getVolumeChangePercentage24h() {
        return volumeChangePercentage24h;
    }

    public void setVolumeChangePercentage24h(String volumeChangePercentage24h) {
        this.volumeChangePercentage24h = volumeChangePercentage24h;
    }

    public String getVolumeChange24h() {
        return volumeChange24h;
    }

    public void setVolumeChange24h(String volumeChange24h) {
        this.volumeChange24h = volumeChange24h;
    }

    public String getMarketCapChangePercentage24h() {
        return marketCapChangePercentage24h;
    }

    public void setMarketCapChangePercentage24h(String marketCapChangePercentage24h) {
        this.marketCapChangePercentage24h = marketCapChangePercentage24h;
    }

    public String getMarketCapChange24h() {
        return marketCapChange24h;
    }

    public void setMarketCapChange24h(String marketCapChange24h) {
        this.marketCapChange24h = marketCapChange24h;
    }

    public String getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }

    public void setPriceChangePercentage24h(String priceChangePercentage24h) {
        this.priceChangePercentage24h = priceChangePercentage24h;
    }

    public String getPriceChange24h() {
        return priceChange24h;
    }

    public void setPriceChange24h(String priceChange24h) {
        this.priceChange24h = priceChange24h;
    }

    public Low getLow() {
        return low;
    }

    public void setLow(Low low) {
        this.low = low;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public TotalVolume getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(TotalVolume totalVolume) {
        this.totalVolume = totalVolume;
    }

    public MarketCap getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(MarketCap marketCap) {
        this.marketCap = marketCap;
    }

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }
}
