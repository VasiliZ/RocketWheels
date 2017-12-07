package com.github.vasiliz.rocketswheel.imagesLoader;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.github.vasiliz.rocketswheel.imageLoader.ImageCache;
import com.github.vasiliz.rocketswheel.imagesLoader.diskCache.CacheBitmap;
import com.github.vasiliz.rocketswheel.imagesLoader.diskCache.ConfigCache;
import com.github.vasiliz.rocketswheel.imagesLoader.diskCache.IDiskCache;
import com.github.vasiliz.rocketswheel.imagesLoader.streams.FileInputStreamProvider;
import com.github.vasiliz.rocketswheel.imagesLoader.streams.HttpInputStreamProvider;

import java.io.File;
import java.io.InputStream;

public class ImageLoadTask extends AsyncTask<Void, Void, LoadImageResultModel> {

    @Override
    protected void onPostExecute(final LoadImageResultModel pLoadImageResultModel) {
        ImageLoader.getInstance().setImageOnBitmap(pLoadImageResultModel);
    }

    @Override
    protected LoadImageResultModel doInBackground(final Void... pVoids) {

        LoadImageResultModel resultModel = null;

        try {
            ImageRequestModel imageRequestModel = ImageLoader.getInstance().getImageQueue().takeFirst();
            resultModel = new LoadImageResultModel(imageRequestModel);

            synchronized (ImageLoader.getInstance().getSync()) {
                final Bitmap bitmap = ImageLoader.getInstance().getLruCache().get(imageRequestModel.getUrl());
                if (bitmap != null) {
                    resultModel.setBitmap(bitmap);
                    return resultModel;
                }
            }

            Bitmap bitmap;

            if (ImageLoader.getInstance().getIDiskCache() != null) {
                try {
                    File file = ImageLoader.getInstance().getIDiskCache().getFile(imageRequestModel.getUrl());
                    InputStream inputStream = new FileInputStreamProvider().get(file);
                    bitmap = ImageLoader.getInstance().getResizedBitmap(inputStream, imageRequestModel.getWidth(), imageRequestModel.getHeight());

                    if (bitmap != null) {
                        resultModel.setBitmap(bitmap);
                        return resultModel;
                    }
                } catch (Exception e) {
                    e.fillInStackTrace();
                }
            }

            InputStream inputStream = new HttpInputStreamProvider().get(imageRequestModel.getUrl());

            bitmap = ImageLoader.getInstance().getResizedBitmap(inputStream, imageRequestModel.getWidth(), imageRequestModel.getHeight());

            if (bitmap != null) {
                resultModel.setBitmap(bitmap);
                ImageLoader.getInstance().cacheBitmap(imageRequestModel, bitmap);
            }
        } catch (Exception pE) {
            if (resultModel != null) {
                resultModel.setException(pE);
            }
        }

        return resultModel;

    }
}
