package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.MyApp;
import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.commons.ConstantsStrings;
import com.github.vasiliz.rocketswheel.imageLoader.ImageManager;
import com.github.vasiliz.rocketswheel.imagesLoader.ImageLoader;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;
import com.github.vasiliz.rocketswheel.tasks.OnLikeTask;
import com.github.vasiliz.rocketswheel.userAuth.model.ICompliteCallBack;
import com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders.INewsHeaderModel;
import com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders.NewsHeaderModel;
import com.github.vasiliz.rocketswheel.utils.StringUtils;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.content.Context.MODE_PRIVATE;

public class ConfigBodyViewHolder {

    private static final String TAG = ConfigBodyViewHolder.class.getCanonicalName();
    private static final String ITEM_ID = "&item_id=";
    private static final String OWNER_ID = "&owner_id=";
    public static final String ACCESS_TOKEN = "&access_token=";
    private final ContentBodyViewHolder mContentBodyViewHolder;
    private ImageManager mImageManager = new ImageManager();
    private INewsHeaderModel mINewsHeaderModel = new NewsHeaderModel();
    private final Item mItem;
    private final List<Group> mGroups;
    private final List<Profiles> mProfiles;
    private Context mContext;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public ConfigBodyViewHolder(final ContentBodyViewHolder pContentBodyViewHolder, final int pPosition, final Item pItem, final List<Group> pGroups, final List<Profiles> pProfiles, final Context pContext) {
        mContentBodyViewHolder = pContentBodyViewHolder;
        mItem = pItem;
        mGroups = pGroups;
        mProfiles = pProfiles;
        mContext = pContext;
    }

    public void setData() {
        try {
            mContentBodyViewHolder.getPhotoContent().setVisibility(View.GONE);
            mContentBodyViewHolder.getGifContent().setVisibility(View.GONE);
            mContentBodyViewHolder.getVideoContent().setVisibility(View.GONE);
            mContentBodyViewHolder.getLinkContent().setVisibility(View.GONE);
            mContentBodyViewHolder.getAudioContent().setVisibility(View.GONE);
            mContentBodyViewHolder.getCommentLinearLayout().setVisibility(View.GONE);

            setContentOnView();

        } catch (final ExecutionException pE) {
            pE.printStackTrace();
        } catch (final InterruptedException pE) {
            pE.printStackTrace();
        }
    }

