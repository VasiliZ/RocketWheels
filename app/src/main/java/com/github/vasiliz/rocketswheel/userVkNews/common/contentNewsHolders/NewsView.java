//package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;
//
//import android.content.Context;
//import android.support.v7.widget.CardView;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.github.vasiliz.rocketswheel.R;
//import com.github.vasiliz.rocketswheel.imageLoader.ImageManager;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Group;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
//import com.github.vasiliz.rocketswheel.json.vkNewsModel.Profiles;
//
//import java.util.List;
//@Deprecated
//public class NewsView extends CardView {
//
//    public static final int TYPE_ITEM_PHOTO = 1;
//    public static final int TYPE_ITEM_DOC = 2;
//    public static final int TYPE_ITEM_LINK = 3;
//    public static final int TYPE_ITEM_VIDEO = 4;
//    public static final int TYPE_ITEM_AUDIO = 5;
//
//    private TextView mHeaderText;
//    private ImageView mHeaderImage;
//    private FrameLayout bodyContent;
//    private Item mItem;
//    private List<Group> mGroups;
//    private List<Profiles> mProfiles;
//    private INewsHeaderModel mINewsHeaderModel = new NewsHeaderModel();
//    private IBodyModel mIBodyModel;
//    private CardView mCardView;
//    private ImageManager mImageManager = new ImageManager();
//    private Context mContext;
//    private View mLinkAttachment;
//    private TextView mTextLikes;
//    private TextView mTextComments;
//    private TextView mTextReposts;
//
//    public NewsView(final Context context) {
//        super(context);
//    }
//
//    public NewsView(final Context context, final AttributeSet attrs) {
//        super(context, attrs);
//
//    }
//
//    public NewsView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//
//    }
//
//    public void setView(final View pView) {
//        mCardView = (CardView) pView;
//        mContext = getContext();
//        mHeaderText = mCardView.findViewById(R.id.title_news_text_view);
//        mHeaderImage = mCardView.findViewById(R.id.photo_news_image_view);
//        bodyContent = mCardView.findViewById(R.id.body_news_frame_view);
//    }
//
//    public void setDataNews(final Item pItem, final List<Group> pGroups, final List<Profiles> pProfiles) {
//        mItem = pItem;
//        mGroups = pGroups;
//        mProfiles = pProfiles;
//    }
//
//    public int getItemType(final Item pItem) {
//        if (pItem.getAttachment() != null) {
//            if (pItem.getAttachment().getTypeAttachment().equals("photo")) {
//                return TYPE_ITEM_PHOTO;
//            } else if (pItem.getAttachment().getTypeAttachment().equals("video")) {
//                return TYPE_ITEM_VIDEO;
//            } else if (pItem.getAttachment().getTypeAttachment().equals("doc")) {
//                return TYPE_ITEM_DOC;
//            } else if (pItem.getAttachment().getTypeAttachment().equals("link")) {
//                return TYPE_ITEM_LINK;
//            } else if ((pItem.getAttachment().getTypeAttachment().equals("audio"))) {
//                return TYPE_ITEM_AUDIO;
//            }
//        }
//        return 0;
//    }
//
//    public void setContent() {
//
//        initHeader();
//        initBody(getItemType(mItem));
//        initFooter();
//
//    }
//
//    private void initFooter() {
//        mTextLikes = mCardView.findViewById(R.id.likes_count_text_view);
//        mTextLikes.setText(String.valueOf(mItem.getLike().getCountLike()));
//        mTextComments = mCardView.findViewById(R.id.comments_count_text_view);
//        mTextComments.setText(String.valueOf(mItem.getComment().getCount()));
//        mTextReposts = mCardView.findViewById(R.id.repost_count_text_view);
//        mTextReposts.setText(String.valueOf(mItem.getRepost().getCountRepost()));
//
//    }
//
//    private void initHeader() {
//        mHeaderText.setText(mINewsHeaderModel.getTitle(mItem, mGroups, mProfiles));
//        mINewsHeaderModel.setTitleImage(mItem, mGroups, mProfiles, mImageManager, mHeaderImage);
//
//    }
//
//    private void initBody(int itemType) {
//        bodyContent.removeAllViews();
//        TextView mainTextNews = mCardView.findViewById(R.id.text_news_text_view);
//        if (!(mItem.getText().equals("")) || !(mItem.getText() == (null))) {
//            mainTextNews.setVisibility(VISIBLE);
//            String newsText = mItem.getText();
//            mainTextNews.setText(newsText);
//        } else {
//            mainTextNews.setVisibility(GONE);
//        }
//
//        Log.d("Tag", mItem.getPostType());
//
//        if ("post".equals(mItem.getPostType())) {
//            if (!(mItem.getAttachments() == null)) {
//                if (mItem.getAttachments().size() == 1) {
//                    switch (itemType) {
//                        case TYPE_ITEM_PHOTO:
//                            mIBodyModel = new NewsBodyImageModel();
//                            mIBodyModel.setContentToBodyNews(bodyContent, mContext, mItem, mImageManager);
//                            break;
//
//                        case TYPE_ITEM_VIDEO:
//                            mIBodyModel = new NewsBodyVideoModel();
//                            mIBodyModel.setContentToBodyNews(bodyContent, mContext, mItem, mImageManager);
//                            break;
//
//                        case TYPE_ITEM_DOC:
//                            mIBodyModel = new NewsBodyDocModel();
//                            mIBodyModel.setContentToBodyNews(bodyContent, mContext, mItem, mImageManager);
//                            break;
//
//                        case TYPE_ITEM_LINK:
//                            mIBodyModel = new NewsBodyLinkModel();
//                            mIBodyModel.setContentToBodyNews(bodyContent, mContext, mItem, mImageManager);
//                            break;
//
//                        case TYPE_ITEM_AUDIO:
//                            mIBodyModel = new NewsBodyAudioModel();
//                            mIBodyModel.setContentToBodyNews(bodyContent, mContext, mItem, mImageManager);
//
//                    }
//                }
//            }
//
//        } else if ("copy".equals(mItem.getPostType())) {
//            mainTextNews.setVisibility(GONE);
//            mLinkAttachment = LayoutInflater.from(getContext()).inflate(R.layout.news_attachment_link, bodyContent, true);
//            TextView textView = mLinkAttachment.findViewById(R.id.link_news_text_view);
//            textView.setText(mItem.getText());
//        }
//    }
//}
//
//
