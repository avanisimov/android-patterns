package com.example.sdk.features.feature2;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.features.feature2.di.Feature2Module;
import com.example.sdk.features.feature2.routing.Feature2Screens;

import toothpick.config.Module;

public class Feature2Activity1 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        getSupportActionBar().setTitle(this.getClass().getSimpleName());
        if (savedInstanceState == null) {
            getRouter().goTo(Feature2Screens.SCREEN_1, null);
        }
    }

    @Override
    protected Module createModule() {
        return new Feature2Module(this, getScope());
    }
}