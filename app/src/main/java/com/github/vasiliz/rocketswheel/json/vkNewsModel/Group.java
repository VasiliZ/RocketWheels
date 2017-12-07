package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("id")
    private int mGid;
    @SerializedName("name")
    private String mName;
    @SerializedName("photo_50")
    private String mPhotoGroup;

    public Group() {
    }

    public int getGid() {
        return mGid;
    }

    public void setGid(final int pGid) {
        mGid = pGid;
    }

    public String getGroupName() {
        return mName;
    }

    public void setName(final String pName) {
        mName = pName;
    }

    public String getPhotoGroup() {
        return mPhotoGroup;
    }

    public void setPhotoGroup(final String pPhotoGroup) {
        mPhotoGroup = pPhotoGroup;
    }

    public String getName() {
        return mName;
    }
}
