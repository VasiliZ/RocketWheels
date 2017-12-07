package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.R;

public class ContentBodyViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout mContentConteiner;

    private ImageView mOwnerPhoto;
    private TextView mOwnerName;
    private TextView mDatePost;
    private TextView mTextPost;

    private LinearLayout mPhotoContent;
    private LinearLayout mVideoContent;
    private LinearLayout mAudioContent;
    private LinearLayout mGifContent;
    private LinearLayout mLinkContent;
    private LinearLayout mCommentLinearLayout;

    private TextView mPhotoText;
    private TextView mVideoText;
    private TextView mGifText;
    private TextView mLinkText;

    private ImageView mPhotoImage;
    private ImageView mVideoImage;
    private ImageView mGifImage;
    private ImageView mLinkImage;

    private RecyclerView mRecyclerView;
    private ImageView mLikeImage;
    private TextView mCountLike;
    private TextView mCountComment;
    private TextView mCountRepost;

    public ContentBodyViewHolder(final View itemView) {
        super(itemView);

        mOwnerPhoto = itemView.findViewById(R.id.photo_news_image_view);
        mOwnerName = itemView.findViewById(R.id.title_news_text_view);
        mDatePost = itemView.findViewById(R.id.text_time_text_view);

        mTextPost = itemView.findViewById(R.id.text_news_text_view);

        mContentConteiner = itemView.findViewById(R.id.content_container_linear_layout);

        mPhotoContent = itemView.findViewById(R.id.content_photo_linear_layout);
        mVideoContent = itemView.findViewById(R.id.content_video_linear_layout);
        mAudioContent = itemView.findViewById(R.id.audio_linear_layout);
        mGifContent = itemView.findViewById(R.id.content_gif_linear_layout);
        mLinkContent = itemView.findViewById(R.id.content_link_linear_layout);

        mPhotoText = itemView.findViewById(R.id.photo_text_view);
        mVideoText = itemView.findViewById(R.id.video_text_view);
        mGifText = itemView.findViewById(R.id.gif_text_view);
        mLinkText = itemView.findViewById(R.id.link_text_view);

        mPhotoImage = itemView.findViewById(R.id.photo_image_view);
        mVideoImage = itemView.findViewById(R.id.video_image_view);
        mGifImage = itemView.findViewById(R.id.gif_image_view);
        mLinkImage = itemView.findViewById(R.id.link_image_view);

        mRecyclerView = itemView.findViewById(R.id.array_content_recycler_view);

        mLikeImage = itemView.findViewById(R.id.like_image_view);
        mCountLike = itemView.findViewById(R.id.likes_count_text_view);
        mCountComment = itemView.findViewById(R.id.comments_count_text_view);
        mCommentLinearLayout = itemView.findViewById(R.id.comments_linear_layout);
        mCountRepost = itemView.findViewById(R.id.repost_count_text_view);

    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public void setRecyclerView(final RecyclerView pRecyclerView) {
        mRecyclerView = pRecyclerView;
    }

    public LinearLayout getCommentLinearLayout() {
        return mCommentLinearLayout;
    }

    public void setCommentLinearLayout(final LinearLayout pCommentLinearLayout) {
        mCommentLinearLayout = pCommentLinearLayout;
    }

    public LinearLayout getContentConteiner() {
        return mContentConteiner;
    }

    public void setContentConteiner(final LinearLayout pContentConteiner) {
        mContentConteiner = pContentConteiner;
    }

    public LinearLayout getPhotoContent() {
        return mPhotoContent;
    }

    public void setPhotoContent(final LinearLayout pPhotoContent) {
        mPhotoContent = pPhotoContent;
    }

    public LinearLayout getVideoContent() {
        return mVideoContent;
    }

    public void setVideoContent(final LinearLayout pVideoContent) {
        mVideoContent = pVideoContent;
    }

    public LinearLayout getAudioContent() {
        return mAudioContent;
    }

    public void setAudioContent(final LinearLayout pAudioContent) {
        mAudioContent = pAudioContent;
    }

    public LinearLayout getGifContent() {
        return mGifContent;
    }

    public void setGifContent(final LinearLayout pGifContent) {
        mGifContent = pGifContent;
    }

    public LinearLayout getLinkContent() {
        return mLinkContent;
    }

    public void setLinkContent(final LinearLayout pLinkContent) {
        mLinkContent = pLinkContent;
    }

    public TextView getPhotoText() {
        return mPhotoText;
    }

    public void setPhotoText(final TextView pPhotoText) {
        mPhotoText = pPhotoText;
    }

    public TextView getVideoText() {
        return mVideoText;
    }

    public void setVideoText(final TextView pVideoText) {
        mVideoText = pVideoText;
    }

    public TextView getGifText() {
        return mGifText;
    }

    public void setGifText(final TextView pGifText) {
        mGifText = pGifText;
    }

    public TextView getLinkText() {
        return mLinkText;
    }

    public void setLinkText(final TextView pLinkText) {
        mLinkText = pLinkText;
    }

    public ImageView getPhotoImage() {
        return mPhotoImage;
    }

    public void setPhotoImage(final ImageView pPhotoImage) {
        mPhotoImage = pPhotoImage;
    }

    public ImageView getVideoImage() {
        return mVideoImage;
    }

    public void setVideoImage(final ImageView pVideoImage) {
        mVideoImage = pVideoImage;
    }

    public ImageView getGifImage() {
        return mGifImage;
    }

    public void setGifImage(final ImageView pGifImage) {
        mGifImage = pGifImage;
    }

    public ImageView getLinkImage() {
        return mLinkImage;
    }

    public void setLinkImage(final ImageView pLinkImage) {
        mLinkImage = pLinkImage;
    }

    public ImageView getOwnerPhoto() {
        return mOwnerPhoto;
    }

    public void setOwnerPhoto(final ImageView pOwnerPhoto) {
        mOwnerPhoto = pOwnerPhoto;
    }

    public TextView getOwnerName() {
        return mOwnerName;
    }

    public void setOwnerName(final TextView pOwnerName) {
        mOwnerName = pOwnerName;
    }

    public TextView getDatePost() {
        return mDatePost;
    }

    public void setDatePost(final TextView pDatePost) {
        mDatePost = pDatePost;
    }

    public TextView getTextPost() {
        return mTextPost;
    }

    public void setTextPost(final TextView pTextPost) {
        mTextPost = pTextPost;
    }

    public TextView getCountLike() {
        return mCountLike;
    }

    public void setCountLike(final TextView pCountLike) {
        mCountLike = pCountLike;
    }

    public TextView getCountComment() {
        return mCountComment;
    }

    public void setCountComment(final TextView pCountComment) {
        mCountComment = pCountComment;
    }

    public TextView getCountRepost() {
        return mCountRepost;
    }

    public void setCountRepost(final TextView pCountRepost) {
        mCountRepost = pCountRepost;
    }

    public ImageView getLikeImage() {
        return mLikeImage;
    }

    public void setLikeImage(final ImageView pLikeImage) {
        mLikeImage = pLikeImage;
    }
}
