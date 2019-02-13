package com.github.vasiliz.rocketswheel.imagesLoader;

import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class ImageRequestModel {

    private String mUrl;
    private WeakReference<ImageView> mPointImage;
    private int mWidth;
    private int mHeight;

    public WeakReference<ImageView> getPointImage() {
        return mPointImage;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    private ImageRequestModel(Builder pBuilder){
        mUrl = pBuilder.mUrl;
        mPointImage = pBuilder.mPointImage;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(final String pUrl) {
        mUrl = pUrl;
    }

    public void setWidth(final int pWidth) {
        mWidth = pWidth;
    }

    public void setHeight(final int pHeight) {
        mHeight = pHeight;
    }

    public static final class Builder{
        private final ImageLoader mImageLoader;
        private String mUrl;
        private WeakReference<ImageView> mPointImage;

        public Builder(final ImageLoader pImageLoader) {
            mImageLoader = pImageLoader;
        }

        public Builder load(String pValue){
            mUrl = pValue;
            return this;
        }

        public void into(ImageView pValue){
            mPointImage = new WeakReference<>(pValue);
            mImageLoader.enqueue(this.build());
        }

        ImageRequestModel build(){
            return new ImageRequestModel(this);
        }

    }

}
