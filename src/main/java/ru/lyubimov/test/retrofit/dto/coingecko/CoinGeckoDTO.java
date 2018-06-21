package ru.lyubimov.test.retrofit.dto.coingecko;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoinGeckoDTO {

    @Expose
    @SerializedName("last_updated")
    private String lastUpdated;
    @Expose
    @SerializedName("public_interest_stats")
    private PublicInterestStats publicInterestStats;
    @Expose
    @SerializedName("developer_data")
    private DeveloperData developerData;
    @Expose
    @SerializedName("community_data")
    private CommunityData communityData;
    @Expose
    @SerializedName("market_data")
    private MarketData marketData;
    @Expose
    @SerializedName("coingecko_score")
    private double coingeckoScore;
    @Expose
    @SerializedName("image")
    private Image image;
    @Expose
    @SerializedName("localization")
    private Localization localization;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("symbol")
    private String symbol;
    @Expose
    @SerializedName("id")
    private String id;

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public PublicInterestStats getPublicInterestStats() {
        return publicInterestStats;
    }

    public void setPublicInterestStats(PublicInterestStats publicInterestStats) {
        this.publicInterestStats = publicInterestStats;
    }

    public DeveloperData getDeveloperData() {
        return developerData;
    }

    public void setDeveloperData(DeveloperData developerData) {
        this.developerData = developerData;
    }

    public CommunityData getCommunityData() {
        return communityData;
    }

    public void setCommunityData(CommunityData communityData) {
        this.communityData = communityData;
    }

    public MarketData getMarketData() {
        return marketData;
    }

    public void setMarketData(MarketData marketData) {
        this.marketData = marketData;
    }

    public double getCoingeckoScore() {
        return coingeckoScore;
    }

    public void setCoingeckoScore(double coingeckoScore) {
        this.coingeckoScore = coingeckoScore;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
