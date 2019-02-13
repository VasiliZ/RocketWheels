package com.github.vasiliz.rocketswheel.models.likeModel;

import com.google.gson.annotations.SerializedName;

public class Liked {

    @SerializedName("likes")
    private int mLike;

    public int getLike() {
        return mLike;
    }

    public void setLike(final int pLike) {
        mLike = pLike;
    }
}
