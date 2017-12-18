package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
@Deprecated
//TODO remove deprecated code
public class BitmapDownloadTask extends AsyncTask<String, Void, Bitmap> {

    private final OnDownloadBitmapListener mOnDownloadBitmapListener;
    private String path;


    public BitmapDownloadTask(final OnDownloadBitmapListener pOnDownloadBitmapListener) {

        mOnDownloadBitmapListener = pOnDownloadBitmapListener;

    }

    @Override
    protected Bitmap doInBackground(final String... pStrings) {
        path = pStrings[0];

        return new DownloadBitmap().downloadBitmap(path);
    }

    @Override
    protected void onPostExecute(Bitmap pBitmap) {
        if (isCancelled()) {
            pBitmap = null;
        }

        if (mOnDownloadBitmapListener != null){
            mOnDownloadBitmapListener.setBitmap(pBitmap);
        }else{
            Log.d("TAG", "no image");
        }
    }

}
