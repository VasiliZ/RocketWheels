package com.github.vasiliz.rocketswheel.utils;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {

    private IOUtils(){}

    public static void closeStream (Closeable pStream){
        if (pStream != null){
            try {
                pStream.close();
            } catch (IOException pE) {
                pE.printStackTrace();
            }
        }
    }

}
