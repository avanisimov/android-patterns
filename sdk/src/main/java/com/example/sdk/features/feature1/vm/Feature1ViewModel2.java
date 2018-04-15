package com.example.sdk.features.feature1.vm;


import android.databinding.ObservableField;
import android.os.Bundle;

import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.sys.BaseViewModel;
import com.example.sdk.features.feature1.routing.Feature1Screens;

public class Feature1ViewModel2 extends BaseViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> dealer = new ObservableField<>();

    public Feature1ViewModel2(BaseRouter router) {
        super(router);
        name.set(getClass().getSimpleName() + " "+ hashCode());
    }

    public void openFragment3() {
        getRouter().goTo(Feature1Screens.SCREEN_3, null);
    }

    public void setArguments(Bundle arguments) {
        dealer.set(arguments.getString(Feature1Screens.ARG_DEALER));
    }
}
