package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadBitmap {

    private Bitmap mBitmap;

    public Bitmap downloadBitmap(final String url) {
        try (InputStream inputStream = new URL(url).openStream()) {
            mBitmap = BitmapFactory.decodeStream(inputStream);
            return mBitmap;
        } catch (MalformedURLException pE) {
            pE.printStackTrace();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
        return null;
    }

}
