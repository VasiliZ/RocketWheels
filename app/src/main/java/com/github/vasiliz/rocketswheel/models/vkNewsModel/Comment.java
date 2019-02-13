package com.github.vasiliz.rocketswheel.models.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("count")
    private int mCount;
    @SerializedName("can_post")
    private int mPost;

    public int getCount() {
        return mCount;
    }

    public void setCount(final int pCount) {
        mCount = pCount;
    }

    public int getPost() {
        return mPost;
    }

    public void setPost(final int pPost) {
        mPost = pPost;
    }
}
