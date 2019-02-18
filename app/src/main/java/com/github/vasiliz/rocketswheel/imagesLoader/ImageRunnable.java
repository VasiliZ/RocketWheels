package com.github.vasiliz.rocketswheel.imagesLoader;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;

import com.github.vasiliz.rocketswheel.imagesLoader.streams.FileInputStreamProvider;
import com.github.vasiliz.rocketswheel.imagesLoader.streams.HttpInputStreamProvider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageRunnable implements Runnable {

    private ImageLoader imageLoader = ImageLoader.getInstance();

    @Override
    public void run() {
        LoadImageResultModel resultModel = null;

        try {
            final ImageRequestModel imageRequestModel = imageLoader.getImageQueue().takeFirst();
            resultModel = new LoadImageResultModel(imageRequestModel);
            Bitmap bitmap = getBitmapOnMemCache(imageRequestModel);
            if (bitmap==null){
               bitmap = downLoadImage(imageRequestModel);
            }
            resultModel.setBitmap(bitmap);
            setBitmapOnView(resultModel);
        } catch (final Exception pE) {
            if (resultModel != null) {
                resultModel.setException(pE);
            }
        }
    }

    private Bitmap getBitmapOnMemCache(ImageRequestModel imageRequestModel) {
        synchronized (imageLoader.getSync()) {
            final Bitmap bitmapLRU = imageLoader.getLruCache().get(imageRequestModel.getUrl());
            if (bitmapLRU != null) {
                return bitmapLRU;
            }else{
                getBitmapOnDiskCache(imageRequestModel);
            }
        }
        return null;
    }

    private void setBitmapOnView(LoadImageResultModel resultModel) {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = () -> imageLoader.setImageOnBitmap(resultModel);
        handler.post(runnable);
    }

    private Bitmap getBitmapOnDiskCache(ImageRequestModel imageRequestModel) {
        if (imageLoader.getIDiskCache() != null) {
            try {
                final File file = imageLoader.getIDiskCache().getFile(imageRequestModel.getUrl());
                if (file != null) {
                    final InputStream inputStream = new FileInputStreamProvider().get(file);
                    Bitmap bitmap = imageLoader.getResizedBitmap(inputStream, imageRequestModel.getWidth(), imageRequestModel.getHeight());

                    if (bitmap != null) {
                       return bitmap;
                    }else{
                        downLoadImage(imageRequestModel);
                    }
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Bitmap downLoadImage(ImageRequestModel imageRequestModel) {

        Bitmap bitmap = null;
        try {
            final InputStream inputStream = new HttpInputStreamProvider().get(imageRequestModel.getUrl());
            bitmap = imageLoader.getResizedBitmap(inputStream, imageRequestModel.getWidth(), imageRequestModel.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bitmap != null) {
            imageLoader.cacheBitmap(imageRequestModel, bitmap);
          return bitmap;
        }
        return null;
    }
}
