package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class Attachment {

    @SerializedName("type")
    private String typeAttachment;
    @SerializedName("photo")
    private AttachmentPhoto mAttachmentPhoto;
    @SerializedName("video")
    private AttachmentVideo mAttachmentVideo;
    @SerializedName("doc")
    private AttachmentDoc mAttachmentDoc;

    public String getTypeAttachment() {
        return typeAttachment;
    }

    public void setTypeAttachment(final String pTypeAttachment) {
        typeAttachment = pTypeAttachment;
    }

    public AttachmentPhoto getAttachmentPhoto() {
        return mAttachmentPhoto;
    }

    public void setAttachmentPhoto(final AttachmentPhoto pAttachmentPhoto) {
        mAttachmentPhoto = pAttachmentPhoto;
    }

    public AttachmentVideo getAttachmentVideo() {
        return mAttachmentVideo;
    }

    public void setAttachmentVideo(final AttachmentVideo pAttachmentVideo) {
        mAttachmentVideo = pAttachmentVideo;
    }

    public AttachmentDoc getAttachmentDoc() {
        return mAttachmentDoc;
    }

    public void setAttachmentDoc(final AttachmentDoc pAttachmentDoc) {
        mAttachmentDoc = pAttachmentDoc;
    }
}
