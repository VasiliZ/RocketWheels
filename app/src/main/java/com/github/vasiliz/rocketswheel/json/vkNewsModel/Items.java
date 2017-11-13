package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {

    @SerializedName("type")
    private String type;
    @SerializedName("source_id")
    private int souseId;
    @SerializedName("date")
    private long date;
    @SerializedName("post_id")
    private int postId;
    @SerializedName("post_type")
    private String postType;
    @SerializedName("text")
    private String text;
    @SerializedName("attachment")
    private Attachment mAttachment;
    @SerializedName("attachments")
    private List<Attachments> mAttachments;

    public Items(final String pType, final int pSouseId, final long pDate, final int pPostId, final String pPostType, final String pText, final Attachment pAttachment, final List<Attachments> pAttachments) {
        type = pType;
        souseId = pSouseId;
        date = pDate;
        postId = pPostId;
        postType = pPostType;
        text = pText;
        mAttachment = pAttachment;
        mAttachments = pAttachments;
    }

    public String getType() {
        return type;
    }

    public void setType(final String pType) {
        type = pType;
    }

    public int getSouseId() {
        return souseId;
    }

    public void setSouseId(final int pSouseId) {
        souseId = pSouseId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(final long pDate) {
        date = pDate;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(final int pPostId) {
        postId = pPostId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(final String pPostType) {
        postType = pPostType;
    }

    public String getText() {
        return text;
    }

    public void setText(final String pText) {
        text = pText;
    }

    public Attachment getAttachment() {
        return mAttachment;
    }

    public void setAttachment(final Attachment pAttachment) {
        mAttachment = pAttachment;
    }

    public List<Attachments> getAttachments() {
        return mAttachments;
    }

    public void setAttachments(final List<Attachments> pAttachments) {
        mAttachments = pAttachments;
    }
}
