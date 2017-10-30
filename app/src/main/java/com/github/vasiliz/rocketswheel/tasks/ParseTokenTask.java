package com.github.vasiliz.rocketswheel.tasks;

import android.net.Uri;
import android.os.AsyncTask;

import com.github.vasiliz.rocketswheel.userAuth.model.CompliteCallBack;

import java.util.concurrent.TimeUnit;

public class ParseTokenTask extends AsyncTask<String, Void, String> {

    private CompliteCallBack mCompliteCallBack;

    public ParseTokenTask(final CompliteCallBack pCompliteCallBack) {
        mCompliteCallBack = pCompliteCallBack;
    }

    @Override
    protected String doInBackground(final String... pStrings) {

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
        String url = pStrings[0];
        Uri uri = Uri.parse(url);

        final String[] parameters  = uri.getFragment().split("\\&");
        for (String s : parameters){
            String[] parts = s.split("\\=");
            if (parts[0].equals("access_token")){
                if (parts.length==1){
                    throw new RuntimeException("Missing access token");
                }
                return parts[1];
            }
        }
        throw new RuntimeException("no access token");
    }

    @Override

    protected void onPostExecute(final String pS) {
        super.onPostExecute(pS);
        if (mCompliteCallBack!=null){
            mCompliteCallBack.onParse(pS);
        }
    }
}
