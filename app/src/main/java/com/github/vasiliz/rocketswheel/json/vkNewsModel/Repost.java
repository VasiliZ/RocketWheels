package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class Repost {

    @SerializedName("count")
    private int mCountRepost;
    @SerializedName("user_reposted")
    private int mUserReposted;

    public int getCountRepost() {
        return mCountRepost;
    }

    public void setCountRepost(final int pCountRepost) {
        mCountRepost = pCountRepost;
    }

    public int getUserReposted() {
        return mUserReposted;
    }

    public void setUserReposted(final int pUserReposted) {
        mUserReposted = pUserReposted;
    }
}
