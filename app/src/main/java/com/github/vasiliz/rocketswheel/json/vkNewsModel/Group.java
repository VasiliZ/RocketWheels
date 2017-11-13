package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("gid")
    private int mGid;
    @SerializedName("name")
    private String mName;
    @SerializedName("photo")
    private String mGroupPhoto;

    public int getGid() {
        return mGid;
    }

    public void setGid(final int pGid) {
        mGid = pGid;
    }

    public String getName() {
        return mName;
    }

    public void setName(final String pName) {
        mName = pName;
    }

    public String getGroupPhoto() {
        return mGroupPhoto;
    }

    public void setGroupPhoto(final String pGroupPhoto) {
        mGroupPhoto = pGroupPhoto;
    }
}