    private void setContentOnView() throws ExecutionException, InterruptedException {
        if (mItem != null) {
            mINewsHeaderModel.setTitleImage(mItem, mGroups, mProfiles, mContentBodyViewHolder.getOwnerPhoto());
            mContentBodyViewHolder.getOwnerName().setText(mINewsHeaderModel.getTitle(mItem, mGroups, mProfiles));

            //TODO split to separate method. Think about how to improve readability and code support
            mContentBodyViewHolder.getTextPost().setText(StringUtils.replaceTag(mItem.getText()));
            if (mItem.getAttachments() != null) {
                if (mItem.getAttachments().size() == 1) {
                    for (int i = 0; i < mItem.getAttachments().size(); i++) {
                        if (mItem.getAttachments().get(i).getAttachmentPhoto() != null) {
                            mContentBodyViewHolder.getPhotoContent().setVisibility(View.VISIBLE);
                            mContentBodyViewHolder.getPhotoText().setText(mItem.getAttachments().get(i).getAttachmentPhoto().getPhotoText());
                            ImageLoader.getInstance().load(mItem.getAttachments().get(i).getAttachmentPhoto().getSrc()).into(mContentBodyViewHolder.getPhotoImage());

                        } else if (mItem.getAttachments().get(i).getAttachmentDoc() != null) {
                            mContentBodyViewHolder.getGifContent().setVisibility(View.VISIBLE);
                            mContentBodyViewHolder.getGifText().setText(mItem.getAttachments().get(i).getAttachmentDoc().getTitle());
                            ImageLoader.getInstance().load(mItem.getAttachments().get(i).getAttachmentDoc().getThumb()).into(mContentBodyViewHolder.getGifImage());
                            //  mImageManager.getBitmap(mItem.getAttachment().getAttachmentDoc().getThumb(), mContentBodyViewHolder.getGifImage());
                        } else if (mItem.getAttachments().get(i).getAttachmentVideo() != null) {
                            mContentBodyViewHolder.getVideoContent().setVisibility(View.VISIBLE);
                            mContentBodyViewHolder.getVideoText().setText(mItem.getAttachments().get(i).getAttachmentVideo().getTitle());
                            ImageLoader.getInstance().load(mItem.getAttachments().get(i).getAttachmentVideo().getImageVideo()).into(mContentBodyViewHolder.getVideoImage());
                            //  mImageManager.getBitmap(mItem.getAttachment().getAttachmentVideo().getImageVideo(), mContentBodyViewHolder.getVideoImage());
                        } else if (mItem.getAttachments().get(i).getAttachmentLink() != null) {
                            mContentBodyViewHolder.getLinkContent().setVisibility(View.VISIBLE);
                            mContentBodyViewHolder.getLinkText().setText(mItem.getAttachments().get(i).getAttachmentLink().getTitle());
                            ImageLoader.getInstance().load(mItem.getAttachments().get(i).getAttachmentLink().getImageSrcLink()).into(mContentBodyViewHolder.getLinkImage());
                            //mImageManager.getBitmap(mItem.getAttachment().getAttachmentLink().getImageSrcLink(), mContentBodyViewHolder.getLinkImage());
                        } else if (mItem.getAttachments().get(i).getAttachmentAudio() != null) {
                            mContentBodyViewHolder.getAudioContent().setVisibility(View.VISIBLE);
                            final View audio = LayoutInflater.from(mContext).inflate(R.layout.news_attachment_audio, null);
                            final TextView artist = audio.findViewById(R.id.title_music_text_view);
                            artist.setText(mItem.getAttachments().get(i).getAttachmentAudio().getArtist());
                            final TextView title = audio.findViewById(R.id.name_sound_text_view);
                            title.setText(mItem.getAttachments().get(i).getAttachmentAudio().getTitle());
                            final TextView duration = audio.findViewById(R.id.sound_duration_text_view);
                            duration.setText(String.valueOf(mItem.getAttachments().get(i).getAttachmentAudio().getDuration()));
                            mContentBodyViewHolder.getAudioContent().addView(audio);
                        }

                        if (mItem.getAttachments().get(i).getAttachmentAudio() != null) {
                            mContentBodyViewHolder.getAudioContent().setVisibility(View.VISIBLE);
                            final View audio = LayoutInflater.from(mContext).inflate(R.layout.news_attachment_audio, null);
                            final TextView artist = audio.findViewById(R.id.title_music_text_view);

                            if (mItem.getAttachments().get(i).getAttachmentAudio().getArtist() != null) {
                                artist.setText(mItem.getAttachments().get(i).getAttachmentAudio().getArtist());
                            }

                            final TextView title = audio.findViewById(R.id.name_sound_text_view);
                            title.setText(mItem.getAttachments().get(i).getAttachmentAudio().getTitle());
                            final TextView duration = audio.findViewById(R.id.sound_duration_text_view);
                            duration.setText(String.valueOf(mItem.getAttachments().get(i).getAttachmentAudio().getDuration()));
                            mContentBodyViewHolder.getAudioContent().addView(audio);
                        }

                    }
                }
            }

        }

        mContentBodyViewHolder.getCountLike().setText(String.valueOf(mItem.getLike().getCountLike()));

        mContentBodyViewHolder.getLikeImage().setOnClickListener(likePost);
        if (mItem.getComment().getPost() != 0)

        {
            mContentBodyViewHolder.getCommentLinearLayout().setVisibility(View.VISIBLE);
            mContentBodyViewHolder.getCountComment().setText(String.valueOf(mItem.getComment().getCount()));
        }
        mContentBodyViewHolder.getCountRepost().

                setText(String.valueOf(mItem.getRepost().getCountRepost()));
    }

    private void getNewLikesCount(final String pUrl, final ContentBodyViewHolder pContentBodyViewHolder) {
        OnLikeTask onLikeTask = new OnLikeTask(pContentBodyViewHolder);
        onLikeTask.execute(pUrl);
    }

    private View.OnClickListener likePost = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            if (mItem.getLike().getUserLike() == 0) {
                //TODO reuse it
                final String sourceOfLike = ConstantsStrings.LIKE_ADD + mItem.getType() + ITEM_ID + mItem.getPostId() + OWNER_ID + mItem.getSouseId() + ACCESS_TOKEN + getToken();
                getNewLikesCount(sourceOfLike, mContentBodyViewHolder);

                //   ((ImageView)v).setBackgroundResource(R.drawable.liked_image);
                ((ImageView) v).setImageResource(R.drawable.liked_image);
                //TODO remove param from method
                mItem.getLike().setUserLike(1);
            } else {
                final String sourceOfDislike = ConstantsStrings.LIKE_DELETE + mItem.getType() + ITEM_ID + mItem.getPostId() + OWNER_ID + mItem.getSouseId() + ACCESS_TOKEN + getToken();
                getNewLikesCount(sourceOfDislike, mContentBodyViewHolder);
                ((ImageView) v).setImageResource(R.drawable.like_image);
                mItem.getLike().setUserLike(0);
            }
        }
    };

    private String getToken() {
        final SharedPreferences sharedPreferences = MyApp.getContext().getSharedPreferences(ConstantsStrings.APP_PREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getString(ConstantsStrings.APP_TOKEN_NAME, "");
    }

}

