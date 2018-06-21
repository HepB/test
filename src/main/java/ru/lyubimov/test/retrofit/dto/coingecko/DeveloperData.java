package ru.lyubimov.test.retrofit.dto.coingecko;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeveloperData {
    @Expose
    @SerializedName("commit_count_4_weeks")
    private int commitCount4Weeks;
    @Expose
    @SerializedName("pull_request_contributors")
    private int pullRequestContributors;
    @Expose
    @SerializedName("pull_requests_merged")
    private int pullRequestsMerged;
    @Expose
    @SerializedName("closed_issues")
    private int closedIssues;
    @Expose
    @SerializedName("total_issues")
    private int totalIssues;
    @Expose
    @SerializedName("subscribers")
    private int subscribers;
    @Expose
    @SerializedName("stars")
    private int stars;
    @Expose
    @SerializedName("forks")
    private int forks;

    public int getCommitCount4Weeks() {
        return commitCount4Weeks;
    }

    public void setCommitCount4Weeks(int commitCount4Weeks) {
        this.commitCount4Weeks = commitCount4Weeks;
    }

    public int getPullRequestContributors() {
        return pullRequestContributors;
    }

    public void setPullRequestContributors(int pullRequestContributors) {
        this.pullRequestContributors = pullRequestContributors;
    }

    public int getPullRequestsMerged() {
        return pullRequestsMerged;
    }

    public void setPullRequestsMerged(int pullRequestsMerged) {
        this.pullRequestsMerged = pullRequestsMerged;
    }

    public int getClosedIssues() {
        return closedIssues;
    }

    public void setClosedIssues(int closedIssues) {
        this.closedIssues = closedIssues;
    }

    public int getTotalIssues() {
        return totalIssues;
    }

    public void setTotalIssues(int totalIssues) {
        this.totalIssues = totalIssues;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }
}
