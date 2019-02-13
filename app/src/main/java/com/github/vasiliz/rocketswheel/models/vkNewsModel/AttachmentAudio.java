package com.github.vasiliz.rocketswheel.models.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class AttachmentAudio {

    @SerializedName("owner_id")
    private int mOwnerId;
    @SerializedName("artist")
    private String mArtist;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("duration")
    private int mDuration;
    @SerializedName("url")
    private String mUrl;

    public int getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(final int pOwnerId) {
        mOwnerId = pOwnerId;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(final String pArtist) {
        mArtist = pArtist;
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

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(final String pUrl) {
        mUrl = pUrl;
    }
}
