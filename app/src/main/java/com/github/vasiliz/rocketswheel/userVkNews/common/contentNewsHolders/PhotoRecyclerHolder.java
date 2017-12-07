package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.R;

public class PhotoRecyclerHolder extends RecyclerView.ViewHolder {

    private TextView mImageText;
    private ImageView mImage;

    public PhotoRecyclerHolder(final View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.photo_news_body_image_view);
        mImageText = itemView.findViewById(R.id.text_photo_image_view);
    }

    public TextView getImageText() {
        return mImageText;
    }

    public void setImageText(final TextView pImageText) {
        mImageText = pImageText;
    }

    public ImageView getImage() {
        return mImage;
    }

    public void setImage(final ImageView pImage) {
        mImage = pImage;
    }
}
