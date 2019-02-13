package com.github.vasiliz.rocketswheel.imagesLoader;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.github.vasiliz.rocketswheel.imagesLoader.streams.FileInputStreamProvider;
import com.github.vasiliz.rocketswheel.imagesLoader.streams.HttpInputStreamProvider;

import java.io.File;
import java.io.InputStream;

public class ImageLoadTask extends AsyncTask<Void, Void, LoadImageResultModel> {

    private ImageLoader imageLoader = ImageLoader.getInstance();

    @Override
    protected void onPostExecute(final LoadImageResultModel pLoadImageResultModel) {
        imageLoader.setImageOnBitmap(pLoadImageResultModel);
    }

    @Override
    protected LoadImageResultModel doInBackground(final Void... pVoids) {

        LoadImageResultModel resultModel = null;

        //TODO split to separate methods

        try {
            final ImageRequestModel imageRequestModel = imageLoader.getImageQueue().takeFirst();
            resultModel = new LoadImageResultModel(imageRequestModel);
            Bitmap bitmap;

            //TODO add multithreading support
            //TODO synchronize on ImageLoader level
            synchronized (imageLoader.getSync()) {
                final Bitmap bitmapLRU = imageLoader.getLruCache().get(imageRequestModel.getUrl());
                if (bitmapLRU != null) {
                    resultModel.setBitmap(bitmapLRU);
                    return resultModel;
                }
            }

            if (imageLoader.getIDiskCache() != null) {
                try {
                    final File file = imageLoader.getIDiskCache().getFile(imageRequestModel.getUrl());
                    final InputStream inputStream = new FileInputStreamProvider().get(file);
                    bitmap = imageLoader.getResizedBitmap(inputStream, imageRequestModel.getWidth(), imageRequestModel.getHeight());

                    if (bitmap != null) {
                        resultModel.setBitmap(bitmap);
                        return resultModel;
                    }
                } catch (final Exception e) {
                    e.fillInStackTrace();
                }
            }

            final InputStream inputStream = new HttpInputStreamProvider().get(imageRequestModel.getUrl());

            bitmap = imageLoader.getResizedBitmap(inputStream, imageRequestModel.getWidth(), imageRequestModel.getHeight());

            if (bitmap != null) {
                resultModel.setBitmap(bitmap);
                imageLoader.cacheBitmap(imageRequestModel, bitmap);
            }
        } catch (final Exception pE) {
            if (resultModel != null) {
                resultModel.setException(pE);
            }
        }

        return resultModel;

    }
}
