package com.example.sdk.features.firstfeature.activities;

import android.os.Bundle;

import com.example.sdk.commons.sys.ViewBinder;

import javax.inject.Inject;
import javax.inject.Named;

public class FirstFeatureListActivity extends FirstFeatureBaseActivity {

    public static final String NAME = "first_feature_list";

    @Inject
    @Named(NAME)
    ViewBinder viewBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinder.setContentView(this);
        registerViewModel(viewBinder.getBaseViewModel());
    }
}
