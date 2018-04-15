package com.example.sdk.features.feature1.vm;


import android.databinding.ObservableField;
import android.os.Bundle;

import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.sys.BaseViewModel;
import com.example.sdk.features.feature1.routing.Feature1Screens;

public class Feature1ViewModel1 extends BaseViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public Feature1ViewModel1(BaseRouter router) {
        super(router);
        name.set(getClass().getSimpleName() + " "+ hashCode());
    }

    public void selectDealer1() {
        Bundle args = new Bundle();
        args.putString(Feature1Screens.ARG_DEALER, "dealer1");
        getRouter().goTo(Feature1Screens.SCREEN_2, args);
    }

    public void selectDealer2() {
        Bundle args = new Bundle();
        args.putString(Feature1Screens.ARG_DEALER, "dealer2");
        getRouter().goTo(Feature1Screens.SCREEN_2, args);
    }
}
