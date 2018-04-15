package com.example.sdk.features.feature1.vm;


import android.databinding.ObservableField;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.sys.BaseViewModel;
import com.example.sdk.features.feature1.routing.Feature1Screens;
import com.example.sdk.features.feature2.routing.Feature2Screens;

import javax.inject.Inject;

public class Feature1ViewModel3 extends BaseViewModel {

    public final ObservableField<String> name = new ObservableField<>();

    @Inject
    public Feature1ViewModel3(BaseRouter router) {
        super(router);
        name.set(getClass().getSimpleName() + " " + hashCode());
    }

    public void goToFeature2() {
        getRouter().goTo(Feature2Screens.SCREEN_1, null);
    }

}
