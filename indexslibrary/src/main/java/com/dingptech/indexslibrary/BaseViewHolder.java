package com.dingptech.indexslibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mView;
    private Context mContext;

    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        mView = new SparseArray<>();
        mContext = context;
    }


    public <T extends View> T getView(int viewId) {
        View view = mView.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mView.put(viewId, view);
        }
        return (T) view;
    }

    public BaseViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public BaseViewHolder setVisibility(int viewId, int visibility) {
        TextView tv = getView(viewId);
        tv.setVisibility(visibility);
        return this;
    }

    public BaseViewHolder setImage(int viewId, int path) {
        ImageView iv = getView(viewId);
        iv.setImageResource(path);
        return this;
    }

    public BaseViewHolder setImage(int viewId, String url) {
        ImageView iv = getView(viewId);
        Glide.with(mContext).load(url).into(iv);
        return this;
    }
}
