package com.example.sdk.features.feature2.di;



import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ActivityModule;
import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.features.feature1.routing.Feature1Router;
import com.example.sdk.features.feature1.vm.Feature1ViewModel1;
import com.example.sdk.features.feature1.vm.Feature1ViewModel2;
import com.example.sdk.features.feature2.routing.Feature2Router;
import com.example.sdk.features.feature2.vm.Feature2ViewModel1;

import toothpick.Scope;

public class Feature2Module extends ActivityModule {

    public Feature2Module(BaseActivity baseActivity, Scope scope) {
        super(baseActivity, scope);
        Feature2Router router = new Feature2Router();
        bind(BaseActivity.class).toInstance(baseActivity);
        bind(BaseRouter.class).toInstance(router);
        bind(Feature2ViewModel1.class).toInstance(new Feature2ViewModel1(router));

    }

}
