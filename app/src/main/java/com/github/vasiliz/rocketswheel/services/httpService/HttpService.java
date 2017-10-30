package com.github.vasiliz.rocketswheel.services.httpService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class HttpService implements IHttpCallBack {

    private BufferedReader mBufferedReader;
    private StringBuffer mStringBuffer;

    @Override
    public String request(final String pRequest) throws IOException {
        try {
            final URL url = new URL(pRequest);
            final HttpsURLConnection URLConnection = (HttpsURLConnection) url.openConnection();
            mBufferedReader = new BufferedReader(new InputStreamReader(URLConnection.getInputStream()));

            mStringBuffer = new StringBuffer();
            String line;
            while ((line = mBufferedReader.readLine()) != null) {
                mStringBuffer.append(line);
            }
            mBufferedReader.close();

        } catch (final MalformedURLException pE) {
            pE.printStackTrace();
        } catch (final IOException pE) {
            pE.printStackTrace();
        }

        return mStringBuffer.toString();
    }

}
