package com.github.vasiliz.rocketswheel.models.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class Like {

    @SerializedName("count")
    private int mCountLike;
    @SerializedName("user_likes")
    private int mUserLike;
    @SerializedName("can_like")
    private int mCanLike;

    public int getCountLike() {
        return mCountLike;
    }

    public void setCountLike(final int pCountLike) {
        mCountLike = pCountLike;
    }

    public int getUserLike() {
        return mUserLike;
    }

    public void setUserLike(final int pUserLike) {
        mUserLike = pUserLike;
    }

    public int getCanLike() {
        return mCanLike;
    }

    public void setCanLike(final int pCanLike) {
        mCanLike = pCanLike;
    }
}
