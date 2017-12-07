package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class Downloader {

        public void downloadImage(final String pUrl, final OnDownloadBitmapListener pOnDownloadBitmapListener) {
            final BitmapDownloadTask bitmapDownloadTask = new BitmapDownloadTask(pOnDownloadBitmapListener);
            bitmapDownloadTask.execute(pUrl);
        }

}
