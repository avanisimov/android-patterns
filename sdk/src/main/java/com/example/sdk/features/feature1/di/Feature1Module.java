package com.example.sdk.features.feature1.di;



import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ActivityModule;
import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.features.feature1.routing.Feature1Router;
import com.example.sdk.features.feature1.vm.Feature1ViewModel1;
import com.example.sdk.features.feature1.vm.Feature1ViewModel2;

import toothpick.Scope;

public class Feature1Module extends ActivityModule {

    public Feature1Module(BaseActivity baseActivity, Scope scope) {
        super(baseActivity, scope);
        Feature1Router feature1Router = new Feature1Router();
        bind(BaseActivity.class).toInstance(baseActivity);
        bind(BaseRouter.class).toInstance(feature1Router);
        bind(Feature1ViewModel1.class).toInstance(new Feature1ViewModel1(feature1Router));
        bind(Feature1ViewModel2.class).toInstance(new Feature1ViewModel2(feature1Router));


    }

}
