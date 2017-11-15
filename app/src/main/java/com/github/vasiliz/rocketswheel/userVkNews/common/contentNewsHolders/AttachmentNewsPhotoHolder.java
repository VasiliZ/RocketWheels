package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.R;

public class AttachmentNewsPhotoHolder extends RecyclerView.ViewHolder {

    private TextView mTextView;
    private ImageView mImageView;
    private TextView mContentTextImage;
    private ImageView mContentImage;

    public AttachmentNewsPhotoHolder(final View itemView) {
        super(itemView);

        mTextView = itemView.findViewById(R.id.text_picture_image_view);
        mImageView = itemView.findViewById(R.id.picture_news_image_view);
        mContentImage = itemView.findViewById(R.id.photo_news_image_view);
        mContentTextImage = itemView.findViewById(R.id.title_news_text_view);

    }

    public TextView getTextView() {
        return mTextView;
    }

    public void setTextView(final TextView pTextView) {
        mTextView = pTextView;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(final ImageView pImageView) {
        mImageView = pImageView;
    }

    public TextView getContentTextImage() {
        return mContentTextImage;
    }

    public void setContentTextImage(final String pContentTextImage) {
        mContentTextImage.setText(pContentTextImage);
    }

    public ImageView getContentImage() {
        return mContentImage;
    }

    public void setContentImage(final Bitmap pBitmap) {
        mContentImage.setImageBitmap(pBitmap);
    }
}
