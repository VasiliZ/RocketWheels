package com.github.vasiliz.rocketswheel.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
@Deprecated
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    private final OnLoadImageListener mOnLoadImageListener;

    private String mUrl;

    public DownloadImageTask(final OnLoadImageListener pOnLoadImageListener) {
        mOnLoadImageListener = pOnLoadImageListener;
    }

    @Override
    protected Bitmap doInBackground(final String... url) {
        mUrl = url[0];
        Bitmap bitmap = null;
        try (InputStream inputStream = new URL(mUrl).openStream()) {
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (final MalformedURLException pE) {
            pE.printStackTrace();
        } catch (final IOException pE) {
            pE.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(final Bitmap pBitmap) {
        super.onPostExecute(pBitmap);

        if (mOnLoadImageListener != null) {
            mOnLoadImageListener.groupsImage(pBitmap);
        }

    }
}
