package com.github.vasiliz.rocketswheel.json.vkNewsModel;

import com.google.gson.annotations.SerializedName;

public class Attachments {

    @SerializedName("type")
    private String mType;
    @SerializedName("photo")
    private AttachmentPhoto mAttachmentPhoto;
    @SerializedName("link")
    private AttachmentLink mAttachmentLink;
    @SerializedName("audio")
    private AttachmentAudio mAttachmentAudio;
    @SerializedName("doc")
    private AttachmentDoc mAttachmentDoc;

    public String getType() {
        return mType;
    }

    public void setType(final String pType) {
        mType = pType;
    }

    public AttachmentPhoto getAttachmentPhoto() {
        return mAttachmentPhoto;
    }

    public void setAttachmentPhoto(final AttachmentPhoto pAttachmentPhoto) {
        mAttachmentPhoto = pAttachmentPhoto;
    }

    public AttachmentLink getAttachmentLink() {
        return mAttachmentLink;
    }

    public void setAttachmentLink(final AttachmentLink pAttachmentLink) {
        mAttachmentLink = pAttachmentLink;
    }

    public AttachmentAudio getAttachmentAudio() {
        return mAttachmentAudio;
    }

    public void setAttachmentAudio(final AttachmentAudio pAttachmentAudio) {
        mAttachmentAudio = pAttachmentAudio;
    }

    public AttachmentDoc getAttachmentDoc() {
        return mAttachmentDoc;
    }

    public void setAttachmentDoc(final AttachmentDoc pAttachmentDoc) {
        mAttachmentDoc = pAttachmentDoc;
    }
}
