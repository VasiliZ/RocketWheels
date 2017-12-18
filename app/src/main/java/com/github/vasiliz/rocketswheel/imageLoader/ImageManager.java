package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;
@Deprecated
public class ImageManager {

    private Downloader mDownloader = new Downloader();
    private Bitmap mBitmap;

    public void getBitmap(final String pUrl, final ImageView pImageView) throws ExecutionException, InterruptedException {


        mDownloader.downloadImage(pUrl, new OnDownloadBitmapListener() {

            @Override
            public void setBitmap(final Bitmap pBitmap) {
                pImageView.setImageBitmap(pBitmap);
            }
        });
    }
}
