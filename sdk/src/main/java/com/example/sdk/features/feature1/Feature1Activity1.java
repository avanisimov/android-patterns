package com.example.sdk.features.feature1;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.features.feature1.di.Feature1Module;
import com.example.sdk.features.feature1.routing.Feature1Screens;

import toothpick.config.Module;

public class Feature1Activity1 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        getSupportActionBar().setTitle(this.getClass().getSimpleName());

        getRouter().goTo(Feature1Screens.SCREEN_1, null);
    }

    @Override
    protected Module createModule() {
        return new Feature1Module(this, getScope());
    }
}
