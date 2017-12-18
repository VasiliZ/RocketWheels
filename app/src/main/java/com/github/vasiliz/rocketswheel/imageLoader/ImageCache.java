package com.github.vasiliz.rocketswheel.imageLoader;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;
@Deprecated
public class ImageCache extends LruCache<String, Bitmap> {

    private final String TAG = ImageCache.class.getSimpleName();

    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public ImageCache(final int maxSize) {
        super(maxSize);
    }

    public Bitmap getImageFromMemory(final String url) {
        Log.d(TAG, "getBitmap " + url);
        return this.get(url);
    }

    public void setBitmap(final String url, final Bitmap pImage){
        if (getImageFromMemory(url) == null){
            this.put(url, pImage);
            Log.d(TAG, "setBitmap: " + url);
        }
    }
}
