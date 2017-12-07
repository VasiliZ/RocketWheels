//package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.TextView;
//
//import com.github.vasiliz.rocketswheel.R;
//import com.github.vasiliz.rocketswheel.imageLoader.ImageManager;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
//
//public class NewsBodyAudioModel implements IBodyModel {
//
//    private TextView mTextView;
//    private TextView mTitleTextView;
//    private View mAudioView;
//
//    @Override
//    public void setContentToBodyNews(final FrameLayout contentBody, final Context pContext, final Item pItem, final ImageManager pImageManager) {
//        mAudioView = LayoutInflater.from(pContext).inflate(R.layout.news_attachment_audio, contentBody, true);
//        mTitleTextView = mAudioView.findViewById(R.id.title_music_text_view);
//        mTextView = mAudioView.findViewById(R.id.name_sound_text_view);
//        for (int i = 0; i<pItem.getAttachments().size(); i++) {
//            mTitleTextView.setText(pItem.getAttachments().get(i).getAttachmentAudio().getTitle());
//            mTextView.setText(pItem.getAttachments().get(i).getAttachmentAudio().getArtist());
//        }
//    }
//}
