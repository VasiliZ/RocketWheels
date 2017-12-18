package com.github.vasiliz.rocketswheel.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.github.vasiliz.rocketswheel.json.likeModel.LikeResponse;
import com.github.vasiliz.rocketswheel.services.httpService.HttpService;
import com.github.vasiliz.rocketswheel.userVkNews.common.ContentBodyViewHolder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OnLikeTask extends AsyncTask<String, Void, String> {

    //TODO resolve issues hightlited by android studio.
    private static final String TAG = OnLikeTask.class.getSimpleName();
    private final ContentBodyViewHolder mContentBodyViewHolder;

    public OnLikeTask(ContentBodyViewHolder pContentBodyViewHolder) {
        mContentBodyViewHolder = pContentBodyViewHolder;
    }


    //TODO crash if tap very quick to like button
    @Override
    protected String doInBackground(final String... pStrings) {
        HttpService httpService = new HttpService();
        Gson gson = new GsonBuilder().create();
        String response = pStrings[0];
        LikeResponse likeResponse = gson.fromJson(httpService.request(response), LikeResponse.class);

        return String.valueOf(likeResponse.getLike().getLike());
    }

    @Override
    protected void onPostExecute(final String pS) {
        super.onPostExecute(pS);
        Log.d(TAG, "onPostExecute: " + pS);
        if (!pS .equals("")){
            //TODO asyncTask shouldn't know about view.
            mContentBodyViewHolder.getCountLike().setText(pS);
        }
    }
}
