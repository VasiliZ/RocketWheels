package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class BitmapDownloadTask extends AsyncTask<String, Void, Bitmap> {

    private final WeakReference<ImageView> mImageViewWeakReference;

    public BitmapDownloadTask(final ImageView pImageView) {
        mImageViewWeakReference = new WeakReference<>(pImageView);
    }

    @Override
    protected Bitmap doInBackground(final String... pStrings) {
        return new DownloadBitmap().downloadBitmap(pStrings[0]);
    }

    @Override
    protected void onPostExecute(Bitmap pBitmap) {
        if (isCancelled()) {
            pBitmap = null;
        }

        if (mImageViewWeakReference != null) {
            ImageView imageView = mImageViewWeakReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(pBitmap);
            }
        }
    }
}
