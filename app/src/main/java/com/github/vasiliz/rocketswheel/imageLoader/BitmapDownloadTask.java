package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class BitmapDownloadTask extends AsyncTask<String, Void, Bitmap> {

    //private final WeakReference<OnDownloadBitmapListener> mImageViewWeakReference;
    private final OnDownloadBitmapListener mOnDownloadBitmapListener;

    public BitmapDownloadTask(final OnDownloadBitmapListener pOnDownloadBitmapListener) {
        //mImageViewWeakReference = new WeakReference<>(pOnDownloadBitmapListener);
        mOnDownloadBitmapListener = pOnDownloadBitmapListener;

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

        if (mOnDownloadBitmapListener != null) {
            mOnDownloadBitmapListener.setBitmap(pBitmap);
        }
    }

}
