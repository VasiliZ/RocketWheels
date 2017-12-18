package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
@Deprecated
public class DownloadBitmap {

    private Bitmap mBitmap;
    private static final String TAG = DownloadBitmap.class.getSimpleName();

    public Bitmap downloadBitmap(final String url) {

        try (InputStream inputStream = new URL(url).openStream()) {
            mBitmap = null;
            Log.d(TAG, " downloadImage" + url);
            mBitmap = BitmapFactory.decodeStream(inputStream);
            return mBitmap;
        } catch (MalformedURLException pE) {
            pE.printStackTrace();
        } catch (IOException pE) {
            pE.printStackTrace();
        } catch (NullPointerException pE){
            Log.d("lol", "ну бывает");
        }

        return null;
    }

}
