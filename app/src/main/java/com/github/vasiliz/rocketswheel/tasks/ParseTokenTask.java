package com.github.vasiliz.rocketswheel.tasks;

import android.net.Uri;
import android.os.AsyncTask;

import com.github.vasiliz.rocketswheel.userAuth.model.ICompliteCallBack;

import java.util.concurrent.TimeUnit;

public class ParseTokenTask extends AsyncTask<String, Void, String> {

    private ICompliteCallBack mICompliteCallBack;

    public ParseTokenTask(final ICompliteCallBack pICompliteCallBack) {
        mICompliteCallBack = pICompliteCallBack;
    }

    @Override
    protected String doInBackground(final String... pStrings) {

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
        if (mICompliteCallBack !=null){
            mICompliteCallBack.onParse(pS);
        }
    }
}
