package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;

import java.util.concurrent.ExecutionException;

public class ImageManager {

    private int mMemory = 1024 * 1024 / 8;
    private ImageCache mImageCache = new ImageCache(mMemory);
    private Downloader mDownloader;
    private Bitmap mBitmap;
    private OnDownloadBitmapListener mOnDownloadBitmapListener;

    public Bitmap getBitmap(final String pUrl) throws ExecutionException, InterruptedException {

        if (mImageCache.getImageFromMemory(pUrl) == null) {
            mDownloader = new Downloader();
            mBitmap = mDownloader.downloadImage(pUrl, mOnDownloadBitmapListener);
            mImageCache.setBitmap(pUrl, mBitmap);
            return mBitmap;
        } else {
            return mImageCache.getImageFromMemory(pUrl);
        }

    }

}
