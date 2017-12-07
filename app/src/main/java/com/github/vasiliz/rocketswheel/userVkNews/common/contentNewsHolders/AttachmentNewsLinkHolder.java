package com.github.vasiliz.rocketswheel.userVkNews.common.contentNewsHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.vasiliz.rocketswheel.R;

public class AttachmentNewsLinkHolder extends RecyclerView.ViewHolder {

    private TextView linkNewsTextView;

    public AttachmentNewsLinkHolder(final View itemView) {
        super(itemView);

        linkNewsTextView = itemView.findViewById(R.id.link_news_text_view);
    }

    public TextView getLinkNewsTextView() {
        return linkNewsTextView;
    }

    public void setLinkNewsTextView(final String pLinkNewsTextView) {
        linkNewsTextView.setText(pLinkNewsTextView);
    }
}
