package com.example.sdk.commons.sys;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder;

public class RecyclerViewHolder extends ViewHolder {
    private ViewDataBinding binding;

    public RecyclerViewHolder(View view) {
        super(view);
        binding = DataBindingUtil.bind(view);
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}