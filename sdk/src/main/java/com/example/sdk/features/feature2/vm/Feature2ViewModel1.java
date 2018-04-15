package com.example.sdk.features.feature2.vm;


import android.databinding.ObservableField;
import android.os.Bundle;

import com.example.sdk.commons.routing.BaseRouter;
import com.example.sdk.commons.sys.BaseViewModel;
import com.example.sdk.features.feature1.routing.Feature1Screens;
import com.example.sdk.features.feature3.routing.Feature3Screens;

public class Feature2ViewModel1 extends BaseViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> result = new ObservableField<>();

    public Feature2ViewModel1(BaseRouter router) {
        super(router);
        name.set(getClass().getSimpleName() + " "+ hashCode());
    }

    public void btnOpenForResultFeature3() {
        Bundle args = new Bundle();
        String resultValue = result.get();
        if (resultValue != null) {
            args.putString(Feature3Screens.ARG_ITEM, resultValue);
        }
        getRouter()
                .goToWithResult(Feature3Screens.SCREEN_1, args)
                .subscribe(bundle -> {
                    String resultItem = bundle.getString(Feature3Screens.ARG_ITEM);
                    if (resultItem != null) {
                        result.set(resultItem);
                    }
                }, Throwable::printStackTrace);
    }

}
