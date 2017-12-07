package com.github.vasiliz.rocketswheel.imagesLoader.streams;

import java.io.IOException;
import java.io.InputStream;

public interface IStreamContract<T> {

    InputStream get(T pUrl) throws IOException;

}
