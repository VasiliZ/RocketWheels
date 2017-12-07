package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

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
    @SerializedName("attachments")
    private List<Attachments> mAttachments;
    @SerializedName("comments")
    private Comment mComment;
    @SerializedName("likes")
    private Like mLike;
    @SerializedName("reposts")
    private Repost mRepost;

    public Item() {
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

    public List<Attachments> getAttachments() {
        return mAttachments;
    }

    public void setAttachments(final List<Attachments> pAttachments) {
        mAttachments = pAttachments;
    }

    public Comment getComment() {
        return mComment;
    }

    public void setComment(final Comment pComment) {
        mComment = pComment;
    }

    public Like getLike() {
        return mLike;
    }

    public void setLike(final Like pLike) {
        mLike = pLike;
    }

    public Repost getRepost() {
        return mRepost;
    }

    public void setRepost(final Repost pRepost) {
        mRepost = pRepost;
    }
}
