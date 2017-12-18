package com.github.vasiliz.rocketswheel.imageLoader;
@Deprecated
public class Downloader {

        public void downloadImage(final String pUrl, final OnDownloadBitmapListener pOnDownloadBitmapListener) {
            final BitmapDownloadTask bitmapDownloadTask = new BitmapDownloadTask(pOnDownloadBitmapListener);
            bitmapDownloadTask.execute(pUrl);
        }

}
