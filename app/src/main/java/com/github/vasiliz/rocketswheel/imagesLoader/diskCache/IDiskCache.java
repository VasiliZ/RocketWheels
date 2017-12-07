package com.github.vasiliz.rocketswheel.imagesLoader.diskCache;

import android.graphics.Bitmap;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface IDiskCache {

    File getFile(String pImageUrl) throws IOException, NoSuchAlgorithmException;

    void save(String pUrl, Bitmap pBitmap) throws IOException, NoSuchAlgorithmException;
}
