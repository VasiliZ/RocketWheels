package com.github.vasiliz.rocketswheel.userVkNews.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.json.vkNewsModel.Item;
@Deprecated
public class ContentAdapter extends BaseAdapter {

    private Context mContext;
    LayoutInflater mLayoutInflater;
    Item mItem;

    public ContentAdapter(Context pContext, final Item pItem) {
        this.mContext = pContext;
        this.mLayoutInflater = LayoutInflater.from(pContext);
        mItem = pItem;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(final int position) {
        return 0;
    }

    @Override
    public long getItemId(final int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.layout_news_image, parent, false);
        }

        Item item = mItem;

        ((TextView)view.findViewById(R.id.text_photo_image_view)).setText(item.getText());

        return view;
    }
}
