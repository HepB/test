package ru.lyubimov.test.retrofit.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommunityData {
    @Expose
    @SerializedName("reddit_accounts_active_48h")
    private int redditAccountsActive48h;
    @Expose
    @SerializedName("reddit_subscribers")
    private int redditSubscribers;
    @Expose
    @SerializedName("reddit_average_comments_48h")
    private double redditAverageComments48h;
    @Expose
    @SerializedName("reddit_average_posts_48h")
    private double redditAveragePosts48h;
    @Expose
    @SerializedName("twitter_followers")
    private int twitterFollowers;
    @Expose
    @SerializedName("facebook_likes")
    private int facebookLikes;

    public int getRedditAccountsActive48h() {
        return redditAccountsActive48h;
    }

    public void setRedditAccountsActive48h(int redditAccountsActive48h) {
        this.redditAccountsActive48h = redditAccountsActive48h;
    }

    public int getRedditSubscribers() {
        return redditSubscribers;
    }

    public void setRedditSubscribers(int redditSubscribers) {
        this.redditSubscribers = redditSubscribers;
    }

    public double getRedditAverageComments48h() {
        return redditAverageComments48h;
    }

    public void setRedditAverageComments48h(double redditAverageComments48h) {
        this.redditAverageComments48h = redditAverageComments48h;
    }

    public double getRedditAveragePosts48h() {
        return redditAveragePosts48h;
    }

    public void setRedditAveragePosts48h(double redditAveragePosts48h) {
        this.redditAveragePosts48h = redditAveragePosts48h;
    }

    public int getTwitterFollowers() {
        return twitterFollowers;
    }

    public void setTwitterFollowers(int twitterFollowers) {
        this.twitterFollowers = twitterFollowers;
    }

    public int getFacebookLikes() {
        return facebookLikes;
    }

    public void setFacebookLikes(int facebookLikes) {
        this.facebookLikes = facebookLikes;
    }
}
