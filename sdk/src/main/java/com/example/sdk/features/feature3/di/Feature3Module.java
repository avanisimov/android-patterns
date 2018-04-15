package com.example.sdk.features.feature3.di;



import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ActivityModule;
import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.features.feature3.routing.Feature3Router;
import com.example.sdk.features.feature3.vm.Feature3ViewModel1;

import toothpick.Scope;

public class Feature3Module extends ActivityModule {

    public Feature3Module(BaseActivity baseActivity, Scope scope) {
        super(baseActivity, scope);
        Feature3Router router = new Feature3Router();
        bind(BaseActivity.class).toInstance(baseActivity);
        bind(BaseRouter.class).toInstance(router);
        bind(Feature3ViewModel1.class).toInstance(new Feature3ViewModel1(router));

    }

}
