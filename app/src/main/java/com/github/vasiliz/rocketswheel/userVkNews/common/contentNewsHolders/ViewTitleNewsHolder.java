package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.R;
@Deprecated
public class ViewTitleNewsHolder extends RecyclerView.ViewHolder {

    private TextView mContentTextImage;
    private ImageView mContentImage;

    public ViewTitleNewsHolder(final View itemView) {
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
