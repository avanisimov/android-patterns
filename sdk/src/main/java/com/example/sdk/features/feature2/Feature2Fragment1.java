package com.example.sdk.features.feature2;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sdk.BR;
import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseFragment;
import com.example.sdk.databinding.Feature2Fragment1Binding;
import com.example.sdk.features.feature2.vm.Feature2ViewModel1;

import javax.inject.Inject;

public class Feature2Fragment1 extends BaseFragment {

    private Feature2Fragment1Binding dataBinding;

    @Inject
    Feature2ViewModel1 viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.feature2_fragment1, container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBinding.setVariable(BR.vm, viewModel);
        dataBinding.executePendingBindings();

    }
}
