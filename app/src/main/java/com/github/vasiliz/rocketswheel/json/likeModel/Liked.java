package com.github.vasiliz.rocketswheel.json.likeModel;

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
