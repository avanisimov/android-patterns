package com.example.sdk.commons.sys;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.sdk.BR;
import com.example.sdk.commons.models.ModelAbstract;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

public class DataBindingRenderer<M extends ModelAbstract> extends ViewRenderer<M, RecyclerViewHolder> {

    private @LayoutRes int resId;
    private OnItemClickListener<M> clickListener = null;

    public DataBindingRenderer(@NonNull Class<M> type, @NonNull Context context, @LayoutRes int resId, OnItemClickListener<M> clickListener) {
        super(type, context);
        this.resId = resId;
        this.clickListener = clickListener;
    }

    @Override
    public void bindView(@NonNull M model, @NonNull RecyclerViewHolder holder) {
        holder.getBinding().setVariable(BR.vm, model);
        holder.getBinding().executePendingBindings();

        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null)
                clickListener.onItemClick(model);
        });

    }

    @NonNull
    @Override
    public RecyclerViewHolder createViewHolder(@Nullable ViewGroup parent) {
        return new RecyclerViewHolder(LayoutInflater.from(getContext()).inflate(resId, parent, false));
    }

    public interface OnItemClickListener<M extends ModelAbstract> {
        void onItemClick(M item);
    }
}