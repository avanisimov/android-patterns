package com.example.sdk.features.feature3;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.features.feature3.di.Feature3Module;
import com.example.sdk.features.feature3.routing.Feature3Screens;

import toothpick.config.Module;

public class Feature3Activity1 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        getSupportActionBar().setTitle(this.getClass().getSimpleName());
        if (savedInstanceState == null) {
            getRouter().goTo(Feature3Screens.SCREEN_1, null);
        }
    }

    @Override
    protected Module createModule() {
        return new Feature3Module(this, getScope());
    }

}
