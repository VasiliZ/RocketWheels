package com.github.vasiliz.rocketswheel.models.likeModel;

import com.google.gson.annotations.SerializedName;

public class LikeResponse {

    @SerializedName("response")
    private Liked mLike;

    public LikeResponse() {
    }

    public Liked getLike() {
        return mLike;
    }

    public void setLike(final Liked pLike) {
        mLike = pLike;
    }
}
