package com.github.vasiliz.rocketswheel.models.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class AttachmentLink {

    @SerializedName("url")
    private String mLink;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("description")
    private String mDesc;
    @SerializedName("photo_604")
    private String mImageSrcLink;

    public void setLink(final String pLink) {
        mLink = pLink;
    }

    public void setTitle(final String pTitle) {
        mTitle = pTitle;
    }

    public void setDesc(final String pDesc) {
        mDesc = pDesc;
    }

    public void setImageSrcLink(final String pImageSrcLink) {
        mImageSrcLink = pImageSrcLink;
    }

    public String getLink() {
        return mLink;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDesc() {
        return mDesc;
    }

    public String getImageSrcLink() {
        return mImageSrcLink;
    }
}
