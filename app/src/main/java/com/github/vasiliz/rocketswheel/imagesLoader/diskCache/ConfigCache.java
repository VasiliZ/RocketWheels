package com.github.vasiliz.rocketswheel.imagesLoader.diskCache;

import java.io.File;

//TODO not used
public class ConfigCache {

    File mCacheDir;

    public ConfigCache(File pCacheDir) {
        mCacheDir = pCacheDir;
    }

    public boolean hasDiskCache() {
        return mCacheDir != null;
    }

    public File getCacheDir() {
        return mCacheDir;
    }
}
