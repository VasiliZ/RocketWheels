package com.github.vasiliz.rocketswheel.services.httpService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpService implements IHttpCallBack {

    private StringBuffer mStringBuffer;

    @Override
    public String request(final String pRequest) {
        try {
            final URL url = new URL(pRequest);
            final HttpsURLConnection URLConnection = (HttpsURLConnection) url.openConnection();
            final BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(URLConnection.getInputStream()));

            mStringBuffer = new StringBuffer();
            String line;
            while ((line = mBufferedReader.readLine()) != null) {
                mStringBuffer.append(line);
            }
            mBufferedReader.close();

        } catch (final MalformedURLException pE) {
            pE.fillInStackTrace();
        } catch (final IOException pE) {
            pE.fillInStackTrace();
        }

        return mStringBuffer.toString();
    }

}
