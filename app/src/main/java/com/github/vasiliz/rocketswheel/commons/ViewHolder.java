package com.github.vasiliz.rocketswheel.commons;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mContentTextImage;
    private ImageView mContentImage;

    public ViewHolder(final View itemView) {
        super(itemView);

        mContentImage = itemView.findViewById(R.id.photo_news_image_view);
        mContentTextImage = itemView.findViewById(R.id.title_news_text_view);

    }

    public TextView getContentTextImage() {
        return mContentTextImage;
    }

    public ImageView getContentImage() {
        return mContentImage;
    }

    public void setContentTextImage(final String pContentTextImage) {
        mContentTextImage.setText(pContentTextImage);
    }

    public void setContentImage(final ImageView pContentImage) {
       mContentImage = pContentImage;
    }
}
