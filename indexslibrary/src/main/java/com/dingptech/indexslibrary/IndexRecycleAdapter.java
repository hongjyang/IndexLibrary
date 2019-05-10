package com.dingptech.indexslibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public abstract class IndexRecycleAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private int mLayoutId;
    private List<T> mData;
    private LayoutInflater mInflater;
    private Context mCotext;

    public IndexRecycleAdapter(Context context, List<T> mData, int layoutId) {
        this.mData = mData;
        this.mLayoutId = layoutId;
        mInflater = LayoutInflater.from(context);
        mCotext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(mLayoutId, parent, false);
        return new BaseViewHolder(itemView, mCotext);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        convert(holder, mData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected abstract void convert(BaseViewHolder holder, T t, int position);

}
