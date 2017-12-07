package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class AttachmentVideo {

    @SerializedName("owner_id")
    private int mOwnerId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("duration")
    private int mDuration;
    @SerializedName("photo_800")
    private String mImageVideo;

    public int getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(final int pOwnerId) {
        mOwnerId = pOwnerId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(final String pTitle) {
        mTitle = pTitle;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(final int pDuration) {
        mDuration = pDuration;
    }

    public String getImageVideo() {
        return mImageVideo;
    }

    public void setImageVideo(final String pImageVideo) {
        mImageVideo = pImageVideo;
    }
}
