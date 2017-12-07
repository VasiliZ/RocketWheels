package com.github.vasiliz.rocketswheel.imagesLoader.diskCache;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import com.github.vasiliz.rocketswheel.commons.ConstantsStrings;
import com.github.vasiliz.rocketswheel.utils.IOUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static java.security.AccessController.getContext;

public class CacheBitmap implements IDiskCache {

    private static final String TAG = CacheBitmap.class.getSimpleName();
    private static final Bitmap.CompressFormat COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    private static final int COMPRESS_PERCENT = 80;
    private static final int BUFFER_SIZE = 4096;

    private static final int MIN_CACHE_SIZE = 5 * 1024 * 1024;
    private static final int MAX_CACHE_SIZE = 50 * 1024 * 1024;
    private File mFile;
    private long mSizeOfCache;

    public CacheBitmap() {
        mFile = new File("/data/data/com.github.vasiliz.rocketswheel/cache" + ConstantsStrings.DIR_CACHE);
        Log.d(TAG, "CacheBitmap: " + mFile.getAbsolutePath());
        if ((!mFile.exists()) || (mFile == null)) {
            boolean checkDir = mFile.mkdir();
            if (!checkDir) {
                throw new IllegalStateException("Can't create dir in here");
            }
        }

        mSizeOfCache = getDiskCacheSize(mFile);
        cleaningCache();

    }

    private long getDiskCacheSize(File pDirCache) {
        long size = MIN_CACHE_SIZE;

        StatFs statFs = new StatFs(pDirCache.getAbsolutePath());
        long available = statFs.getBlockCount() * statFs.getBlockSize();
        size = available / 50;

        return Math.max(Math.min(size, MAX_CACHE_SIZE), MIN_CACHE_SIZE);
    }

    private void cleaningCache() {
        long currentCacheSize = currentCacheSize();
        if (currentCacheSize > mSizeOfCache) {
            File[] files = mFile.listFiles();

            Arrays.sort(files, (pLeft, pRight) -> Long.valueOf(pLeft.lastModified()).compareTo(pRight.lastModified()));
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
        File[] files = mFile.listFiles();
        for (File file : files) {
            currentSize += file.length();
        }
        return currentSize;
    }

    @Override
    public File getFile(final String pImageUrl) throws IOException, NoSuchAlgorithmException {

        MessageDigest toMd5 = MessageDigest.getInstance("MD5");
        final String fileName =  toMd5.digest(pImageUrl.getBytes()).toString() + ".jpg"; // ?

        File[] files = mFile.listFiles((dir, name) -> fileName.equals(name));

        if (files != null && files.length == 1) {
            return files[0];
        } else {
            File file = new File(mFile, fileName);
            if (!file.exists()) {
                boolean isCreateFile = file.createNewFile();
                Log.d(TAG, "getFile: " + isCreateFile);
            }
            return file;
        }
    }

    @Override
    public void save(final String pUrl, final Bitmap pBitmap) throws IOException, NoSuchAlgorithmException {

        File image = getFile(pUrl);
        FileOutputStream fileOutputStream = new FileOutputStream(image);
        OutputStream outputStream = new BufferedOutputStream(fileOutputStream, BUFFER_SIZE);

        try {
            boolean isSavedFile = pBitmap.compress(COMPRESS_FORMAT, COMPRESS_PERCENT, outputStream);
            image.setLastModified(System.currentTimeMillis());

        } finally {
            IOUtils.closeStream(outputStream);
        }

    }
}
