package com.github.vasiliz.rocketswheel.imagesLoader.diskCache;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.StatFs;
import android.util.Log;

import com.github.vasiliz.rocketswheel.MyApp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

public class CacheBitmap implements IDiskCache {

    private static final String TAG = CacheBitmap.class.getSimpleName();
    private static final Bitmap.CompressFormat COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    private static final int COMPRESS_PERCENT = 80;
    private static final int MIN_CACHE_SIZE = 5 * 1024 * 1024;
    private static final int MAX_CACHE_SIZE = 50 * 1024 * 1024;
    private File mFile;
    private long mSizeOfCache;

    public CacheBitmap() {
        init();
    }

    private void init() {

        mFile = new File(MyApp.getContext().getFilesDir().getPath());
        mSizeOfCache = getDiskCacheSize(mFile);
        cleaningCache();
    }

    private long getDiskCacheSize(final File pDirCache) {
        final long size;

        final StatFs statFs = new StatFs(pDirCache.getAbsolutePath());
        final long available = statFs.getBlockCount() * statFs.getBlockSize();
        size = available / 50;

        return Math.max(Math.min(size, MAX_CACHE_SIZE), MIN_CACHE_SIZE);
    }

    private void cleaningCache() {
        long currentCacheSize = currentCacheSize();
        if (currentCacheSize > mSizeOfCache) {
            final File[] files = mFile.listFiles();

            Arrays.sort(files, (pLeft, pRight) -> Long.compare(pLeft.lastModified(), pRight.lastModified()));
            int i = 0;
            do {
                final File f = files[i];
                final long length = f.length();
                if (f.delete()) {
                    currentCacheSize -= length;
                }
                i++;
            } while (currentCacheSize > mSizeOfCache);
        }
    }

    private long currentCacheSize() {
        long currentSize = mFile.length();
        final File[] files = mFile.listFiles();
        for (final File file : files) {
            currentSize += file.length();
        }
        return currentSize;
    }

    @Override
    public File getFile(final String pImageUrl) {

        final File[] files = mFile.listFiles();
        if(files.length>0) {

            for (final File file : files) {
                Log.d(TAG, file.getName());
                if (Objects.requireNonNull(Uri.parse(pImageUrl).getLastPathSegment()).contains(file.getName())) {
                    return file;
                }
            }
        }
        return null;
    }

    @Override
    public void save(final String pUrl, final Bitmap pBitmap) throws IOException {
        cleaningCache();
        final String fileName = Uri.parse(pUrl).getLastPathSegment();
        if (fileName != null) {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            pBitmap.compress(COMPRESS_FORMAT, COMPRESS_PERCENT, byteArrayOutputStream);
            final byte[] bytes = byteArrayOutputStream.toByteArray();

            final FileOutputStream fileOutputStream = MyApp.getContext().openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }
    }
}
