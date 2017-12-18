package com.github.vasiliz.rocketswheel.tasks;

import android.os.AsyncTask;

import com.github.vasiliz.rocketswheel.json.vkNewsModel.ParseNews;
import com.github.vasiliz.rocketswheel.services.httpService.HttpService;
import com.github.vasiliz.rocketswheel.userVkNews.common.ParseCallBack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NewNewsVk extends AsyncTask<String, Void, ParseNews> {

    private final ParseCallBack mParseCallBack;

    //TODO create httpManager with executor for network operations
    private HttpService mHttpService;

    public NewNewsVk(final ParseCallBack pParseCallBack) {

        mParseCallBack = pParseCallBack;

    }

    @Override
    protected ParseNews doInBackground(final String... pStrings) {
        mHttpService = new HttpService();
        String sourse = pStrings[0];
        final Gson gson = new GsonBuilder().create();
        ParseNews parseNews = gson.fromJson(mHttpService.request(sourse), ParseNews.class);

        return parseNews;
    }

    @Override
    protected void onPostExecute(final ParseNews pParseNews) {
        super.onPostExecute(pParseNews);

        if (mParseCallBack != null){
            //TODO rename method. isSomething should return true or false
            mParseCallBack.isParsed(pParseNews);
        }

//        List<Profiles> profiles = pParseNews.getResponse().getProfiles();
//        List<Group> groups = pParseNews.getResponse().getGroups();
//
//        Iterator<Profiles> profilesIterator = profiles.iterator();
//        Iterator<Group> groupIterator = groups.iterator();
//
//        for (int i = 0; i<mParseNews.getResponse().getProfiles().size(); i++) {
//            while (profilesIterator.hasNext()) {
//
//                if (mParseNews.getResponse().getProfiles().get(i).getUid() == profilesIterator.next().getUid()) {
//                    profilesIterator.remove();
//
//                }
//            }
//        }
//        for (int i = 0; i<mParseNews.getResponse().getGroups().size(); i++) {
//
//            while (groupIterator.hasNext()) {
//                Group group = groupIterator.next();
//                if (group.getGid() == mParseNews.getResponse().getGroups().get(i).getGid()) {
//                    groupIterator.remove();
//
//                }
//            }
//        }
//        Log.d(TAG, "onPostExecute: " + groups.size());
//
//        for (int i = 0; i<groups.size(); i++){
//            mParseNews.getResponse().getGroups().add(groups.get(i));
//        }
////        while (groupIterator.hasNext()){
////            Group addNewGroup = groupIterator.next();
////            addNewGroup.setGid(addNewGroup.getGid());
////            mParseNews.getResponse().getGroups().add(addNewGroup);
////        }
//
//        Log.d(TAG, "onPostExecute: " + mParseNews.getResponse().getGroups().size());
//        for (int i = 0; i<pParseNews.getResponse().getItems().size(); i++){
//            mParseNews.getResponse().getItems().add(pParseNews.getResponse().getItems().get(i));
//        }

    }
}
