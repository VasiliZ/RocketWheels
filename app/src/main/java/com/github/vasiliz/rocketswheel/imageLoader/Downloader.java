package com.github.vasiliz.rocketswheel.imageLoader;

import android.widget.ImageView;

public class Downloader {

        public void downloadImage(String url, ImageView pImageView){
            BitmapDownloadTask bitmapDownloadTask = new BitmapDownloadTask(pImageView);
            bitmapDownloadTask.execute(url);
        }

}
