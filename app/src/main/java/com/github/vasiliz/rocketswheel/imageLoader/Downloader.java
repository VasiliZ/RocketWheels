package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;

import java.util.concurrent.ExecutionException;

public class Downloader {

        public Bitmap downloadImage(final String pUrl, final OnDownloadBitmapListener pOnDownloadBitmapListener){
            final BitmapDownloadTask bitmapDownloadTask = new BitmapDownloadTask(pOnDownloadBitmapListener);
            try {
                return bitmapDownloadTask.execute(pUrl).get();
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            } catch (ExecutionException pE) {
                pE.printStackTrace();
            }
            return null;
        }

}
