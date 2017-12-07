package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class Profiles {

    @SerializedName("id")
    private int mUid;
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("last_name")
    private String mLastName;
    @SerializedName("photo_50")
    private String mUserPhoto;
    @SerializedName("photo_medium_rec")
    private String mBigUserPhoto;

    public int getUid() {
        return mUid;
    }

    public void setUid(final int pUid) {
        mUid = pUid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(final String pFirstName) {
        mFirstName = pFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(final String pLastName) {
        mLastName = pLastName;
    }

    public String getUserPhoto() {
        return mUserPhoto;
    }

    public void setUserPhoto(final String pUserPhoto) {
        mUserPhoto = pUserPhoto;
    }

    public String getBigUserPhoto() {
        return mBigUserPhoto;
    }

    public void setBigUserPhoto(final String pBigUserPhoto) {
        mBigUserPhoto = pBigUserPhoto;
    }

}
