package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class AttachmentPhoto {

    @SerializedName("pid")
    private int mInt;
    @SerializedName("owner_id")
    private int mOwnerId;
    @SerializedName("src")
    private String mSrc;
    @SerializedName("text")
    private String mPhotoText;

    public int getInt() {
        return mInt;
    }

    public void setInt(final int pInt) {
        mInt = pInt;
    }

    public int getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(final int pOwnerId) {
        mOwnerId = pOwnerId;
    }

    public String getSrc() {
        return mSrc;
    }

    public void setSrc(final String pSrc) {
        mSrc = pSrc;
    }

    public String getPhotoText() {
        return mPhotoText;
    }

    public void setPhotoText(final String pPhotoText) {
        mPhotoText = pPhotoText;
    }
}
