package com.example.sdk.features.feature1;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sdk.BR;
import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseFragment;
import com.example.sdk.databinding.Feature1Fragment1Binding;
import com.example.sdk.features.feature1.vm.Feature1ViewModel1;

import javax.inject.Inject;

public class Feature1Fragment1 extends BaseFragment {

    private Feature1Fragment1Binding dataBinding;

    @Inject
    Feature1ViewModel1 viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.feature1_fragment1, container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBinding.setVariable(BR.vm, viewModel);
        dataBinding.executePendingBindings();

    }
}
