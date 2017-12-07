package com.github.vasiliz.rocketswheel.json.likeModel;

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
