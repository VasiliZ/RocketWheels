//package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;
//
//import com.github.vasiliz.rocketswheel.imagesLoader.ImageLoader;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Attachments;
//
//public class SetDataPhoto {
//
//    private final Attachments mAttachments;
//    private PhotoRecyclerHolder mPhotoRecyclerHolder;
//
//    public SetDataPhoto(final Attachments pAttachments, final PhotoRecyclerHolder pPhotoRecyclerHolder) {
//
//        mAttachments = pAttachments;
//        mPhotoRecyclerHolder = pPhotoRecyclerHolder;
//    }
//
//    public void setData(){
//        if (mAttachments != null){
//            if (mAttachments.getAttachmentPhoto()!=null) {
//                ImageLoader.getInstance().load(mAttachments.getAttachmentPhoto().getSrc()).into(mPhotoRecyclerHolder.getImage());
//                mPhotoRecyclerHolder.getImageText().setText(mAttachments.getAttachmentPhoto().getPhotoText());
//            }
//        }
//    }
//}
